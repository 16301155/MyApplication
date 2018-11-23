package com.example.myungger.myapplication.activity;

import android.os.AsyncTask;
import android.util.Log;

import com.example.myungger.myapplication.entity.User;

import java.io.IOException;

import okhttp3.Response;

public class RequestTask extends AsyncTask<User, String, Integer> {

    private MyRequestListener listener;
    private String address;
    private String msg;

    public RequestTask(String address, MyRequestListener listener) {
        this.address = address;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer s) {
        if (s >= 0) {
            listener.onSuccess(msg);
        } else {
            listener.onFailure(msg);
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {

    }

    @Override
    protected Integer doInBackground(User... users) {
        try {
            Log.d("套猴", "doInBackground: " );
            Response response = HttpUtil.sendOkHttpRequestByPOST(users[0], address);
            String jasonData = response.body().string();
            if (jasonData.isEmpty()) {
                msg = "空数据";
                return 1;
            } else {
                msg = jasonData;
                return 0;
            }
        } catch (IOException e) {
            Log.d("套猴", "doInBackground: nonononono" );
            msg = "无法连接服务器!";
            return -1;
        }
    }
}
