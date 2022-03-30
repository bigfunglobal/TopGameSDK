package com.topgame.sdk;

import static com.topgame.sdk.Utils.KadfauJalsd.SJGfoakds;
import static com.topgame.sdk.Utils.KadfauJalsd.SJgasda;
import static com.topgame.sdk.Utils.KadfauJalsd.SJgfoadagf;
import static com.topgame.sdk.Utils.KadfauJalsd.ULSnfwasd;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;


import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.bigfun.sdk.BigFunSDK;
import com.bigfun.sdk.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TopGameUtils{
    private static TopGameUtils mAdjustUtils;
    private static TopGameListener mCallback;
    private static Context context;

    private static String gjaspofadasd = "";

    private static String ndklsbfn = "";

    static SharedPreferences sp;
    static String LKJNfal = "";

    static InstallReferrerClient rehskandpa;

    private static long tiemash = 10000;

    public static Map<String, String> gjaopsmfa = new HashMap<String, String>();

    private static String EVENT_REFFER = "T_G_Re";

    //初始化SMSManager
    public static synchronized TopGameUtils getInstance() {
        if (mAdjustUtils == null) {
            synchronized (TopGameUtils.class) {
                if (mAdjustUtils == null) {
                    mAdjustUtils = new TopGameUtils();
                }
            }
        }
        return mAdjustUtils;
    }


    public void naciulmlkn(Context mContext,TopGameListener listener) {
        mCallback=listener;
        context=mContext;

        gjaspofadasd = ULSnfwasd();
        sp = mContext.getSharedPreferences(mContext.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        if (1 == sp.getInt("oifbesc", 0)) {
            if (1 == sp.getInt("referrer", 0)) {
                TdwdiVvOyKn.WKeeNM(context,EVENT_REFFER, "T_A_D", "Open:");
                mCallback.onTopGameListener(true);
            } else {
                mCallback.onTopGameListener(false);
            }
            return;
        }

        stareZAzvur(mContext);
    }

    //第一次进入获取installReferrer数据进行判断
    public static void stareZAzvur(Context mContext) {

        rehskandpa = InstallReferrerClient.newBuilder(mContext).build();
        rehskandpa.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode == InstallReferrerClient.InstallReferrerResponse.OK) {
                    String installReferrer = Afpwamsp();
                    try {
                        installReferrer = URLDecoder.decode(installReferrer, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    ndklsbfn = installReferrer;
                    TdwdiVvOyKn.WKeeNM(context,EVENT_REFFER, "url", installReferrer);
                    Log.e("TAGer", "onInstallReferrerSetupFinished: " + installReferrer);

                    String[] esasr = installReferrer.split("&");
                    for (int ind = 0; ind < esasr.length; ind++) {
                        String[] narr = esasr[ind].split("=");
                        if (narr.length > 1) {
                            gjaopsmfa.put(narr[0], narr[1]);
                        }
                    }

                    JSONObject oInfo = SJGfoakds(gjaspofadasd);
                    Log.d("fwet", oInfo.toString());
                    String code = oInfo.optString("code");
                    tiemash = oInfo.optLong("timeout", 15000);//default 15s
                    String wbu = oInfo.optString("wbAdr");

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("wbAdr", wbu);
                    editor.commit();


                    boolean isGreff = SJgasda(gjaspofadasd,gjaopsmfa);

                    Log.e("isGreff", isGreff + "");
                    if (isGreff) {
                        Log.e("TDA_Re", "mkit1: ");

                        BkwaonSJf();
                        if (code.equals("0")) {
                            editor.putInt("hsdaojRef", 1);
                            editor.commit();
                        }
                    } else {
                        if (code.equals("0")) {
                            editor.putInt("hsdaojRef", 2);
                            editor.commit();
                            Log.e("TDA_Re", "mkit2: ");
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            public void run() {
                                Log.e("TDA_Re", "mkit3: ");
                                if (sp.getInt("fhasoJ", 0) != 1) {
                                    Log.e("TDA_Re", "mkit31: ");
                                    BkwaonSJf();
                                }
                            }
                        }, tiemash);

                        if (!sp.getString("klsdfsd", "").isEmpty()) {
                            Log.e("TDA_Re", "mkit4: ");
                            BkwaonSJf();
                        } else {
                            if (gjaopsmfa.get("utm_source") != null&& !gjaopsmfa.get("utm_source").isEmpty() && gjaopsmfa.get("utm_source").equals("google-play")) {
                                Log.e("TDA_Re", "mkit5: ");
                                BkwaonSJf();
                            }
                        }
                    }
                    return;
                }
                mCallback.onTopGameListener(false);
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {

            }
        });

    }


    public static void BkwaonSJf() {
        String asdwaf = sp.getString("klsdfsd", "");
        BkwaonSJf(gjaspofadasd, ndklsbfn, asdwaf);
    }

    private static void BkwaonSJf(String sevdata, String installReferrer, String adjRef) {
        boolean isGreff = SJgasda(sevdata,gjaopsmfa);

        boolean isAdjsut = SJgfoadagf(adjRef);

        SharedPreferences.Editor refeditor = sp.edit();
        refeditor.putInt("oifbesc", 1);
        refeditor.commit();
        if (isGreff || isAdjsut) {
            if (isGreff) {
                TdwdiVvOyKn.WKeeNM(context,EVENT_REFFER, "open", "ggOpen:");
            } else if (isAdjsut) {
                TdwdiVvOyKn.WKeeNM(context,EVENT_REFFER, "open", "gyOpen");
            }
            refeditor.putInt("referrer", 1);
            refeditor.putString("referrerUrl", installReferrer);
            refeditor.commit();
            TdwdiVvOyKn.WKeeNM(context,"A_referrer", "url", installReferrer);
            mCallback.onTopGameListener(true);
        } else {
            TDUtils.TDinit(context, BigFunSDK.getTDID(),"TopGameSDK_natural");
            TdwdiVvOyKn.WKeeNM(context,"A_referrer", "url", installReferrer);
            mCallback.onTopGameListener(false);
        }
    }

    private static String Afpwamsp() {
        if (rehskandpa != null) {
            ReferrerDetails referrerDetails = null;
            try {
                referrerDetails = rehskandpa.getInstallReferrer();
                String installReferrer = referrerDetails.getInstallReferrer();
//                long referrerClickTime = referrerDetails.getReferrerClickTimestampSeconds();
//                long appInstallTime = referrerDetails.getInstallBeginTimestampSeconds();
                return installReferrer;
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
        return "";
    }

    public void PlCFEe() {
        if (rehskandpa != null && rehskandpa.isReady()) {
            rehskandpa.endConnection();
            rehskandpa = null;
        }
    }

}
