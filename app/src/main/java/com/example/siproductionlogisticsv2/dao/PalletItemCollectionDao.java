package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PalletItemCollectionDao implements Parcelable {
    @SerializedName("success")
    private Boolean success;
    @SerializedName("data") private List<PalletItemDao> data;

    protected PalletItemCollectionDao(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        data = in.createTypedArrayList(PalletItemDao.CREATOR);
    }

    public static final Creator<PalletItemCollectionDao> CREATOR = new Creator<PalletItemCollectionDao>() {
        @Override
        public PalletItemCollectionDao createFromParcel(Parcel in) {
            return new PalletItemCollectionDao(in);
        }

        @Override
        public PalletItemCollectionDao[] newArray(int size) {
            return new PalletItemCollectionDao[size];
        }
    };

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PalletItemDao> getData() {
        return data;
    }

    public void setData(List<PalletItemDao> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        dest.writeTypedList(data);
    }
}
