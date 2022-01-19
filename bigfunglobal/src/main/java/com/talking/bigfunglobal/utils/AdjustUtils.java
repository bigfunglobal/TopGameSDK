package com.talking.bigfunglobal.utils;

import android.content.Context;
import android.content.SharedPreferences;

import android.util.Log;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdjustUtils {
    private static AdjustUtils mAdjustUtils;

    //第一次保存的数据

    //初始化SMSManager
    public static synchronized AdjustUtils getInstance() {
        if (mAdjustUtils == null) {
            synchronized (AdjustUtils.class) {
                if (mAdjustUtils == null) {
                    mAdjustUtils = new AdjustUtils();
                }
            }
        }
        return mAdjustUtils;
    }

    public static SharedPreferences getSharedPreferences(Context context, String name, int mode) {
        return context.getSharedPreferences(name, mode);
    }

    //第一次保存的数据
    public static String getKokacoqi(){
        //第一次进入保存记录
        JSONObject isk = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            //reffer:白名单（,source,not set）,
            data.put("reffer", "data,not set,gclid,pcampaignid,adjust");
            data.put("reffer_bk", "");
            data.put("timeout", 15000f);
            isk.put("data", data.toString());
            isk.put("code", "0");
            Log.d("fweftar", "onCreate: " + isk);
            return isk.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
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


}
