package com.example.com.videoplay;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    VideoView videoView;
    TextView pause;
    TextView play;
    TextView replay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initVideo();
    }

    private void init() {
        videoView = (VideoView) findViewById(R.id.video_view);
        pause = (TextView) findViewById(R.id.pause);
        play = (TextView) findViewById(R.id.paly);
        replay = (TextView) findViewById(R.id.replay);
        pause.setOnClickListener(this);
        play.setOnClickListener(this);
        replay.setOnClickListener(this);
    }

    private void initVideo() {
        File file = new File(Environment.getExternalStorageDirectory(), "Moon.mp4");
        videoView.setVideoPath(file.getAbsolutePath());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paly:
                if (!videoView.isPlaying()) {
                    //开始播放
                    videoView.start();
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
        }

    }
    //在onDestory()方法中调用suspend()方法，将VideoView所占用的资源释放掉

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
