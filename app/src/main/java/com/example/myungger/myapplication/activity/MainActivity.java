package com.example.myungger.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.entity.FragmentAdapter;
import com.example.myungger.myapplication.entity.TestThread;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private FragmentAdapter fragmentAdapter;
    private ProgressBar progressBar;
    private TextView level;
    private TestThread testThread;
    private int progressVal;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentAdapter.showFragment(0);
                    return true;
                case R.id.navigation_dashboard:
                    fragmentAdapter.showFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    fragmentAdapter.showFragment(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            progressVal = savedInstanceState.getInt("extra_progressBarVal");
            level.setText(savedInstanceState.getString("extra_levelVal"));
        } else {
            progressVal = 0;
        }

        setContentView(R.layout.activity_main);
        initFragment();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button button = findViewById(R.id.button_exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
                MainActivity.this.finish();
            }
        });

        progressBar = findViewById(R.id.progressBar);
        level = findViewById(R.id.textView_level_text);

        testThread = new TestThread(this, progressBar, level, progressVal);
        testThread.start();
    }

    private void initFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_home));
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_find));
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_me));
        fragmentAdapter = new FragmentAdapter(fragmentList, this);
        fragmentAdapter.showFragment(0);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("extra_progressBarVal", testThread.getProgressVal());
        outState.putString("extra_levelVal", level.getText().toString());
    }
}
