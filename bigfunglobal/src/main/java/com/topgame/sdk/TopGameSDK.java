package com.topgame.sdk;


import static com.topgame.sdk.TopGameUtils.xqnEwo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.OnAttributionChangedListener;
import com.tendcloud.tenddata.TDGAProfile;
import com.tendcloud.tenddata.TalkingDataGA;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

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

    public static void init(Application mContext, String AdjustAppToken, String TalkingDatId, String TalkingDatChannelCode) {
        context=mContext.getApplicationContext();
        TalkingDataGA.init(mContext, TalkingDatId, TalkingDatChannelCode);
        TDGAProfile.setProfile(TalkingDataGA.getDeviceId(mContext));
        AdjustConfig acaaigxc = new AdjustConfig(mContext, AdjustAppToken, AdjustConfig.ENVIRONMENT_PRODUCTION);
        //获取时间
        rgqwtime = xaPhax();
        //获取Adjust的配置数据
        acaaigxc.setOnAttributionChangedListener(new OnAttributionChangedListener() {
            @Override
            public void onAttributionChanged(AdjustAttribution atibunt) {
                try {
//                    fbgv.put("trackerName",atibunt.trackerName);
                    fbgv.put("network", atibunt.network);
                    fbgv.put("campaign", atibunt.campaign);
                    long afterTime = xaPhax();
                    long sub = afterTime - rgqwtime;
                    fbgv.put("timesub", sub);
                    SharedPreferences sp = mContext.getSharedPreferences(mContext.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("adAttri", fbgv.toString());
                    editor.commit();
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy", "gyInfo", fbgv.toString());
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy", "attrInfo", atibunt.toString());
                    Log.d("staApplication", "atibunt: " + fbgv.toString());
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

    public static void setListener(TopGameListener listener){
        TopGameUtils.getInstance().naciulmlkn(context,listener);
    }
    public static void onDestroy(){
        TopGameUtils.getInstance().PlCFEe();
    }

}
