package com.example.siproductionlogisticsv2.manager;

import android.content.Context;

import com.example.siproductionlogisticsv2.Contextor;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;

public class PalletManager {
    private Context mContext;
    private static PalletManager instance;
    private PalletItemCollectionDao collectionDao;

    public static PalletManager getInstance() {
        if (instance == null) {
            instance = new PalletManager();
        }
        return instance;
    }

    private PalletManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public PalletItemCollectionDao getCollectionDao() {
        return collectionDao;
    }

    public void setCollectionDaoAtTopPosition(PalletItemCollectionDao collectionDao) {
        this.collectionDao.getData().addAll(0, collectionDao.getData());
    }

    public void setCollectionDao(PalletItemCollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }
}
