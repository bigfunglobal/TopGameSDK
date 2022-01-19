package com.talking.bigfunglobal.utils;

import static com.talking.bigfunglobal.utils.AdjustUtils.JZKPbq;
import static com.talking.bigfunglobal.utils.AdjustUtils.getKokacoqi;
import static com.talking.bigfunglobal.utils.JudgeSpAB.xqnEwo;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.talking.bigfunglobal.model.TdwdiVvOyKn;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class InstallReferrer {

    private static SharedPreferences sp = null;
    private static InstallReferrer mInstallReferrer;
    private static InstallReferrerClient frqmbxmk;
    private static long _ecklthmx;
    private static String rvox_gaun = "";
    private static String reffer = "";
    private static Context mContext;
    public static Map<String, String> Prgvfmnp = new HashMap<String, String>();

    public static synchronized InstallReferrer getInstance() {
        if (mInstallReferrer == null) {
            synchronized (InstallReferrer.class) {
                if (mInstallReferrer == null) {
                    mInstallReferrer = new InstallReferrer();
                }
            }
        }
        return mInstallReferrer;
    }

    public void init(SharedPreferences sharedPreferences,long _ecklthmx,Context context, String reffer){
        sp = sharedPreferences;
        mContext=context;
        this.reffer=reffer;
        this._ecklthmx=_ecklthmx;
        stareZAzvur();
    }

    //第一次进入获取installReferrer数据进行判断
    public static void stareZAzvur() {
        frqmbxmk = InstallReferrerClient.newBuilder(mContext).build();
        frqmbxmk.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode == InstallReferrerClient.InstallReferrerResponse.OK) {
                    String installReferrer="";
                    if(reffer.isEmpty()) {
                        installReferrer = xEwNdP();
                    }else {
                        installReferrer=reffer;
                    }
                    try {
                        installReferrer = URLDecoder.decode(installReferrer, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    rvox_gaun = installReferrer;
                    TdwdiVvOyKn.WKeeNM("A_referrer", "url", installReferrer);
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
                    JSONObject oInfo = JZKPbq(getKokacoqi());
                    Log.d("fwet", oInfo.toString());
                    String code = oInfo.optString("code");
                    _ecklthmx = oInfo.optLong("timeout", 15000);//default 15s
                    String wbu = oInfo.optString("wbAdr");

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("wbAdr", wbu);
                    editor.commit();

                    //解析保存的的白名单
                    //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
                    int tytp = oFZeIZ(getKokacoqi());
                    boolean isGreff = false;
                    if (tytp == 0) {
                        boolean retype = FVBQDS(getKokacoqi());
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
                        xqnEwo(rvox_gaun);
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
                                    xqnEwo(rvox_gaun);
                                }
                            }
                        }, _ecklthmx);

                        if (!sp.getString("adAttri", "").isEmpty()) {
//                            Log.e("TAGerf", "mkit4: ");
                            xqnEwo(rvox_gaun);
                        } else {
                            if (Prgvfmnp.get("utm_source") != null && Prgvfmnp.get("utm_source").equals("google-play")) {
//                                Log.e("TAGerf", "mkit5: ");
                                xqnEwo(rvox_gaun);
                            }
                        }
                    }
                    return;
                }

            }

            @Override
            public void onInstallReferrerServiceDisconnected() {

            }
        });
    }

    //解析保存的名单
    //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
    public static int oFZeIZ(String wej) {
//        Log.d("faww4y", "oFZeIZ0: "+wej);
        JSONObject jInfo = JZKPbq(wej);
        String bk = jInfo.optString("reffer_bk");
//        Log.d("faww4y", "oFZeIZ1: "+bk);
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
//        Log.d("faww4y", "oFZeIZ: "+type);
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
