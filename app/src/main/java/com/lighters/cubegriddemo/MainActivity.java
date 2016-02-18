package com.lighters.cubegriddemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.view.CubeGridFrameLayout;
import com.lighters.cubegridlibrary.view.CubeGridImageView;

public class MainActivity extends AppCompatActivity {

    private CubeGridImageView mCubeGridImageView;
    private CubeGridFrameLayout mCubeGridFrameLayout;
    private Button mChangeSizeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCubeGridImageView = (CubeGridImageView) findViewById(R.id.iv_cube_grid);
        mCubeGridFrameLayout = (CubeGridFrameLayout) findViewById(R.id.fl_cube_grid);
        mChangeSizeBtn = (Button) findViewById(R.id.btn_change_size);
        mCubeGridImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridImageView.start(mCubeGridAnimCallback);
                mCubeGridFrameLayout.start(mCubeGridAnimCallback);
            }
        }, 1000);

        mChangeSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImageSize();
            }
        });

    }

    private void changeImageSize() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mCubeGridImageView.getLayoutParams();
        final int width = layoutParams.width;
        final int height = layoutParams.height;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mCubeGridImageView
                        .getLayoutParams();
                layoutParams.width = width + (int) animation.getAnimatedValue();
                layoutParams.height = height + (int) animation.getAnimatedValue();
                mCubeGridImageView.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.setDuration(5000);
        valueAnimator.start();
    }

    private ICubeGridAnimCallback mCubeGridAnimCallback = new ICubeGridAnimCallback() {
        @Override
        public void onAnimStart() {

        }

        @Override
        public void onAnimEnd() {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCubeGridImageView.stop();
        mCubeGridFrameLayout.stop();
    }
}
