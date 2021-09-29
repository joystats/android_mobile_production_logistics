package com.example.siproductionlogisticsv2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.view.PalletListItem;

public class PalletAdapter extends BaseAdapter {

    PalletItemCollectionDao dao;

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PalletListItem item;
        if (convertView != null) {
            item = (PalletListItem) convertView;
        } else {
            item = new PalletListItem(parent.getContext());
        }
        item.setPalletCode(dao.getData().get(position).getPalletCode());
        item.setJobId(dao.getData().get(position).getJobId());
        item.setPartName(dao.getData().get(position).getPartName());
        item.setSig(dao.getData().get(position).getSig());
        item.setOutBound(dao.getData().get(position).getOutBound());
        item.setInBound(dao.getData().get(position).getInBound());
        item.setWaitTime(dao.getData().get(position).getWaitTime());
        if (dao.getData().get(position).getWaitTime() > 10) {
            item.setWaitTimeColor();
        }
        /*if (dao.getData().get(position).getExpress()) {
            item.setCardViewLayoutRed();
        }*/
        return item;
    }

    public void setDao(PalletItemCollectionDao dao) {
        this.dao = dao;
    }

    public PalletItemCollectionDao getDao() {
        return this.dao;
    }
}
