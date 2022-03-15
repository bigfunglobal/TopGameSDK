package com.topgame.sdk.Model;

import com.bigfun.sdk.model.BFLoginModel;
import com.facebook.AccessToken;

import java.util.Set;

public class TGLoginModel {
    private AccessToken accessToken;

    //--------------get --------------------------------
    public AccessToken getAccessToken() {
        return accessToken;
    }

    //--------------get --------------------------------
    public Set<String> getRecentlyGrantedPermissions() {
        return recentlyGrantedPermissions;
    }

    //--------------get --------------------------------
    public Set<String> getRecentlyDeniedPermissions() {
        return recentlyDeniedPermissions;
    }

    @Override
    public String toString() {
        return "BFLoginModel{" +
                "accessToken=" + accessToken +
                ", recentlyGrantedPermissions=" + recentlyGrantedPermissions +
                ", recentlyDeniedPermissions=" + recentlyDeniedPermissions +
                '}';
    }
    private Set<String> recentlyGrantedPermissions;
    private Set<String> recentlyDeniedPermissions;

    public TGLoginModel(BFLoginModel loginResult){
        accessToken=loginResult.getAccessToken();
        recentlyGrantedPermissions=loginResult.getRecentlyGrantedPermissions();
        recentlyDeniedPermissions=loginResult.getRecentlyDeniedPermissions();
    }
}
