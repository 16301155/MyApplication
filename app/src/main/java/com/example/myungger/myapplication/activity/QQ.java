package com.example.myungger.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

public class QQ {
    private String app_id = "";
    private Tencent mTencent;
    private UserInfo mUserInfo;
    private LocalLoginListener localLoginListener;
    private QQLoginListener qqLoginListener;
    private Context mContext;

    public QQ(QQLoginListener qqLoginListener, Context mContext) {
        this.mContext = mContext;
        this.qqLoginListener = qqLoginListener;
        initData();
    }

    public QQ(String app_id, QQLoginListener qqLoginListener, Context mContext) {
        this.app_id = app_id;
        this.qqLoginListener = qqLoginListener;
        this.mContext = mContext;
        initData();
    }

    private void initData() {
        localLoginListener = new LocalLoginListener();
        if (mTencent == null) {
            mTencent = Tencent.createInstance(app_id, mContext);
        }
    }

    public void setAPP_ID(String app_id) {
        this.app_id = app_id;
    }

    public void registerResultListener(int requestCode, int resultCode, @Nullable Intent data) {
        mTencent.onActivityResultData(requestCode, resultCode, data, localLoginListener);
    }

    public void launchQQLogin(Activity activity) {
        if (!mTencent.isSessionValid()) {
            mTencent.login(activity, "all", localLoginListener);
        } else {
            mTencent.logout(mContext);
            launchQQLogin(activity);
        }
    }

    public interface QQLoginListener {
        void onQQLoginSuccess(JSONObject jsonObject);
        void onQQLoginCancel();
        void onQQLoginError(UiError uiError);
    }

    private class LocalLoginListener implements IUiListener {
        @Override
        public void onComplete(Object o) {
            initOpenIdAndToken(o);
            loadUserInfo();
        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }

        private void initOpenIdAndToken(Object object) {
            JSONObject jsonObject = (JSONObject) object;
            try {
                String openID = jsonObject.getString("openid");
                String access_token = jsonObject.getString("access_token");
                String expires = jsonObject.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(access_token, expires);
            } catch (JSONException e) {

            }
        }

        private void loadUserInfo() {
            QQToken qqToken = mTencent.getQQToken();
            mUserInfo = new UserInfo(mContext, qqToken);
            mUserInfo.getUserInfo(new IUiListener() {
                @Override
                public void onComplete(Object o) {
                    qqLoginListener.onQQLoginSuccess((JSONObject) o);
                }

                @Override
                public void onError(UiError uiError) {
                    qqLoginListener.onQQLoginError(uiError);
                }

                @Override
                public void onCancel() {
                    qqLoginListener.onQQLoginCancel();
                }
            });
        }
    }
}
