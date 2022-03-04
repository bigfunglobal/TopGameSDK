package com.topgame.sdk.Utils;

import com.bigfun.sdk.type.AdBFSize;
import com.topgame.sdk.type.AdTGSize;

public class SizeUtils {
    public static AdBFSize TGSize(AdTGSize size) {
        if (size.equals(AdBFSize.BANNER_HEIGHT_50))
            return AdBFSize.BANNER_HEIGHT_50;
        if (size.equals(AdBFSize.BANNER_HEIGHT_90))
            return AdBFSize.BANNER_HEIGHT_90;
        if (size.equals(AdBFSize.RECTANGLE_HEIGHT_250))
            return AdBFSize.RECTANGLE_HEIGHT_250;
        return AdBFSize.BANNER_HEIGHT_50;
    }
}
