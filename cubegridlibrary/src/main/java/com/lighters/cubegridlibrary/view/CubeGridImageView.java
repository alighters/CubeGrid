package com.lighters.cubegridlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lighters.cubegridlibrary.model.CubeGridManagerOption;
import com.lighters.cubegridlibrary.model.CubeGridManagger;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridImageView extends ImageView {

    /**
     * 动画循环的次数, 默认值为1.
     */
    private int mLoopCount = 1;

    /**
     * 是否开启动画的执行
     */
    private boolean mAnimEnabled = false;

    private int mCutStep = 0;

    private Paint mPaint = new Paint();

    private CubeGridManagger mCubeGridManagger;

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
        if (mAnimEnabled || mCubeGridManagger != null) {
            canvas.save();
            mCubeGridManagger.drawCanvas(canvas);
            canvas.restore();
        }
    }

    public void start() {
        post(new Runnable() {
            @Override
            public void run() {
                mAnimEnabled = true;
                mCubeGridManagger = new CubeGridManagger();
                mCubeGridManagger.setUp(new CubeGridManagerOption.Builder().columnSize(3).rowSize(3).fillColor(Color
                        .BLUE)
                        .totalHeight(getHeight()).totalWidth(getWidth()).build());
                mCubeGridManagger.startLoop(CubeGridImageView.this);
            }
        });

    }
}
