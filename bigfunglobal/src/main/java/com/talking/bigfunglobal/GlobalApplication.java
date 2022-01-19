package com.talking.bigfunglobal;

import static com.talking.bigfunglobal.utils.JudgeSpAB.xqnEwo;

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
import com.talking.bigfunglobal.model.TdwdiVvOyKn;
import com.talking.bigfunglobal.utils.AdjustUtils;
import com.talking.bigfunglobal.utils.InstallReferrer;
import com.talking.bigfunglobal.utils.JudgeSpAB;
import com.tendcloud.tenddata.TDGAProfile;
import com.tendcloud.tenddata.TalkingDataGA;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class GlobalApplication extends Application {
    private static long rgqwtime = 0;
    private static GlobalApplication buvvbivh;
    private static String appToken="";//"749xmt9mstmo"
    private static String TalkingDatId="";
    private static String TalkingDatName="";
    private static String SPName="";
    private static int SPModel;
    public static GlobalApplication getInstance() {
        return buvvbivh;
    }
    private static JSONObject fbgv = new JSONObject();
    //获取时间
    public static long xaPhax() {
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        buvvbivh=this;
        AdjustUtils.getInstance();
        JudgeSpAB.getInstance();
        InstallReferrer.getInstance();
        init();
//初始化TD
    }
    private void init(){
        Log.e("onCreateGlobal","onCreateGlobal"+TalkingDatId);
        TalkingDataGA.init(getInstance(), TalkingDatId, TalkingDatName);
        TDGAProfile.setProfile(TalkingDataGA .getDeviceId(getInstance()));
        AdjustConfig acaaigxc = new AdjustConfig(getInstance(),appToken , AdjustConfig.ENVIRONMENT_PRODUCTION);
        //获取时间
        rgqwtime = xaPhax();
        //获取Adjust的配置数据
        acaaigxc.setOnAttributionChangedListener(new OnAttributionChangedListener() {
            @Override
            public void onAttributionChanged(AdjustAttribution atibunt) {
                try {
//                    fbgv.put("trackerName",atibunt.trackerName);
                    fbgv.put("network",atibunt.network);
                    fbgv.put("campaign",atibunt.campaign);
                    long afterTime = xaPhax();
                    long sub = afterTime - rgqwtime;
                    fbgv.put("timesub",sub);
                    SharedPreferences sp = AdjustUtils.getSharedPreferences(getInstance(),SPName, SPModel);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("adAttri",fbgv.toString());
                    editor.commit();
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy","gyInfo",fbgv.toString());
                    TdwdiVvOyKn.WKeeNM("A_Ev_Adgy","attrInfo",atibunt.toString());
                    Log.d("staApplication", "atibunt: "+fbgv.toString());
                    if(sp.getInt("completeRef",0) == 2){
                        //已经获取gogglereffer了
                        Log.e("TAGerf", "mkit6: ");
                        editor.putInt("completeADJ",1);
                        editor.commit();
                        xqnEwo("");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Adjust.onCreate(acaaigxc);
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
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

    public GlobalApplication(String appToken,String TalkingDatId,String TalkingDatName,String SPName,int SPModel){
        this.appToken=appToken;
        this.TalkingDatId=TalkingDatId;
        this.TalkingDatName=TalkingDatName;
        this.SPName=SPName;
        this.SPModel=SPModel;
    }

    public GlobalApplication(){

    }


}
