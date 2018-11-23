package com.example.myungger.myapplication.activity;

public interface MyRequestListener {
    void onSuccess(String jsonData);
    void onFailure(String jsonData);
}
