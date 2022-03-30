package com.topgame.sdk.Utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.bigfun.sdk.BigFunSDK;
import com.topgame.sdk.TDUtils;
import com.topgame.sdk.TdwdiVvOyKn;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class KadfauJalsd {
    static SharedPreferences sp;
    public static JSONObject SJGfoakds(String result) {
        JSONObject oInfo = new JSONObject();
        JSONObject ajsdata = null;
        try {
            ajsdata = new JSONObject(result);
            oInfo.put("code", ajsdata.optString("code"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String data = ajsdata.optString("data");
        JSONObject objcwasd = null;
        try {
            objcwasd = new JSONObject(data);
            oInfo.put("wbAdr", objcwasd.optString("wbAdr"));
            oInfo.put("ver", objcwasd.optString("ver"));
            oInfo.put("referrerwt", objcwasd.optString("referrerwt"));
            String time = objcwasd.optString("timeout");
            long timelong = Long.parseLong(time);
            oInfo.put("timeout", timelong);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return oInfo;
    }

    public static boolean SJgasda(String sevdata,Map<String, String> gasda) {
        JSONObject jInfo = SJGfoakds(sevdata);
        boolean isGreff = false;
        String referwt = jInfo.optString("referrerwt");
        if (!referwt.isEmpty()) {
            String[] splitA = referwt.split(",");
            for (Map.Entry<String, String> entry : gasda.entrySet()) {
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

    public static boolean SJgfoadagf(String adjRef) {
        boolean isAdjsut = false;
        if (!adjRef.isEmpty()) {
            JSONObject obfjawfgs = null;
            try {
                obfjawfgs = new JSONObject(adjRef);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String network = obfjawfgs.optString("network");
            String campaign = obfjawfgs.optString("campaign");
            if (network.equals("Unattributed")) {
                isAdjsut = true;
            } else if (!campaign.isEmpty()) {
                isAdjsut = true;
            } else {
            }
        }
        return isAdjsut;
    }

    public static String ULSnfwasd() {
        JSONObject iswt = new JSONObject();
        JSONObject wtstr = new JSONObject();
        try {
            wtstr.put("referrerwt", "data,gclid,pcampaignid,adjust");
            wtstr.put("timeout", 15000f);
            iswt.put("data", wtstr.toString());
            iswt.put("code", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return iswt.toString();
    }

    public static String SourceUser(Context context){
        if(sp==null)
            sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        String adjRefer = sp.getString("adAttri", "");
        String Adsurl = sp.getString("refferUrl", "");
        boolean isAd = SJgfoadagf(adjRefer);
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

    public static boolean SwitchReferrer(Context context){
        sp = context.getSharedPreferences(context.getPackageName() + "_switchvalue", Context.MODE_PRIVATE);
        if (1 == sp.getInt("referrer", 0)) {
            TDUtils.TDinit(context, BigFunSDK.getTDID(),"TopGameSDK_Unnatural");
            TdwdiVvOyKn.WKeeNM(context,"T_G_Re", "T_A_D", "Open:");
            return true;
        } else {
            return false;
        }
    }
}
