package com.talking.bigfunglobal.utils;

import static com.talking.bigfunglobal.utils.AdjustUtils.getKokacoqi;
import static com.talking.bigfunglobal.utils.AdjustUtils.rxxZGE;
import static com.talking.bigfunglobal.utils.InstallReferrer.FVBQDS;
import static com.talking.bigfunglobal.utils.InstallReferrer.oFZeIZ;

import android.content.SharedPreferences;
import android.util.Log;

import com.talking.bigfunglobal.interfa.GetIntoNoodlesA;
import com.talking.bigfunglobal.interfa.GetIntoNoodlesB;
import com.talking.bigfunglobal.model.TdwdiVvOyKn;

public class JudgeSpAB {

    private static SharedPreferences sp = null;
    private static boolean aBoolean=false;
    private static GetIntoNoodlesA mCallbackA;
    private static GetIntoNoodlesB mCallbackB;
    private static JudgeSpAB mJudgeSpAB=null;

    public static synchronized JudgeSpAB getInstance() {
        if (mJudgeSpAB == null) {
            synchronized (JudgeSpAB.class) {
                if (mJudgeSpAB == null) {
                    mJudgeSpAB = new JudgeSpAB();
                }
            }
        }
        return mJudgeSpAB;
    }

    public void setCallBack(GetIntoNoodlesA callBackA, GetIntoNoodlesB callBackB){
        mCallbackA=callBackA;
        mCallbackB=callBackB;
    }
    public boolean init(SharedPreferences sharedPreferences){
        sp = sharedPreferences;
        return naciulmlkn();
    }

    private static boolean naciulmlkn(){
        aBoolean=false;
        if (1 == sp.getInt("sendRes", 0)) {
            String url = sp.getString("refferUrl", "");
            if (1 == sp.getInt("referrer", 0)) {
                int secTyoe = sp.getInt("secOpen", 0);
                switch (secTyoe) {
                    case 1:
                        TdwdiVvOyKn.WKeeNM("A_referrer", "open2", "ggWTOpen:");
                        break;
                    case 2:
                        TdwdiVvOyKn.WKeeNM("A_referrer", "open2", "ggBKOpen:");
                        break;
                    case 3:
                        TdwdiVvOyKn.WKeeNM("A_referrer", "open2", "gyOpen:");
                        break;
                }
                Log.d("caseawr", "case2: " + secTyoe);
                mCallbackB.gtoB();
                aBoolean=true;
            } else {
                mCallbackA.gtoA();
                aBoolean=true;
            }
        }
        return aBoolean;
    }
    public static void xqnEwo(String rvox_gaun) {
        String adjRef = sp.getString("adAttri", "");
        xqnEwo(getKokacoqi(), rvox_gaun, adjRef);
    }


    private static void xqnEwo(String sevdata, String installReferrer, String adjRef) {
//        boolean isGreff = FVBQDS(sevdata);
        //0跳过 1是黑名单enablefalse 2非黑名单 enabletrue
        int tytp = oFZeIZ(sevdata);
        boolean isGreff = false;
        int carse = 0;
        if (tytp == 0) {
            boolean retype = FVBQDS(sevdata);
            isGreff = retype;
            if (retype) carse = 1;
        } else if (tytp == 1) {
            isGreff = false;
        } else if (tytp == 2) {
            isGreff = true;
            carse = 2;
        }

        boolean isAd = rxxZGE(adjRef);
//        Log.d("wreawt", "case: "+isAd);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("sendRes", 1);
        editor.commit();
        if (isGreff || isAd) {
            if (isGreff) {
                if (carse == 1) {
                    TdwdiVvOyKn.WKeeNM("A_referrer", "open", "ggWTOpen:");
                } else if (carse == 2) {
                    TdwdiVvOyKn.WKeeNM("A_referrer", "open", "ggBKOpen:");
                }
            } else if (isAd) {
                carse = 3;
                TdwdiVvOyKn.WKeeNM("A_referrer", "open", "gyOpen");
            }
            Log.d("caseawr", "case: " + carse);

            editor.putInt("secOpen", carse);
            editor.putInt("referrer", 1);
            editor.putString("refferUrl", installReferrer);
            editor.commit();
            mCallbackB.gtoB();
            return;
        } else {
            mCallbackA.gtoA();
        }
    }
}
