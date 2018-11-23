package com.example.myungger.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.entity.User;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Create extends BaseActivity implements MyRequestListener{
    private final String ADDRESS = "192.168.2.167:8000/register";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        setToolbar(R.id.toolbar_create, true);

        Button button = (Button)findViewById(R.id.createbutton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestTask requestTask = new RequestTask(ADDRESS, Create.this);
                requestTask.execute(getInfo());
            }
        });
    }

    private User getInfo() {
        String userName = ((EditText) findViewById(R.id.editText)).getText().toString();
        String password = ((EditText) findViewById(R.id.editText4)).getText().toString();
        return new User(userName, password);
    }

    @Override
    public void onSuccess(String jsonData) {
        Toast.makeText(Create.this,jsonData,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String jsonData) {
        Toast.makeText(Create.this, jsonData,Toast.LENGTH_SHORT).show();
    }
}