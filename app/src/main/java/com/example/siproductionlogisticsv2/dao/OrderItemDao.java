package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OrderItemDao implements Parcelable {
    @SerializedName("job_id")
    private String jobId;
    @SerializedName("job_name")
    private String jobName;
    @SerializedName("part_name")
    private String partName;
    @SerializedName("sig")
    private String sig;
    @SerializedName("out_bound")
    private String outBound;
    @SerializedName("in_bound")
    private String inBound;
    @SerializedName("amount")
    private String amount;
    @SerializedName("wait_time")
    private int waitTime;
    @SerializedName("order_code")
    private String orderCode;


    protected OrderItemDao(Parcel in) {
        jobId = in.readString();
        jobName = in.readString();
        partName = in.readString();
        sig = in.readString();
        outBound = in.readString();
        inBound = in.readString();
        amount = in.readString();
        waitTime = in.readInt();
        orderCode = in.readString();
    }

    public static final Creator<OrderItemDao> CREATOR = new Creator<OrderItemDao>() {
        @Override
        public OrderItemDao createFromParcel(Parcel in) {
            return new OrderItemDao(in);
        }

        @Override
        public OrderItemDao[] newArray(int size) {
            return new OrderItemDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(jobId);
        dest.writeString(jobName);
        dest.writeString(partName);
        dest.writeString(sig);
        dest.writeString(outBound);
        dest.writeString(inBound);
        dest.writeString(amount);
        dest.writeString(orderCode);
        dest.writeInt(waitTime);
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getInBound() {
        return inBound;
    }

    public void setInBound(String inBound) {
        this.inBound = inBound;
    }

    public static Creator<OrderItemDao> getCREATOR() {
        return CREATOR;
    }
}
