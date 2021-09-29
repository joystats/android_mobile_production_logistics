package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PalletScanDao implements Parcelable {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("finish_transfer")
    private Boolean finishTransfer;

    protected PalletScanDao(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        byte tmpFinishTransfer = in.readByte();
        finishTransfer = tmpFinishTransfer == 0 ? null : tmpFinishTransfer == 1;
    }

    public static final Creator<PalletScanDao> CREATOR = new Creator<PalletScanDao>() {
        @Override
        public PalletScanDao createFromParcel(Parcel in) {
            return new PalletScanDao(in);
        }

        @Override
        public PalletScanDao[] newArray(int size) {
            return new PalletScanDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        dest.writeByte((byte) (finishTransfer == null ? 0 : finishTransfer ? 1 : 2));
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getFinishTransfer() {
        return finishTransfer;
    }

    public void setFinishTransfer(Boolean finishTransfer) {
        this.finishTransfer = finishTransfer;
    }
}
