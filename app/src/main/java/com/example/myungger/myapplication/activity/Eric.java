package com.example.myungger.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.myungger.myapplication.R;

public class Eric extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eric);
        setToolbar(R.id.toolbar_eric,true);
    }
}
