package com.topgame.sdk.Listener;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;

import java.util.List;

@Keep
public interface TGGoogleQueryPurchaseListener {
    @Keep
    void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list);
}
