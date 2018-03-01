package com.example.android.pms_victory;

/**
 * Created by tomas on 01/08/2017.
 * Class @Storage to store information gathered by application
 */

public class Storage {


    String mAddress = "Unknown";
    String mOwnership = "Unknown";
    String mSellOrRent = "Unknown";
    String mPropertyType = "Unknown";
    String mEICR = "Unknown";
    String mEPC = "Unknown";
    String mGC = "Unknown";
    String mPAT = "Unknown";
    String mCooker = "Unknown";
    String mFridge = "Unknown";
    String mWasher = "Unknown";
    String mRenovationRequired = "N/A";
    String mAvailability = "Unknown";
    int mPrice;
    String mBillsIncluded = "Unknown";
    String mNoOfRooms = "Unknown";
    String mFurnished = "Unknown";
    String mNoOfBathrooms = "Unknown";
    String mNoOfToilets = "Unknown";
    String mToiletsInBathrooms = "Unknown";
    String mGarden = "Unknown";
    String mDriveway = "Unknown";
    String mCarpark = "Unknown";
    String mPath = "Unknown";
    String mComments = "Unknown";
    String mDirectoryPath = "";


    double lat;
    double lgn;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLgn() {
        return lgn;
    }

    public void setLgn(double lgn) {
        this.lgn = lgn;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    @Override
    public String toString() {
        String newAddress = mAddress.replace(",", "_");
        //newAddress.replace(',', '.');

        String string = newAddress +  ", " + mOwnership +  ", " + mSellOrRent +  ", "
            + mPropertyType +  ", " + mEICR +  ", " + mEPC +  ", " + mGC +  ", "
            + mPAT +  ", " + mCooker +  ", " + mFridge +  ", " + mWasher +  ", "
            + mRenovationRequired + ", "
            + mAvailability +  ", " + mPrice +  ", " + mBillsIncluded +  ", "
            + mNoOfRooms +  ", " + mFurnished +  ", " + mNoOfBathrooms +  ", "
            + mNoOfToilets +  ", " + mToiletsInBathrooms +  ", " + mGarden +  ", "
            + mDriveway +  ", " + mCarpark +  ", " + mComments +  ", " + mDirectoryPath;
        return string;
    }
}

//    String string = newAddress +  ", " + mOwnership +  ", " + mSellOrRent +  ", "
//            + mPropertyType +  ", " + mEICR +  ", " + mEPC +  ", " + mGC +  ", "
//            + mPAT +  ", " + mCooker +  ", " + mFridge +  ", " + mWasher +  ", "
//            + mRenovationRequired + ", "
//            + mAvailability +  ", " + mPrice +  ", " + mBillsIncluded +  ", "
//            + mNoOfRooms +  ", " + mFurnished +  ", " + mNoOfBathrooms +  ", "
//            + mNoOfToilets +  ", " + mToiletsInBathrooms +  ", " + mGarden +  ", "
//            + mDriveway +  ", " + mCarpark +  ", " + mComments +  ", " + mDirectoryPath;