package com.dehaat.dehaatassignment.rest;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRestClient {

    private static AppRestClient mInstance;
    int cacheSize = 10 * 1024 * 1024; // 10 MB
    private AppRestClientService appRestClientService;
    private OkHttpClient okHttpClient;

    private AppRestClient() {
        setRestClient();
    }

    public static AppRestClient getInstance() {
        if (mInstance == null) {
            synchronized (AppRestClient.class) {
                if (mInstance == null)
                    mInstance = new AppRestClient();
            }
        }
        return mInstance;
    }

    public static void setAppRestClientNull() {
        mInstance = null;
    }

    private void setRestClient() {

        okHttpClient=new OkHttpClient.Builder()
                .cache(new Cache(new File("app_cache"),cacheSize))
                .build();
    }



    public AppRestClientService getAppRestClientService(String baseUrl)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        appRestClientService = retrofit.create(AppRestClientService.class);

        return appRestClientService;
    }

}
