package com.topgame.sdk.Listener;

import androidx.annotation.Keep;

import com.android.billingclient.api.BillingResult;
@Keep
public interface TGGoogleConsumePurchaseListener {
    @Keep
    void onConsumePurchase(BillingResult billingResult, String purchaseToken);
}
