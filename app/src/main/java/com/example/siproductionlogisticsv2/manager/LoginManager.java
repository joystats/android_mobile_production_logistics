package com.example.siproductionlogisticsv2.manager;

import android.content.Context;

import com.example.siproductionlogisticsv2.Contextor;
import com.example.siproductionlogisticsv2.dao.LoginCollectionDao;

public class LoginManager {
    private Context mContext;
    private static LoginManager instance;
    LoginCollectionDao collectionDao;

    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    private LoginManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public LoginCollectionDao getLoginDao() {
        return collectionDao;
    }

    public void setLoginDao(LoginCollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }
}
