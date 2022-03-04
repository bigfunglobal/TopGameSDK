package com.topgame.sdk;


import static com.topgame.sdk.TopGameUtils.xqnEwo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.OnAttributionChangedListener;

import com.bigfun.sdk.BigFunSDK;
import com.bigfun.sdk.LogUtils;
import com.bigfun.sdk.NetWork.BFRewardedVideoListener;
import com.bigfun.sdk.login.LoginListener;
import com.bigfun.sdk.login.ShareListener;
import com.bigfun.sdk.model.BFLoginModel;
import com.bigfun.sdk.model.BFShareModel;
import com.bigfun.sdk.model.ISPlacement;
import com.bigfun.sdk.type.AdBFSize;
import com.facebook.share.model.ShareContent;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.tendcloud.tenddata.TDGAProfile;
import com.tendcloud.tenddata.TalkingDataGA;
import com.topgame.sdk.Listener.TGLoginListener;
import com.topgame.sdk.Listener.TGRewardedVideoListener;
import com.topgame.sdk.Listener.TGShareListener;
import com.topgame.sdk.Model.TGLoginModel;
import com.topgame.sdk.Model.TGPlacement;
import com.topgame.sdk.Model.TGShareModel;
import com.topgame.sdk.Utils.SizeUtils;
import com.topgame.sdk.type.AdTGSize;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TopGameSDK {
    private static Context context;
    private static long rgqwtime = 0;
    private static boolean aBoolean=false;
    private static JSONObject fbgv = new JSONObject();

    //获取时间
    public static long xaPhax() {
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
    }

    @SuppressLint("NewApi")
    public static void init(Application mContext, String AdjustAppToken, String TalkingDataAppId,String TGChannelCode) {
        context=mContext.getApplicationContext();
        BigFunSDK.init(mContext,TGChannelCode);
        TalkingDataGA.init(context, TalkingDataAppId, "TopGameSwitch");
        TDGAProfile.setProfile(TalkingDataGA.getDeviceId(context));
        AdjustConfig acaaigxc = new AdjustConfig(context, AdjustAppToken, AdjustConfig.ENVIRONMENT_PRODUCTION);
        //获取时间
        rgqwtime = xaPhax();
        //获取Adjust的配置数据
        acaaigxc.setOnAttributionChangedListener(new OnAttributionChangedListener() {
            @Override
            public void onAttributionChanged(AdjustAttribution atibunt) {
                try {
//                    fbgv.put("trackerName",atibunt.trackerName);
//                    Log.e("AdjustAttribution",atibunt.toString());
                    fbgv.put("network", atibunt.network);
                    fbgv.put("campaign", atibunt.campaign);
                    long afterTime = xaPhax();
                    long sub = afterTime - rgqwtime;
                    fbgv.put("timesub", sub);
                    SharedPreferences sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("adAttri", fbgv.toString());
                    editor.commit();
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy", "gyInfo", fbgv.toString());
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy", "attrInfo", atibunt.toString());
                    LogUtils.log("staApplication："+"atibunt: " + fbgv.toString());
                    if (sp.getInt("completeRef", 0) == 2) {
                        //已经获取gogglereffer了
                        Log.e("TAGerf", "mkit6: ");
                        editor.putInt("completeADJ", 1);
                        editor.commit();
                        xqnEwo();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Adjust.onCreate(acaaigxc);
        mContext.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(final Activity activity) {
                Adjust.onResume();

            }

            @Override
            public void onActivityPaused(Activity activity) {
                Adjust.onPause();
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    /**
     * 获取开关，True获取到了开关,false是没有获取到开关
     * @return
     */
    @Keep
    public static boolean getSwitch(){
        return TopGameUtils.getInstance().SwitchReferrer(context);
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
        BigFunSDK.onDestroy();
    }

    /**
     *用户来源
     */
    @Keep
    public static void getSourceUser(){
        TopGameUtils.getInstance().SourceUser(context);
    }
    /**
     * 获取设备ID
     * @return
     */
    @Keep
    public static String getDeviceId(){
        return TalkingDataGA.getDeviceId();
    }

    /**
     * 数据事件埋点
     * @param context
     * @param eventId
     * @param map
     */
    @Keep
    public static void onEvent(Context context, String eventId, Map map) {
        BigFunSDK.onEvent(context,eventId,map);
    }

    /**
     * 展示横屏广告
     * @param frameLayout
     * @param adBFSize
     */
    @Keep
    public static void ShowBanner(FrameLayout frameLayout, AdTGSize adBFSize){
        BigFunSDK.ShowBanner(frameLayout, SizeUtils.TGSize(adBFSize));
    }

    /**
     * 展示插页广告
     */
    @Keep
    public static void ShowInterstitialAdLoadAd(){
        BigFunSDK.ShowInterstitialAdLoadAd();
    }

    /**
     * 奖励视屏广告，广告回调
     * @param listener
     */
    @Keep
    public static void ShowRewardedVideo(TGRewardedVideoListener listener){
        BigFunSDK.ShowRewardedVideo(new BFRewardedVideoListener() {
            @Override
            public void onRewardedVideoAdClosed() {
                listener.onRewardedVideoAdClosed();
            }

            @Override
            public void onRewardedVideoAdRewarded(ISPlacement placement) {
                listener.onRewardedVideoAdRewarded(new TGPlacement(placement));
            }
        });
    }

    /**
     * 是否是调试模式
     * @param debug
     */
    @Keep
    public static void setDebug(boolean debug) {
        BigFunSDK.setDebug(true);
    }

    /**
     *Google 登录
     * @param activity
     */
    @Keep
    public static void TGLogin(Activity activity){
        BigFunSDK.BigFunLogin(activity);
    }

    public static final int SIGN_LOGIN = BigFunSDK.SIGN_LOGIN;

    @Keep
    public static SignInClient TGIdentity(Activity activity) {
        return Identity.getSignInClient(activity);
    }
    /**
     * FB的登录
     * @param context
     * @param listener
     */
    @Keep
    public static void TGLogin(Context context, TGLoginListener listener){
        BigFunSDK.BigFunLogin(context, new LoginListener() {
            @Override
            public void onCancel() {
                listener.onCancel();
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }

            @Override
            public void onComplete(BFLoginModel loginResult) {
                listener.onComplete(new TGLoginModel(loginResult));
            }
        });
    }

    /**
     * FB的分享
     * @param context
     * @param linkContent
     * @param listener
     */
    @Keep
    public static void TGShare(Context context, ShareContent linkContent, TGShareListener listener){
        BigFunSDK.BigFunShare(context, linkContent, new ShareListener() {
            @Override
            public void onCancel() {
                listener.onCancel();
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }

            @Override
            public void onComplete(BFShareModel result) {
                listener.onComplete(new TGShareModel(result));
            }
        });
    }

    /**
     * 文本分享
     * @param activity
     * @param textContent
     */
    @Keep
    public static void TGShare(Context activity, String textContent){
        BigFunSDK.BigFunShare(context,textContent);
    }

    /**
     * 媒体文件
     * @param activity
     * @param shareFileUri
     */
    @Keep
    public static void TGShare(Context activity, Uri shareFileUri){
        BigFunSDK.BigFunShare(context,shareFileUri);
    }

    /**
     * 退出登录
     */
    @Keep
    public static void Logout(){
        BigFunSDK.BigFunLogout();
    }

    /**
     * FB返回 回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Keep
    public static void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        BigFunSDK.onActivityResult(requestCode, resultCode, data);
    }
}
