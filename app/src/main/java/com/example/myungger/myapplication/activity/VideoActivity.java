package com.example.myungger.myapplication.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.config.ServerConfig;
import com.example.myungger.myapplication.util.ToastUtil;

public class VideoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zerobasis);
        setToolbar(R.id.toolbar_zerobasis, true);

        VideoView videoView = findViewById(R.id.videoView2);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse("http://vgfame.top:8000/stream_video"));
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ToastUtil.showToast(VideoActivity.this, "Thank you！");
            }
        });
        videoView.start();
    }
}

