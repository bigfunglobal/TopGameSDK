package com.topgame.sdk;

import android.content.Context;

import com.tendcloud.tenddata.TDGAProfile;
import com.tendcloud.tenddata.TalkingDataGA;

public class TDUtils {

    public static void TDinit(Context context,String talkingDataId,String TGChannelCode){
        TalkingDataGA.init(context,talkingDataId, TGChannelCode);
        TDGAProfile.setProfile(TalkingDataGA.getDeviceId(context));
    }
}
