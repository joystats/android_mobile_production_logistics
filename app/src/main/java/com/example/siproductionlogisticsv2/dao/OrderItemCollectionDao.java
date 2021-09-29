package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderItemCollectionDao implements Parcelable {
    @SerializedName("success")
    private Boolean success;
    @SerializedName("data")
    private List<OrderItemDao> data;

    protected OrderItemCollectionDao(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        data = in.createTypedArrayList(OrderItemDao.CREATOR);
    }

    public static final Creator<OrderItemCollectionDao> CREATOR = new Creator<OrderItemCollectionDao>() {
        @Override
        public OrderItemCollectionDao createFromParcel(Parcel in) {
            return new OrderItemCollectionDao(in);
        }

        @Override
        public OrderItemCollectionDao[] newArray(int size) {
            return new OrderItemCollectionDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        dest.writeTypedList(data);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<OrderItemDao> getData() {
        return data;
    }

    public void setData(List<OrderItemDao> data) {
        this.data = data;
    }
}
