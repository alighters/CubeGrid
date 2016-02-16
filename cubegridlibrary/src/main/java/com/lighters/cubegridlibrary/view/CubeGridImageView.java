package com.lighters.cubegridlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lighters.cubegridlibrary.model.CubeGridManagerOption;
import com.lighters.cubegridlibrary.model.CubeGridManager;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridImageView extends ImageView {

    /**
     * 是否开启动画的执行
     */
    private boolean mAnimEnabled = false;

    private Paint mPaint = new Paint();

    private CubeGridManager mCubeGridManager;

    public CubeGridImageView(Context context) {
        this(context, null);
    }

    public CubeGridImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAnimEnabled || mCubeGridManager != null) {
            canvas.save();
            mCubeGridManager.drawCanvas(canvas);
            canvas.restore();
        }
    }

    public void start() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mAnimEnabled = true;
                mCubeGridManager = new CubeGridManager();
                mCubeGridManager.setUp(new CubeGridManagerOption.Builder().columnSize(3).rowSize(3).fillColor(Color
                        .BLUE)
                        .totalHeight(getHeight()).totalWidth(getWidth()).build());
                mCubeGridManager.startLoop(CubeGridImageView.this);
            }
        },1000);

    }
}
