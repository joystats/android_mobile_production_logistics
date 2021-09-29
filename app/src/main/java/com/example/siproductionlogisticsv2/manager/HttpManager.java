package com.example.siproductionlogisticsv2.manager;

import android.content.Context;

import com.example.siproductionlogisticsv2.Contextor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private Context mContext;
    private ApiService service;
    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) {
            instance = new HttpManager();
        }
        return instance;
    }

    private HttpManager() {
        mContext = Contextor.getInstance().getContext();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                // .baseUrl("http://192.168.217.1:4000/pallet/")
                .baseUrl("http://192.168.5.25:4000/pallet/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }
}
