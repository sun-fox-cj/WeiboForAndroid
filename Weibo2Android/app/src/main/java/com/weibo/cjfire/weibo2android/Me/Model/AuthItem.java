package com.weibo.cjfire.weibo2android.Me.Model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by cjfire on 16/6/30.
 */
public class AuthItem {

    public static final String savePath = "DATABASE";

    private String uid;
    private String userName;
    private String accessToken;
    private String refreshToken;

    private String expires;

    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;

    public String getExpires() {
        return expires;
    }

    public String getUid() {
        return uid;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AuthItem(Bundle values, Context context) {

        uid = values.getString("uid");
        userName = values.getString("userName");
        expires = values.getString("expires_in");
        refreshToken = values.getString("refresh_token");
        accessToken = values.getString("access_token");

        mSp = context.getSharedPreferences(AuthItem.savePath, Activity.MODE_PRIVATE);
        mEditor = mSp.edit();
    }

    public AuthItem(Context context) {

        mSp = context.getSharedPreferences(AuthItem.savePath, Activity.MODE_PRIVATE);
        mEditor = mSp.edit();

        uid = mSp.getString("uid", "");
        userName = mSp.getString("userName", "");
        expires = mSp.getString("expires", "");
        refreshToken = mSp.getString("refreshToken", "");
        accessToken = mSp.getString("accessToken", "");
    }

    public void save() {

        mEditor.putString("uid", uid);
        mEditor.putString("userName", userName);
        mEditor.putString("accessToken", accessToken);
        mEditor.putString("refreshToken", refreshToken);
        mEditor.putString("expires", expires);

        mEditor.commit();
    }
}
