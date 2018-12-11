package com.example.myungger.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.util.ToastUtil;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

public class Login extends AppCompatActivity implements QQ.QQLoginListener {
    private QQ qq;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        qq.registerResultListener(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        qq = new QQ("1107959313", this, this);

        Button button1 = (Button)findViewById(R.id.loginbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                Login.this.finish();
            }
        });

        Button button2 = (Button)findViewById(R.id.createbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Create.class);
                startActivity(intent);
            }
        });

        ImageView imageView = (ImageView)findViewById(R.id.imageView11);
        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        qq.launchQQLogin(Login.this);
                    }
                }
        );
    }

    @Override
    public void onQQLoginSuccess(JSONObject jsonObject) {
        ToastUtil.showToast(this, "登陆成功！");
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        Login.this.finish();
    }

    @Override
    public void onQQLoginCancel() {
        ToastUtil.showToast(this, "取消登陆！");
    }

    @Override
    public void onQQLoginError(UiError uiError) {
        ToastUtil.showToast(this, "登陆失败！");
    }
}


