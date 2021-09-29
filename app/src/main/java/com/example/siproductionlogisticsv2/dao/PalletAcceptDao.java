package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PalletAcceptDao implements Parcelable {
    @SerializedName("success")
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    protected PalletAcceptDao(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
    }

    public static final Creator<PalletAcceptDao> CREATOR = new Creator<PalletAcceptDao>() {
        @Override
        public PalletAcceptDao createFromParcel(Parcel in) {
            return new PalletAcceptDao(in);
        }

        @Override
        public PalletAcceptDao[] newArray(int size) {
            return new PalletAcceptDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
    }
}
