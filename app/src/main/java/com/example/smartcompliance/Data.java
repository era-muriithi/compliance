package com.example.smartcompliance;

import androidx.annotation.NonNull;

/**
 * Created by 2ndgengod on 1/18/2021.
 */

public class Data {
    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getmHaulier() {
        return mHaulier;
    }

    public void setmHaulier(String mHaulier) {
        this.mHaulier = mHaulier;
    }

    public String getmDelivery() {
        return mDelivery;
    }

    public void setmDelivery(String mDelivery) {
        this.mDelivery = mDelivery;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmDestination(String mDestination) {
        this.mDestination = mDestination;
    }

    public String getmVariance() {
        return mVariance;
    }

    public void setmVariance(String mVariance) {
        this.mVariance = mVariance;
    }

    public String getmLoaded() {
        return mLoaded;
    }

    public void setmLoaded(String mLoaded) {
        this.mLoaded = mLoaded;
    }

    public String getmReplace() {
        return mReplace;
    }

    public void setmReplace(String mReplace) {
        this.mReplace = mReplace;
    }

    public String getmUnderOver() {
        return mUnderOver;
    }

    public void setmUnderOver(String mUnderOver) {
        this.mUnderOver = mUnderOver;
    }

    public Data() {

    }

    public Data(String mValue, String mHaulier, String mDelivery, String mDestination, String mVariance, String mLoaded, String mReplace, String mUnderOver) {
        this.mValue = mValue;
        this.mHaulier = mHaulier;
        this.mDelivery = mDelivery;
        this.mDestination = mDestination;
        this.mVariance = mVariance;
        this.mLoaded = mLoaded;
        this.mReplace = mReplace;
        this.mUnderOver = mUnderOver;
    }

    String mValue, mHaulier, mDelivery, mDestination, mVariance, mLoaded, mReplace, mUnderOver;

    @NonNull
    @Override
    public String toString() {
        return
                mValue+System.getProperty("line.separator")+
                        "Haulier: " +mHaulier+System.getProperty("line.separator")+
                        "Delivery No: "+mDelivery+System.getProperty("line.separator")+
                        "Destination: "+mDestination+System.getProperty("line.separator")+
                        "Variance: "+mVariance+System.getProperty("line.separator")+
                        "Loaded: "+mLoaded+System.getProperty("line.separator")+
                        "Replace: "+mReplace+System.getProperty("line.separator")+
                        "UnderOver: "+mUnderOver;
    }
}
