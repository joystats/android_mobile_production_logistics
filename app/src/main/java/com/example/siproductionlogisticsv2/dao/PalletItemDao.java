package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PalletItemDao implements Parcelable {
    @SerializedName("pallet_id")
    private int palletId;
    @SerializedName("pallet_code")
    private String palletCode;

    @SerializedName("job_id")
    private String jobId;
    @SerializedName("part_name")
    private String partName;
    @SerializedName("sig")
    private String sig;
    @SerializedName("out_bound")
    private String outBound;
    @SerializedName("in_bound")
    private String inBound;
    @SerializedName("wait_time")
    private int waitTime;
    @SerializedName("finish_time")
    private String finishTime;

    @SerializedName("is_express")
    private int isExpress;

    @SerializedName("status_name")
    private String statusName;
    @SerializedName("status_id")
    private int statusId;
    @SerializedName("created")
    private Date created;

    protected PalletItemDao(Parcel in) {
        palletId = in.readInt();
        palletCode = in.readString();
        jobId = in.readString();
        partName = in.readString();
        sig = in.readString();
        outBound = in.readString();
        inBound = in.readString();
        statusName = in.readString();
        finishTime = in.readString();
        waitTime = in.readInt();
        statusId = in.readInt();
        isExpress =  in.readInt();
    }

    public static final Creator<PalletItemDao> CREATOR = new Creator<PalletItemDao>() {
        @Override
        public PalletItemDao createFromParcel(Parcel in) {
            return new PalletItemDao(in);
        }

        @Override
        public PalletItemDao[] newArray(int size) {
            return new PalletItemDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(palletId);
        dest.writeString(palletCode);
        dest.writeString(jobId);
        dest.writeString(partName);
        dest.writeString(sig);
        dest.writeString(outBound);
        dest.writeString(inBound);
        dest.writeString(statusName);
        dest.writeString(finishTime);
        dest.writeInt(waitTime);
        dest.writeInt(statusId);
        dest.writeInt(isExpress);
    }

    public int getPalletId() {
        return palletId;
    }

    public void setPalletId(int palletId) {
        this.palletId = palletId;
    }

    public String getPalletCode() {
        return palletCode;
    }

    public void setPalletCode(String palletCode) {
        this.palletCode = palletCode;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getOutBound() {
        return outBound;
    }

    public void setOutBound(String outBound) {
        this.outBound = outBound;
    }

    public String getInBound() {
        return inBound;
    }

    public void setInBound(String inBound) {
        this.inBound = inBound;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getExpress() {
        return isExpress;
    }

    public void setExpress(int express) {
        isExpress = express;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public static Creator<PalletItemDao> getCREATOR() {
        return CREATOR;
    }
}
