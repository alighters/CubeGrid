package com.lighters.cubegriddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lighters.cubegridlibrary.view.CubeGridImageView;

public class MainActivity extends AppCompatActivity {

    private CubeGridImageView mCubeGridImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCubeGridImageView = (CubeGridImageView) findViewById(R.id.iv_cube_grid);
        mCubeGridImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridImageView.start();
            }
        }, 1000);

    }
}
