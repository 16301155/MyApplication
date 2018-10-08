package com.example.myungger.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.myungger.myapplication.R;

public class AllClass extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allclass);
        setToolbar(R.id.toolbar_allclass, true);

        CardView cardView = findViewById(R.id.cardView11);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllClass.this, ZeroBasis.class));
            }
        });
    }
}
