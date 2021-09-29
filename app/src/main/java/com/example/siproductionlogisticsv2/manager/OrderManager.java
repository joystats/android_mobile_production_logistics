package com.example.siproductionlogisticsv2.manager;

import android.content.Context;

import com.example.siproductionlogisticsv2.Contextor;
import com.example.siproductionlogisticsv2.dao.OrderItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;

public class OrderManager {
    private Context mContext;
    private static OrderManager instance;
    private OrderItemCollectionDao collectionDao;

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    private OrderManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public OrderItemCollectionDao getCollectionDao() {
        return collectionDao;
    }

    public void setCollectionDaoAtTopPosition(OrderItemCollectionDao collectionDao) {
        this.collectionDao.getData().addAll(0, collectionDao.getData());
    }

    public void setCollectionDao(OrderItemCollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }
}
