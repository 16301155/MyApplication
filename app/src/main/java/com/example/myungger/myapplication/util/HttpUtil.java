package com.example.myungger.myapplication.util;

import android.util.Log;

import com.example.myungger.myapplication.entity.User;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static Response sendOkHttpRequest(String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        return client.newCall(request).execute();
    }


    public static Response sendOkHttpRequestByPOST(User user, String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("username", user.getUserName())
                .add("password", user.getPassword())
                .build();
        Log.d("套猴", "doInBackground: aaaa");
        Request request = new Request.Builder()
                .url(address)
                .post(requestBody)
                .build();

        Log.d("套猴", "doInBackground: bbbb");
        return client.newCall(request).execute();
    }
}
