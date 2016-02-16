package com.lighters.cubegriddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.model.CubeGridManager;
import com.lighters.cubegridlibrary.model.CubeGridManagerOption;
import com.lighters.cubegridlibrary.view.CubeGridFrameLayout;

public class MainActivity extends AppCompatActivity {

    private CubeGridFrameLayout mCubeGridImageView;
    private CubeGridManager mCubeGridManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCubeGridImageView = (CubeGridFrameLayout) findViewById(R.id.iv_cube_grid);
        mCubeGridImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridManager = new CubeGridManager();
                mCubeGridManager.setUp(new CubeGridManagerOption.Builder().fillColor(Color
                        .GREEN)
                        .cubeGridAnimCallback(mCubeGridAnimCallback)
                        .cornerSize(40)
                        .loopCount(5)
                        .totalHeight(mCubeGridImageView.getHeight()).totalWidth(mCubeGridImageView.getWidth()).build());
                mCubeGridImageView.start(mCubeGridManager);
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
