package com.example.myungger.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.myungger.myapplication.R;

public class TotalTraining extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.totaltraining);
        setToolbar(R.id.toolbar_totaltraining, true);
    }
}
