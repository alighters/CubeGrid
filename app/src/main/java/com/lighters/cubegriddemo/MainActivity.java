package com.lighters.cubegriddemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.view.CubeGridFrameLayout;
import com.lighters.cubegridlibrary.view.CubeGridImageView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getName();

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
        mCubeGridImageView.start(mImageAnimCallback);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridFrameLayout.start(mFrameLayoutAnimCallback);
            }
        }, 100);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridImageView.stop();
            }
        }, 5000);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCubeGridImageView.destory();
        mCubeGridFrameLayout.destroy();
    }
}
