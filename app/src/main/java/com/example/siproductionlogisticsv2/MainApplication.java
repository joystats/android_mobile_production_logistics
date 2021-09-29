package com.example.siproductionlogisticsv2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MainApplication extends Application {
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
        mContext = Contextor.getInstance().getContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SharedPreferences pref = mContext.getSharedPreferences("dummy", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }
}
