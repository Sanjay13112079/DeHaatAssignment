package com.dehaat.dehaatassignment;

import android.content.Context;
import android.content.SharedPreferences;

import com.dehaat.dehaatassignment.App;

public class SharedPrefUtils {

    static final SharedPreferences sPreferennce;
    static final SharedPreferences.Editor editor;

    static {

        sPreferennce= App.context.getSharedPreferences("deHaatSharedPref", Context.MODE_PRIVATE);
        editor=sPreferennce.edit();
    }


    public static void updatePreference(String key,String value)
    {
      editor.putString(key,value);
      editor.apply();
    }

    public static boolean contains(String key)
    {
        return sPreferennce.contains(key);
    }



    public static void  clear()
    {
        editor.clear();
        editor.apply();
    }
}
