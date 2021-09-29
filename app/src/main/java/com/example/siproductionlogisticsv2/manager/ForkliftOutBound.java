package com.example.siproductionlogisticsv2.manager;

import android.content.Context;

import com.example.siproductionlogisticsv2.Contextor;

public class ForkliftOutBound {
    private Context mContext;
    private static ForkliftOutBound instance;

    private Boolean zoneA1 = false;
    private Boolean zoneA2 = false;
    private Boolean zoneB = false;
    private Boolean zoneC = false;
    private Boolean zoneD = false;
    private Boolean zoneE = false;
    private Boolean zoneF = false;
    private Boolean zoneG = false;
    private Boolean zoneGMP = false;
    private Boolean zoneH = false;
    private Boolean zoneI = false;
    private Boolean zoneJ = false;
    private Boolean zoneK = false;
    private Boolean zoneOEM = false;
    private Boolean zoneFG = false;

    public static ForkliftOutBound getInstance() {
        if (instance == null) {
            instance = new ForkliftOutBound();
        }
        return instance;
    }

    private ForkliftOutBound() {
        mContext = Contextor.getInstance().getContext();
    }

    public Boolean getZoneA1() {
        return zoneA1;
    }

    public void setZoneA1(Boolean zoneA1) {
        this.zoneA1 = zoneA1;
    }

    public Boolean getZoneA2() {
        return zoneA2;
    }

    public void setZoneA2(Boolean zoneA2) {
        this.zoneA2 = zoneA2;
    }

    public Boolean getZoneB() {
        return zoneB;
    }

    public void setZoneB(Boolean zoneB) {
        this.zoneB = zoneB;
    }

    public Boolean getZoneC() {
        return zoneC;
    }

    public void setZoneC(Boolean zoneC) {
        this.zoneC = zoneC;
    }

    public Boolean getZoneD() {
        return zoneD;
    }

    public void setZoneD(Boolean zoneD) {
        this.zoneD = zoneD;
    }

    public Boolean getZoneE() {
        return zoneE;
    }

    public void setZoneE(Boolean zoneE) {
        this.zoneE = zoneE;
    }

    public Boolean getZoneF() {
        return zoneF;
    }

    public void setZoneF(Boolean zoneF) {
        this.zoneF = zoneF;
    }

    public Boolean getZoneG() {
        return zoneG;
    }

    public void setZoneG(Boolean zoneG) {
        this.zoneG = zoneG;
    }

    public Boolean getZoneGMP() {
        return zoneGMP;
    }

    public void setZoneGMP(Boolean zoneGMP) {
        this.zoneGMP = zoneGMP;
    }

    public Boolean getZoneH() {
        return zoneH;
    }

    public void setZoneH(Boolean zoneH) {
        this.zoneH = zoneH;
    }

    public Boolean getZoneI() {
        return zoneI;
    }

    public void setZoneI(Boolean zoneI) {
        this.zoneI = zoneI;
    }

    public Boolean getZoneJ() {
        return zoneJ;
    }

    public void setZoneJ(Boolean zoneJ) {
        this.zoneJ = zoneJ;
    }

    public Boolean getZoneK() {
        return zoneK;
    }

    public void setZoneK(Boolean zoneK) {
        this.zoneK = zoneK;
    }

    public Boolean getZoneOEM() {
        return zoneOEM;
    }

    public void setZoneOEM(Boolean zoneOEM) {
        this.zoneOEM = zoneOEM;
    }

    public Boolean getZoneFG() {
        return zoneFG;
    }

    public void setZoneFG(Boolean zoneFG) {
        this.zoneFG = zoneFG;
    }

    public void clearZone(){
        this.zoneA1=false;
        this.zoneA2=false;
        this.zoneB=false;
        this.zoneC=false;
        this.zoneD=false;
        this.zoneE=false;
        this.zoneF=false;
        this.zoneG=false;
        this.zoneGMP=false;
        this.zoneH=false;
        this.zoneI=false;
        this.zoneJ=false;
        this.zoneK=false;
        this.zoneOEM=false;
        this.zoneFG=false;
    }
}
