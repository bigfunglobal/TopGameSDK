package com.topgame.sdk;


import static com.topgame.sdk.TopGameUtils.BkwaonSJf;
import static com.topgame.sdk.Utils.KadfauJalsd.SourceUser;
import static com.topgame.sdk.Utils.KadfauJalsd.SwitchReferrer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
//import com.android.billingclient.api.BillingResult;
//import com.android.billingclient.api.Purchase;
//import com.android.billingclient.api.SkuDetails;
//
//import com.bigfun.sdk.BigFunSDK;
//import com.bigfun.sdk.ExceptionHandler;
//import com.bigfun.sdk.LogUtils;
//import com.bigfun.sdk.NetWork.BFRewardedVideoListener;
//
//import com.bigfun.sdk.listener.BFAdjustListener;
//import com.bigfun.sdk.listener.BFSuccessListener;
//import com.bigfun.sdk.listener.GoogleCommodityListener;
//import com.bigfun.sdk.listener.GoogleConsumePurchaseListener;
//import com.bigfun.sdk.listener.GoogleQueryPayListener;
//import com.bigfun.sdk.listener.GoogleQueryPurchaseListener;
//import com.bigfun.sdk.listener.LoginListener;
//import com.bigfun.sdk.listener.ShareListener;
//import com.bigfun.sdk.model.BFLoginModel;
//import com.bigfun.sdk.model.BFShareModel;
//import com.bigfun.sdk.model.ISPlacement;
//
//import com.facebook.share.model.ShareContent;

import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.OnAttributionChangedListener;
import com.tendcloud.tenddata.TCAgent;

//import com.topgame.sdk.Listener.TGGoogleCommodityListener;
//import com.topgame.sdk.Listener.TGGoogleConsumePurchaseListener;
//import com.topgame.sdk.Listener.TGGoogleQueryPayListener;
//import com.topgame.sdk.Listener.TGGoogleQueryPurchaseListener;
//import com.topgame.sdk.Listener.TGLoginListener;
//import com.topgame.sdk.Listener.TGRewardedVideoListener;
//
//
//import com.topgame.sdk.Listener.TGShareListener;
import com.topgame.sdk.Listener.TopGameListener;
//import com.topgame.sdk.Model.TGLoginModel;
//import com.topgame.sdk.Model.TGPlacement;
//import com.topgame.sdk.Model.TGShareModel;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class TopGameSDK {
    private static Context context;
    private static Application application;
    private static long rgqwtime = 0;
    private static JSONObject fbgv = new JSONObject();
    static boolean isDebug = false;
    static String environment="";
    //获取时间
    public static long xaPhax() {
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
    }

    @SuppressLint("NewApi")
    @Keep
    public static void init(Application mContext, String at,String ti) {
        context=mContext.getApplicationContext();
        environment=AdjustConfig.ENVIRONMENT_PRODUCTION;
        application=mContext;
        TCAgent.init(context, ti, context.getPackageName());
        TCAgent.setProfileId(TCAgent.getDeviceId(context));
        AdjustConfig ajehjxac = new AdjustConfig(context, at, environment);
        rgqwtime = xaPhax();
        ajehjxac.setOnAttributionChangedListener(new OnAttributionChangedListener() {
            @Override
            public void onAttributionChanged(AdjustAttribution attribution) {
                try {
                    fbgv.put("network", attribution.network);
                    fbgv.put("campaign", attribution.campaign);
                    long afterTime = xaPhax();
                    long sub = afterTime - rgqwtime;
                    fbgv.put("timesub", sub);
                    SharedPreferences sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("adAttri", fbgv.toString());
                    editor.commit();
                    TwlkHifdwa.hfowaEfa(context, "A_Ev_Adgy", "gyInfo", fbgv.toString());
                    TwlkHifdwa.hfowaEfa(context, "A_Ev_Adgy", "attrInfo", attribution.toString());

                    if (sp.getInt("completeRef", 0) == 2) {
                        //已经获取gogglereffer了
                        Log.e("TAGerf", "mkit6: ");
                        editor.putInt("completeADJ", 1);
                        editor.commit();
                        BkwaonSJf();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Adjust.onCreate(ajehjxac);

        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Adjust.onResume();
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Adjust.onPause();
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }
    /**
     * 设置是否是Debug模式
     *
     * @param debug
     */

    public static void setDebug(boolean debug) {
        environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        isDebug = debug;
    }
//    @SuppressLint("NewApi")
//    @Keep
//    public static void init(Application mContext, String TGChannelCode) {
//        context=mContext.getApplicationContext();
//        //获取时间
//        rgqwtime = xaPhax();
//        tpinit(mContext,TGChannelCode,null,null);
//    }
//    @SuppressLint("NewApi")
//    @Keep
//    public static void init(Application mContext, String TGChannelCode,TGAdjustListener alistener,TGSuccessListener slistener) {
//        context=mContext.getApplicationContext();
//        //获取时间
//        rgqwtime = xaPhax();
//        tpinit(mContext,TGChannelCode,alistener,slistener);
//    }
//
//    @SuppressLint("NewApi")
//    @Keep
//    public static void init(Application mContext, String TGChannelCode, TGAdjustListener listener) {
//        context=mContext.getApplicationContext();
//        rgqwtime = xaPhax();
//        tpinit(mContext,TGChannelCode,listener,null);
//    }
//    @SuppressLint("NewApi")
//    @Keep
//    public static void init(Application mContext, String TGChannelCode, TGSuccessListener listener) {
//        context=mContext.getApplicationContext();
//        rgqwtime = xaPhax();
//        tpinit(mContext,TGChannelCode,null,listener);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private static void tpinit(Application mContext, String TGChannelCode, TGAdjustListener listener,TGSuccessListener slistener){
//        ExceptionHandler.install(new ExceptionHandler.CustomExceptionHandler() {
//            @Override
//            public void handlerException(Thread thread, Throwable throwable) {
//                Log.e("SDK", throwable.getMessage());
//            }
//        });
//
//        BigFunSDK.init(mContext, TGChannelCode, new BFAdjustListener() {
//            @Override
//            public void onAttributionChanged(AdjustAttribution attribution) {
//                if (listener != null)
//                    listener.onAttributionChanged(attribution);
//                try {
////                    fbgv.put("trackerName",atibunt.trackerName);
////                    Log.e("AdjustAttribution",atibunt.toString());
//                    fbgv.put("network", attribution.network);
//                    fbgv.put("campaign", attribution.campaign);
//                    long afterTime = xaPhax();
//                    long sub = afterTime - rgqwtime;
//                    fbgv.put("timesub", sub);
//                    SharedPreferences sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString("adAttri", fbgv.toString());
//                    editor.commit();
//                    TdwdiVvOyKn.hfowaEfa(context, "A_Ev_Adgy", "gyInfo", fbgv.toString());
//                    TdwdiVvOyKn.hfowaEfa(context, "A_Ev_Adgy", "attrInfo", attribution.toString());
//                    LogUtils.log("staApplication：" + "atibunt: " + fbgv.toString());
//                    if (sp.getInt("completeRef", 0) == 2) {
//                        //已经获取gogglereffer了
//                        Log.e("TAGerf", "mkit6: ");
//                        editor.putInt("completeADJ", 1);
//                        editor.commit();
//                        BkwaonSJf();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new BFSuccessListener() {
//            @Override
//            public void onSuccess() {
//                if(slistener!=null)
//                    slistener.onSuccess();
//                TDUtils.TDinit(context,BigFunSDK.getTDID(),"TopGameSDk");
//            }
//        });
//
//    }




    /**
     * 获取开关，True获取到了开关,false是没有获取到开关
     * @return
     */

    @Keep
    public static boolean getSwitch(){
        return SwitchReferrer(context);
    }

    /**
     * listener 是否开关
     * @param listener
     */
    @Keep
    public static void setListener(TopGameListener listener){
        TopGameUtils.getInstance().naciulmlkn(context,listener);
    }

    /**
     * 释放资源
     */
    @Keep
    public static void onDestroy(){
        TopGameUtils.getInstance().PlCFEe();
//        BigFunSDK.onDestroy();
    }

    /**
     *用户来源
     */
    @Keep
    public static String getSourceUser(){
        return SourceUser(context);
    }

    /**
//     * 获取设备ID
//     * @return
//     */
    @Keep
    public static String getDeviceId(){
        return TCAgent.getDeviceId(context);
//        return BigFunSDK.getDeviceId();
    }

//    @Keep
//    public static String getOAID(){
//        return BigFunSDK.getOAID();
//    }

    /**
     * 数据事件埋点
     * @param context
     * @param eventId
     * @param map
     */
//    @Keep
//    public static void onEvent(Context context, String eventId, Map map) {
//        BigFunSDK.onEvent(context,eventId,map);
//    }
//
//    @Keep
//    public static void onEvent(String eventId, Map map) {
//        BigFunSDK.onEvent(eventId,map);
//    }
//
//    @Keep
//    public static void onEvent(String eventId) {
//        BigFunSDK.onEvent(eventId);
//    }
//
//    @Keep
//    public static void TrackEvent(String eventId){
//        BigFunSDK.TrackEvent(eventId);
//    }
//
//    @Keep
//    public static void TrackEvent(String eventId, String id){
//        BigFunSDK.TrackEvent(eventId,id);
//    }


//    /**
//     * 是否真机
//     * @return
//     */
//    @Keep
//    public static boolean fictitious(){
//        return BigFunSDK.fictitious();
//    }

//    /**
//     * 手机设备信息
//     * @return
//     */
//    @Keep
//    public static String SuspiciousEquipment(){
//        return BigFunSDK.SuspiciousEquipment();
//    }

//    /**
//     *内购商品的展示
//     * @param googleCommodityListener
//     */
//    @Keep
//    public static void GoogleQueryPay(TGGoogleCommodityListener googleCommodityListener){
//        BigFunSDK.googleQueryPay(new GoogleCommodityListener() {
//            @Override
//            public void onSkuDetailsResponse(@NonNull BillingResult billingResult, @Nullable List<SkuDetails> skuDetailsList) {
//                googleCommodityListener.onSkuDetailsResponse(billingResult,skuDetailsList);
//            }
//        });
//    }
//
//    /**
//     * 已购买的未消费的商品
//     * @param queryPurchaseListener
//     */
//    @Keep
//    public static void GoogleQueryPurchase(TGGoogleQueryPurchaseListener queryPurchaseListener){
//        BigFunSDK.googleQueryPurchase(new GoogleQueryPurchaseListener() {
//            @Override
//            public void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list) {
//                queryPurchaseListener.onQueryPurchasesResponse(billingResult,list);
//            }
//        });
//    }
//
//    /**
//     * 内购商品的购买，回调确认购买
//     * @param activity
//     * @param skuDetails
//     * @param googleQueryPayListener
//     */
//    @Keep
//    public static void InitiatePurchaseFlow(Activity activity, final SkuDetails skuDetails, TGGoogleQueryPayListener googleQueryPayListener){
//        BigFunSDK.initiatePurchaseFlow(activity, skuDetails, new GoogleQueryPayListener() {
//            @Override
//            public void onPurchaseResponse(@NonNull BillingResult billingResult) {
//                googleQueryPayListener.onPurchaseResponse(billingResult);
//            }
//        });
//    }
//
//    /**
//     * 消费购买的商品
//     * @param purchase
//     * @param purchaseListener
//     */
//    @Keep
//    public static void GoogleConsumePurchase(Purchase purchase, TGGoogleConsumePurchaseListener purchaseListener){
//        BigFunSDK.consumePurchase(purchase, new GoogleConsumePurchaseListener() {
//            @Override
//            public void onConsumePurchase(BillingResult billingResult, String purchaseToken) {
//                purchaseListener.onConsumePurchase(billingResult,purchaseToken);
//            }
//        });
//    }

//    /**
//     * 展示横屏广告
//     * @param frameLayout
//     * @param adBFSize
//     */
//    @Keep
//    public static void ShowBanner(FrameLayout frameLayout, AdTGSize adBFSize){
//        BigFunSDK.ShowBanner(frameLayout, SizeUtils.TGSize(adBFSize));
//    }

//    /**
//     * 展示插页广告
//     */
//    @Keep
//    public static void ShowInterstitialAdLoadAd(){
//        BigFunSDK.ShowInterstitialAdLoadAd();
//    }
//
//    /**
//     * 奖励视屏广告，广告回调
//     * @param listener
//     */
//
//    /**
//     * 奖励视屏广告，广告回调
//     * @param listener
//     */
//    @Keep
//    public static void ShowRewardedVideo(TGTMRewardedVideoListener listener){
//        if(listener!=null) {
//            BigFunSDK.ShowRewardedVideo(new BFTMRewardedVideoListener() {
//                @Override
//                public void onRewardedVideoAdOpened() {
//                    listener.onRewardedVideoAdOpened();
//                }
//
//                @Override
//                public void onRewardedVideoAdClosed() {
//                    listener.onRewardedVideoAdClosed();
//                }
//
//                @Override
//                public void onRewardedVideoAvailabilityChanged(boolean b) {
//                    listener.onRewardedVideoAvailabilityChanged(b);
//                }
//
//                @Override
//                public void onRewardedVideoAdStarted() {
//                    listener.onRewardedVideoAdStarted();
//                }
//
//                @Override
//                public void onRewardedVideoAdEnded() {
//                    listener.onRewardedVideoAdEnded();
//                }
//
//                @Override
//                public void onRewardedVideoAdRewarded(TMISPlacement placement) {
//                    listener.onRewardedVideoAdRewarded(new TGTMPlacement(placement));
//                }
//
//                @Override
//                public void onRewardedVideoAdShowFailed(String ironSourceError) {
//                    listener.onRewardedVideoAdShowFailed(ironSourceError);
//                }
//
//                @Override
//                public void onRewardedVideoAdClicked(TMISPlacement placement) {
//                    listener.onRewardedVideoAdClicked(new TGTMPlacement(placement));
//                }
//
//            });
//        }
//        else
//            BigFunSDK.ShowRewardedVideo();
//    }

//    @Keep
//    public static void ShowRewardedVideo(TGRewardedVideoListener listener){
//        if(listener!=null) {
//            BigFunSDK.ShowRewardedVideo(new BFRewardedVideoListener() {
//                @Override
//                public void onRewardedVideoAdClosed() {
//                    listener.onRewardedVideoAdClosed();
//                }
//
//                @Override
//                public void onRewardedVideoAdRewarded(ISPlacement placement) {
//                    listener.onRewardedVideoAdRewarded(new TGPlacement(placement));
//                }
//            });
//        }else {
//            BigFunSDK.ShowRewardedVideo();
//        }
//    }
//
//    @Keep
//    public static void ShowRewardedVideo(){
//        BigFunSDK.ShowRewardedVideo();
//    }
//    /**
//     * 是否是调试模式
//     * @param debug
//     */
//    @Keep
//    public static void setDebug(boolean debug) {
//        BigFunSDK.setDebug(true);
//    }
//
//    /**
//     *Google 登录
//     * @param activity
//     */
//    @Keep
//    public static void TGLogin(Activity activity){
//        BigFunSDK.BigFunLogin(activity);
//    }
//    @Keep
//    public static final int SIGN_GP_LOGIN = BigFunSDK.SIGN_GP_LOGIN;
//
//    @Keep
//    public static String onResult(int requestCode, int resultCode, @Nullable Intent data) {
//        return BigFunSDK.onResult(requestCode, resultCode, data);
//    }
//    /**
//     * FB的登录
//     * @param context
//     * @param listener
//     */
//    @Keep
//    public static void TGLogin(Context context, TGLoginListener listener){
//        BigFunSDK.BigFunLogin(context, new LoginListener() {
//            @Override
//            public void onCancel() {
//                listener.onCancel();
//            }
//
//            @Override
//            public void onError(String error) {
//                listener.onError(error);
//            }
//
//            @Override
//            public void onComplete(BFLoginModel loginResult) {
//                listener.onComplete(new TGLoginModel(loginResult));
//            }
//        });
//    }
//
//    /**
//     * FB的分享
//     * @param context
//     * @param linkContent
//     * @param listener
//     */
//    @Keep
//    public static void TGShare(Context context, ShareContent linkContent, TGShareListener listener){
//        BigFunSDK.BigFunShare(context, linkContent, new ShareListener() {
//            @Override
//            public void onCancel() {
//                listener.onCancel();
//            }
//
//            @Override
//            public void onError(String error) {
//                listener.onError(error);
//            }
//
//            @Override
//            public void onComplete(BFShareModel result) {
//                listener.onComplete(new TGShareModel(result));
//            }
//        });
//    }
//
//    /**
//     * 文本分享
//     * @param activity
//     * @param textContent
//     */
//    @Keep
//    public static void TGShare(Context activity, String textContent){
//        BigFunSDK.BigFunShare(context,textContent);
//    }
//
//    /**
//     * 媒体文件
//     * @param activity
//     * @param shareFileUri
//     */
//    @Keep
//    public static void TGShare(Context activity, Uri shareFileUri){
//        BigFunSDK.BigFunShare(context,shareFileUri);
//    }
//
//    /**
//     * 退出登录
//     */
//    @Keep
//    public static void Logout(){
//        BigFunSDK.BigFunLogout();
//    }
//
//    /**
//     * FB返回 回调
//     * @param requestCode
//     * @param resultCode
//     * @param data
//     */
//    @Keep
//    public static void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        BigFunSDK.onActivityResult(requestCode, resultCode, data);
//    }
}
