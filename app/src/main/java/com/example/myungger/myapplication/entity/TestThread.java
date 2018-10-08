package com.example.myungger.myapplication.entity;

import android.app.Activity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestThread extends Thread {

    private ProgressBar progressBar;
    private TextView level;
    private Activity activity;
    private int progressVal;
    int time = 50;

    public TestThread(Activity activity, ProgressBar progressBar, TextView level, int progressVal) {
        this.activity = activity;
        this.progressBar = progressBar;
        this.level = level;
        this.progressVal = progressVal;
    }

    @Override
    public void run() {
        try {
            while (true) {
                activity.runOnUiThread(runnable);
                progressVal++;
                sleep(time);
            }
        } catch (Exception e) {
            Log.d("TestThread错误", "run: " + e.toString());
        }
        activity.runOnUiThread(runnable);
    }

    public int getProgressVal() {
        return progressVal;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (progressVal <= 100) {
                progressBar.setProgress(progressVal);
            } else {
                progressVal = 0;
                progressBar.setProgress(0);
                int levelNum = Integer.valueOf(level.getText().toString());
                Log.d("等级", "run: " + levelNum);
                levelNum++;
                level.setText(Integer.toString(levelNum));
            }
        }
    };
}
