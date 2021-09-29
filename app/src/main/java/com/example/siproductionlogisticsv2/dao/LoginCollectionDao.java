package com.example.siproductionlogisticsv2.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginCollectionDao implements Parcelable {
    public LoginCollectionDao() {
    }

    @SerializedName("success")
    private Boolean success;

    @SerializedName("emp_id")
    private String empId;

    @SerializedName("emp_name")
    private String empName;

    @SerializedName("data")
    private List<LoginDao> data;

    @SerializedName("forklift_outbound")
    private List<ForkliftOutboundDao> forkliftOutbound;

    protected LoginCollectionDao(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        empId = in.readString();
        empName = in.readString();
        data = in.createTypedArrayList(LoginDao.CREATOR);
        forkliftOutbound = in.createTypedArrayList(ForkliftOutboundDao.CREATOR);
    }

    public static final Creator<LoginCollectionDao> CREATOR = new Creator<LoginCollectionDao>() {
        @Override
        public LoginCollectionDao createFromParcel(Parcel in) {
            return new LoginCollectionDao(in);
        }

        @Override
        public LoginCollectionDao[] newArray(int size) {
            return new LoginCollectionDao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        dest.writeString(empId);
        dest.writeString(empName);
        dest.writeTypedList(data);
        dest.writeTypedList(forkliftOutbound);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<LoginDao> getData() {
        return data;
    }

    public void setData(List<LoginDao> data) {
        this.data = data;
    }

    public List<ForkliftOutboundDao> getForkliftOutbound() {
        return forkliftOutbound;
    }

    public void setForkliftOutbound(List<ForkliftOutboundDao> forkliftOutbound) {
        this.forkliftOutbound = forkliftOutbound;
    }
}


