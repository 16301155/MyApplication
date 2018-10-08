package com.example.myungger.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myungger.myapplication.R;

public class Create extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        setToolbar(R.id.toolbar_create, true);

        Button button = (Button)findViewById(R.id.createbutton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Create.this,"注册成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}