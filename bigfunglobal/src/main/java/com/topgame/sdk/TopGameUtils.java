package com.topgame.sdk;

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
    //    //第一次保存的数据
    private static String kokacoqi = "";

    private static String rvox_gaun = "";
    private static TopGameListener mCallback;
    static SharedPreferences sp;
    private static Context context;
    static String _FINgame = "";
    private static InstallReferrerClient frqmbxmk;
    public static Map<String, String> Prgvfmnp = new HashMap<String, String>();
    private static long _ecklthmx = 10000;

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
        //第二次进入时候判断数据获取判断
        sp = mContext.getSharedPreferences(mContext.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        if (1 == sp.getInt("sendRes", 0)) {
            String url = sp.getString("refferUrl", "");
            if (1 == sp.getInt("referrer", 0)) {
                int secTyoe = sp.getInt("secOpen", 0);
                switch (secTyoe) {
                    case 1:
                        TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "ggWTOpen:");
                        break;
                    case 2:
                        TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "ggBKOpen:");
                        break;
                    case 3:
                        TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "gyOpen:");
                        break;
                }
                LogUtils.log("caseawr："+ "case2: " + secTyoe);
                mCallback.onTopGameListener(true);
            } else {
                mCallback.onTopGameListener(false);
            }
            return;
        }
        //第一次进入保存记录
        JSONObject isk = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            //reffer:白名单（,source,not set）,data：Facebook的广告，gclid,pcampaignid：google广告，adjust：adjust短链推广
            data.put("reffer", "data,gclid,pcampaignid,adjust");
            data.put("reffer_bk", "");
            data.put("timeout", 15000f);
            isk.put("data", data.toString());
            isk.put("code", "0");
            LogUtils.log("fweftar：" +"onCreate: " + isk);
            kokacoqi = isk.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        stareZAzvur(mContext);
    }

    public String SourceUser(Context context){
        if(sp==null)
            sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        String adjRefer = sp.getString("adAttri", "");
        String Adsurl = sp.getString("refferUrl", "");
        boolean isAd = rxxZGE(adjRefer);
        if(!TextUtils.isEmpty(Adsurl)){
            if(Adsurl.contains("data")){
                return "FBAds";
            }else if(Adsurl.contains("gclid")||Adsurl.contains("pcampaignid")){
                return "GGAds";
            }else if(Adsurl.contains("adjust")){
                return "AJAds";
            }else if(Adsurl.contains("google-play")&&isAd){
                return "AJAds";
            }else if(Adsurl.contains("google-play")){
                return "GooglePlay";
            }else {
                return "Other";
            }
        }
        return "";
    }

    //第一次进入获取installReferrer数据进行判断
    public static void stareZAzvur(Context mContext) {

        frqmbxmk = InstallReferrerClient.newBuilder(mContext).build();
        frqmbxmk.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode == InstallReferrerClient.InstallReferrerResponse.OK) {
                    String installReferrer = xEwNdP();
//                    installReferrer = "utm_source=(not%20set)&utm_medium=(not%20set)";
//                    installReferrer = "gclid=CjwKCAiAh_GNBhAHEiwAjOh3ZPdyYev5W2u0qaaLUIZdtHyEqQE_FffRJKkYM-E7xJvFVo-aGsCS7BoC_0cQAvD_BwE";
//                    installReferrer = "pcampaignid=inline|youtubeads|9416164";
//                    installReferrer = "utm_content=%7B%22source%22%3A%7B%22data%22%3A%2200d6e5fe5d662f5e9306d51c19761418d466185fe4d661a1d98a43ad974e8d7e2f97e1e71946a3d1b0b08237b1681f9a275ee18c3b062696d51a021304d4ff49c1f35c1c2527a30dbbcdb0be001f3419a1078ab23d801a2cce0b7c673746c185f07be35529be4fa";
                    try {
                        installReferrer = URLDecoder.decode(installReferrer, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    rvox_gaun = installReferrer;
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "url", installReferrer);
                    Log.e("TAGer", "onInstallReferrerSetupFinished: " + installReferrer);
                    //数组installReferrer转化
                    String[] wer = installReferrer.split("&");
//                    arrlist = wer;
                    for (int ind = 0; ind < wer.length; ind++) {
                        String[] narr = wer[ind].split("=");
                        if (narr.length > 1) {
                            Prgvfmnp.put(narr[0], narr[1]);
                        }
                    }
                    //解析第一次进入保存数据
                    JSONObject oInfo = JZKPbq(kokacoqi);
                    LogUtils.log("fwet："+ oInfo.toString());
                    String code = oInfo.optString("code");
                    _ecklthmx = oInfo.optLong("timeout", 15000);//default 15s
                    String wbu = oInfo.optString("wbAdr");

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("wbAdr", wbu);
                    editor.commit();

                    //解析保存的的白名单
                    //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
                    int tytp = oFZeIZ(kokacoqi);
                    boolean isGreff = false;
                    if (tytp == 0) {
                        boolean retype = FVBQDS(kokacoqi);
                        isGreff = retype;
                    } else if (tytp == 1) {
                        isGreff = false;
                    } else if (tytp == 2) {
                        isGreff = true;
                    }
                    Log.e("isGreff", isGreff + "");
                    if (isGreff) {
//                        Log.e("TAGerf", "mkit1: ");
                        //如果googleReferrer能打开
                        xqnEwo();
                        if (code.equals("0")) {
                            editor.putInt("completeRef", 1);
                            editor.commit();
                        }
                    } else {
                        if (code.equals("0")) {
                            editor.putInt("completeRef", 2);
                            editor.commit();
//                            Log.e("TAGerf", "mkit2: ");
                        }
                        //等10s adjust如果已经过来
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            public void run() {
                                //要执行的任务
//                                Log.e("TAGerf", "mkit3: ");
                                if (sp.getInt("completeADJ", 0) != 1) {
//                                    Log.e("TAGerf", "mkit31: ");
                                    xqnEwo();
                                }
                            }
                        }, _ecklthmx);

                        if (!sp.getString("adAttri", "").isEmpty()) {
//                            Log.e("TAGerf", "mkit4: ");
                            xqnEwo();
                        } else {
                            if (Prgvfmnp.get("utm_source") != null && Prgvfmnp.get("utm_source").equals("google-play")) {
//                                Log.e("TAGerf", "mkit5: ");
                                xqnEwo();
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

    public static boolean SwitchReferrer(Context context){
        sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        if (1 == sp.getInt("referrer", 0)) {
            int secTyoe = sp.getInt("secOpen", 0);
            switch (secTyoe) {
                case 1:
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "ggWTOpen:");
                    break;
                case 2:
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "ggBKOpen:");
                    break;
                case 3:
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open2", "gyOpen:");
                    break;
            }
            LogUtils.log("caseawr："+ "case2: " + secTyoe);
            return true;
        } else {
            return false;
        }
    }

    public static JSONObject JZKPbq(String result) {
        //自然量
        JSONObject oInfo = new JSONObject();
        JSONObject jdata = null;
        try {
            jdata = new JSONObject(result);
            oInfo.put("code", jdata.optString("code"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String data = jdata.optString("data");
        JSONObject obj = null;
        try {
            obj = new JSONObject(data);
            oInfo.put("wbAdr", obj.optString("wbAdr"));
            oInfo.put("ver", obj.optString("ver"));
            oInfo.put("reffer", obj.optString("reffer"));
            String timeou = obj.optString("timeout");
            long timeoutlong = Long.parseLong(timeou);
            oInfo.put("timeout", timeoutlong);

            oInfo.put("reffer_bk", obj.optString("reffer_bk"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return oInfo;
    }

    //解析保存的名单
    //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
    public static int oFZeIZ(String wej) {
//        LogUtils.log("faww4y", "oFZeIZ0: "+wej);
        JSONObject jInfo = JZKPbq(wej);
        String bk = jInfo.optString("reffer_bk");
//        LogUtils.log("faww4y", "oFZeIZ1: "+bk);
        int type = 0;
        if (!bk.isEmpty()) {
            type = 2;
            String[] splitA = bk.split(",");
            for (Map.Entry<String, String> entry : Prgvfmnp.entrySet()) {
//                String key = entry.getKey();
                String value = entry.getValue();
                for (int i = 0; i < splitA.length; i++) {
                    if (value.contains(splitA[i])) {
                        //黑名单包含的字段只能A面
                        type = 1;
                        break;
                    }
                }
            }
        } else {
            type = 0;
        }
//        LogUtils.log("faww4y", "oFZeIZ: "+type);
        return type;
    }

    //匹配解析的保存的名单数据是否白名单，根据value和key进行判断
    public static boolean FVBQDS(String sevdata) {
        JSONObject jInfo = JZKPbq(sevdata);
        boolean isGreff = false;
        String reffer = jInfo.optString("reffer");
        if (!reffer.isEmpty()) {
            String[] splitA = reffer.split(",");
            for (Map.Entry<String, String> entry : Prgvfmnp.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                for (int i = 0; i < splitA.length; i++) {
                    if (value.contains(splitA[i])) {
                        isGreff = true;
                        break;
                    }
                    if (key.contains(splitA[i])) {
                        isGreff = true;
                        break;
                    }
                }
            }
        }
        return isGreff;
    }

    public static boolean rxxZGE(String adjRef) {
        boolean isAd = false;
        if (!adjRef.isEmpty()) {
            JSONObject obj2 = null;
            try {
                obj2 = new JSONObject(adjRef);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String network = obj2.optString("network");
            String campaign = obj2.optString("campaign");
            if (network.equals("Unattributed")) {
                isAd = true;
            } else if (!campaign.isEmpty()) {
                isAd = true;
            } else {
            }
        }
        return isAd;
    }


    public static void xqnEwo() {
        String adjRef = sp.getString("adAttri", "");
        xqnEwo(kokacoqi, rvox_gaun, adjRef);
    }

    private static void xqnEwo(String sevdata, String installReferrer, String adjRef) {
//        boolean isGreff = FVBQDS(sevdata);
        //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
        int tytp = oFZeIZ(kokacoqi);
        boolean isGreff = false;
        int carse = 0;
        if (tytp == 0) {
            boolean retype = FVBQDS(kokacoqi);
            isGreff = retype;
            if (retype) carse = 1;
        } else if (tytp == 1) {
            isGreff = false;
        } else if (tytp == 2) {
            isGreff = true;
            carse = 2;
        }

        boolean isAd = rxxZGE(adjRef);
//        LogUtils.log("wreawt", "case: "+isAd);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("sendRes", 1);
        editor.commit();
        if (isGreff || isAd) {
            if (isGreff) {
                if (carse == 1) {
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open", "ggWTOpen:");
                } else if (carse == 2) {
                    TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open", "ggBKOpen:");
                }
            } else if (isAd) {
                carse = 3;
                TdwdiVvOyKn.WKeeNM(context,"A_referrer", "open", "gyOpen");
            }
            LogUtils.log("caseawr："+ "case: " + carse);

            editor.putInt("secOpen", carse);
            editor.putInt("referrer", 1);
            editor.putString("refferUrl", installReferrer);
            editor.commit();

            mCallback.onTopGameListener(true);
        } else {
            mCallback.onTopGameListener(false);
        }
    }

    private static String xEwNdP() {
        if (frqmbxmk != null) {
            ReferrerDetails referrerDetails = null;
            try {
                referrerDetails = frqmbxmk.getInstallReferrer();
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
        if (frqmbxmk != null && frqmbxmk.isReady()) {
            frqmbxmk.endConnection();
            frqmbxmk = null;
        }
    }

}
