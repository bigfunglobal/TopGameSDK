package com.topgame.sdk.Model;

import com.bigfun.sdk.model.BFLoginModel;
import com.bigfun.sdk.model.ISPlacement;
import com.ironsource.mediationsdk.model.l;

public class TGPlacement {
    private int a;
    private String b;
    private boolean c;
    private String d;
    private int e;
    private l f;



    public TGPlacement(ISPlacement var1) {
        this.a = var1.getPlacementId();
        this.b = var1.getPlacementName();
        this.c = var1.isDefault();
        this.f = var1.getPlacementAvailabilitySettings();
    }

    public int getPlacementId() {
        return this.a;
    }

    public String getPlacementName() {
        return this.b;
    }

    public boolean isDefault() {
        return this.c;
    }

    public String getRewardName() {
        return this.d;
    }

    public int getRewardAmount() {
        return this.e;
    }

    public String toString() {
        return "placement name: " + this.b + ", reward name: " + this.d + " , amount: " + this.e;
    }

    public l getPlacementAvailabilitySettings() {
        return this.f;
    }
}

