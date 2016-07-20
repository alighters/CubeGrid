package com.lighters.cubegriddemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.view.CubeGridFrameLayout;
import com.lighters.cubegridlibrary.view.CubeGridImageView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getName();

    private CubeGridImageView mCubeGridImageView;
    private Button mBtnStart1;
    private Button mBtnStop1;
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
        mBtnStart1 = (Button) findViewById(R.id.btn_grid_start1);
        mBtnStop1 = (Button) findViewById(R.id.btn_grid_stop1);
        mBtnStart1.setOnClickListener(mOnClickListener);
        mBtnStop1.setOnClickListener(mOnClickListener);
        mCubeGridImageView.start(mImageAnimCallback);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridFrameLayout.start(mFrameLayoutAnimCallback);
            }
        }, 100);
    }

    private ICubeGridAnimCallback mImageAnimCallback = new ICubeGridAnimCallback() {
        @Override
        public void onAnimStart() {

        }

        @Override
        public void onAnimExecute(int curLoopCount) {
            Log.d(TAG, "image loop:" + curLoopCount);
        }

        @Override
        public void onAnimEnd() {
            Toast.makeText(MainActivity.this, "ImageAnimEnd", Toast.LENGTH_SHORT).show();
        }
    };

    private ICubeGridAnimCallback mFrameLayoutAnimCallback = new ICubeGridAnimCallback() {
        @Override
        public void onAnimStart() {

        }

        @Override
        public void onAnimExecute(int curLoopCount) {
            Log.d(TAG, "frame layout loop:" + curLoopCount);
        }

        @Override
        public void onAnimEnd() {
            Toast.makeText(MainActivity.this, "FrameAnimEnd", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_grid_start1:
                    mCubeGridImageView.start(mImageAnimCallback);
                    break;
                case R.id.btn_grid_stop1:
                    mCubeGridImageView.stop();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCubeGridImageView.destory();
        mCubeGridFrameLayout.destroy();
    }
}
