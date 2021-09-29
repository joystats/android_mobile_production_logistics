package com.example.siproductionlogisticsv2;

import android.content.Context;

public class Contextor {
    private Context mContext;
    private static Contextor instance;
    public static Contextor getInstance(){
        if(instance==null){
            instance = new Contextor();
        }
        return instance;
    }

    private Contextor(){

    }

    public void init(Context m){
        mContext = m;
    }
    public Context getContext(){
        return mContext;
    }
}
