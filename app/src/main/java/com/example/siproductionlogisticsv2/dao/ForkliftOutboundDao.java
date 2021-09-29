package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ForkliftOutboundDao implements Parcelable{
    public ForkliftOutboundDao() {
    }

    @SerializedName("zone_id")
    private int zoneId;

    @SerializedName("zone_name")
    private String zoneName;

    protected ForkliftOutboundDao(Parcel in) {
        zoneId = in.readInt();
        zoneName = in.readString();
    }

    public static final Creator<ForkliftOutboundDao> CREATOR = new Creator<ForkliftOutboundDao>() {
        @Override
        public ForkliftOutboundDao createFromParcel(Parcel in) {
            return new ForkliftOutboundDao(in);
        }

        @Override
        public ForkliftOutboundDao[] newArray(int size) {
            return new ForkliftOutboundDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(zoneId);
        dest.writeString(zoneName);
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
