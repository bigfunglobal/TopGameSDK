package com.talking.adjustsdk;


import android.content.Context;

import com.talking.bigfunglobal.GlobalApplication;

public class XAPP extends GlobalApplication {
    private static String appToken="749xmt9mstmo";
    private static String TalkingDatId="FF7A555944EA448FB8468703E0726D1F";
    private static String SPName=MainActivity.SPName();
    private static int SPModel=MainActivity.SPModel();
    private static String TalkingDatName=MainActivity.uqVyqg();

    public XAPP() {
        super(appToken,TalkingDatId,TalkingDatName,SPName, SPModel);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
