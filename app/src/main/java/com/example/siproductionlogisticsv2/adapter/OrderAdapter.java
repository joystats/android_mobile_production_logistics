package com.example.siproductionlogisticsv2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.siproductionlogisticsv2.dao.OrderItemCollectionDao;
import com.example.siproductionlogisticsv2.view.OrderListItem;

public class OrderAdapter extends BaseAdapter {
    OrderItemCollectionDao dao;

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
        OrderListItem item;
        if(convertView==null){
            item = new OrderListItem(parent.getContext());
        }else{
            item = (OrderListItem) convertView;
        }

        item.setJobId(dao.getData().get(position).getJobId());
        item.setJobName(dao.getData().get(position).getJobName());
        item.setPartName((dao.getData().get(position).getPartName()=="")?"-":dao.getData().get(position).getPartName());
        item.setSig(dao.getData().get(position).getSig());
        item.setOutBound(dao.getData().get(position).getOutBound());
        item.setInBound(dao.getData().get(position).getInBound());
        item.setAmount(dao.getData().get(position).getAmount());
        item.setWaitTime(dao.getData().get(position).getWaitTime());
        item.setOrderCode(dao.getData().get(position).getOrderCode());

        return item;
    }

    public OrderItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(OrderItemCollectionDao dao) {
        this.dao = dao;
    }
}
