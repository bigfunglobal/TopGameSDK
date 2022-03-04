package com.topgame.sdk.Model;

import com.bigfun.sdk.model.BFShareModel;

public class TGShareModel {

    //--------------get --------------------------------
    public String getPostId() {
        return postId == null ? "" : postId;
    }

    @Override
    public String toString() {
        return "BFShareModel{" +
                "postId='" + postId + '\'' +
                '}';
    }

    private String postId;
    public TGShareModel(BFShareModel result){
        postId= result.getPostId();
    }
}
