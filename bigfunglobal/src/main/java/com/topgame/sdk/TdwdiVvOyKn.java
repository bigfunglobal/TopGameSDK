package com.topgame.sdk;


import android.content.Context;

import com.bigfun.sdk.BigFunSDK;

import java.util.HashMap;
import java.util.Map;

public class TdwdiVvOyKn {
    public static void WKeeNM(Context context, String eventName, String valueName, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(valueName, value);     //级别区间，注意是字符串哟！
        BigFunSDK.onEvent(context,eventName,map);
    }
}
