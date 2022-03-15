package com.topgame.sdk.Listener;

import androidx.annotation.Keep;

import com.topgame.sdk.Model.TGLoginModel;

@Keep
public interface TGLoginListener {
    /**
     * 取消
     */
    @Keep
    void onCancel();

    /**
     * 错误
     */
    @Keep
    void onError(String error);

    /**
     * 完成
     *
     * @param loginResult
     */
    @Keep
    void onComplete(TGLoginModel loginResult);
}
