package com.example.siproductionlogisticsv2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.view.PalletListActiveItem;

public class PalletActiveAdapter extends BaseAdapter {

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
        PalletListActiveItem item;
        if (convertView != null) {
            item = (PalletListActiveItem) convertView;
        } else {
            item = new PalletListActiveItem(parent.getContext());
        }
        item.setPalletCode(dao.getData().get(position).getPalletCode());
        item.setJobId(dao.getData().get(position).getJobId());
        item.setPartName(dao.getData().get(position).getPartName());
        item.setSig(dao.getData().get(position).getSig());
        item.setOutBound(dao.getData().get(position).getOutBound());
        item.setInBound(dao.getData().get(position).getInBound());
        item.setWaitTime(dao.getData().get(position).getWaitTime());
        item.setStatusName(dao.getData().get(position).getStatusName());
        item.setWaitTimeDefaultColor();
        if (dao.getData().get(position).getStatusId() == 2) {
            if (dao.getData().get(position).getWaitTime() > 10) {
                item.setWaitTimeColorRed();
            }
        }else{
            if (dao.getData().get(position).getWaitTime() > 5) {
                item.setWaitTimeColorRed();
            }
        }

        if (dao.getData().get(position).getStatusId() == 2) {
            item.setStatusNameColorOrange();
        }
        if (dao.getData().get(position).getStatusId() == 3) {
            item.setStatusNameColorGreen();
        }
        if (dao.getData().get(position).getStatusId() == 4) {
            item.setStatusNameColorBlue();
        }
        return item;
    }

    public void setDao(PalletItemCollectionDao dao) {
        this.dao = dao;
    }

    public PalletItemCollectionDao getDao() {
        return this.dao;
    }
}
