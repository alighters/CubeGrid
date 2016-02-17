package com.lighters.cubegriddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.view.CubeGridFrameLayout;
import com.lighters.cubegridlibrary.view.CubeGridImageView;

public class MainActivity extends AppCompatActivity {

    private CubeGridImageView mCubeGridImageView;
    private CubeGridFrameLayout mCubeGridFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCubeGridImageView = (CubeGridImageView) findViewById(R.id.iv_cube_grid);
        mCubeGridFrameLayout = (CubeGridFrameLayout) findViewById(R.id.fl_cube_grid);
        mCubeGridImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridImageView.start(mCubeGridAnimCallback);
                mCubeGridFrameLayout.start(mCubeGridAnimCallback);
            }
        }, 1000);

    }

    private ICubeGridAnimCallback mCubeGridAnimCallback = new ICubeGridAnimCallback() {
        @Override
        public void onAnimStart() {

        }

        @Override
        public void onAnimEnd() {

        }
    };
}
