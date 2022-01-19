package com.talking.bigfunglobal.model;


import com.tendcloud.tenddata.TalkingDataGA;

import java.util.HashMap;
import java.util.Map;

public class TdwdiVvOyKn {
    public static void WKeeNM(String eventName, String valueName, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(valueName, value);     //级别区间，注意是字符串哟！
        TalkingDataGA.onEvent(eventName, map);
    }
}
