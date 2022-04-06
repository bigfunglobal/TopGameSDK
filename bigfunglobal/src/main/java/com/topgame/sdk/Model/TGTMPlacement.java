//package com.topgame.sdk.Model;
//
//import com.bigfun.sdk.model.TMISPlacement;
//import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;
//
//public class TGTMPlacement {
//    private int mPlacementId;
//    private String mPlacementName;
//    private boolean mIsDefault;
//    private String mRewardName;
//    private int mRewardAmount;
//    private PlacementAvailabilitySettings mPlacementAvailabilitySettings;
//
//    public TGTMPlacement(TMISPlacement var1) {
//        this.mPlacementId = var1.getPlacementId();
//        this.mPlacementName = var1.getPlacementName();
//        this.mRewardName = var1.getRewardName();
//        this.mIsDefault = var1.isDefault();
//        this.mRewardAmount = var1.getRewardAmount();
//        this.mPlacementAvailabilitySettings=var1.getPlacementAvailabilitySettings();
//    }
//    public int getPlacementId() {
//        return this.mPlacementId;
//    }
//
//    public String getPlacementName() {
//        return this.mPlacementName;
//    }
//
//    public boolean isDefault() {
//        return this.mIsDefault;
//    }
//
//    public String getRewardName() {
//        return this.mRewardName;
//    }
//
//    public int getRewardAmount() {
//        return this.mRewardAmount;
//    }
//
//    public PlacementAvailabilitySettings getPlacementAvailabilitySettings() {
//        return this.mPlacementAvailabilitySettings;
//    }
//
//    public String toString() {
//        return "placement name: " + this.mPlacementName + ", reward name: " + this.mRewardName + " , amount: " + this.mRewardAmount;
//    }
//}
