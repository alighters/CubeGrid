package com.lighters.cubegridlibrary.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

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
        canvas.drawColor(Color.BLUE);
        if (mAnimEnabled) {
            canvas.save();
            int space = getWidth() / 3;
            canvas.drawRect(space * mCutStep, 0, space * (mCutStep + 1), getHeight(), mPaint);
            canvas.restore();
        }
    }

    public void start() {
        Animator animator = ValueAnimator.ofFloat(0f , 1.3f);
    }
}
