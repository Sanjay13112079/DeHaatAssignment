package com.dehaat.dehaatassignment.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.dehaat.dehaatassignment.data.AuthorsData;

@Database(entities = {AuthorsData.Data.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;


    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "dehaat_database").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }



}
