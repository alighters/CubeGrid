package com.lighters.cubegridlibrary.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridManagger {

    /**
     * 一个完整动画执行的时长
     */
    public static float ANIM_DURATION = 1.3f;

    public static float ANIM_TOTAl_TIME = 1.3f + 0.4f;

    public static float LOOP_COUNT = 2;

    private float[][] mDelayTime = {{0.2f, 0.3f, 0.4f}, {0.1f, 0.2f, 0.3f}, {0.0f, 0.1f, 0.2f}};

    private int mLoopCount = 1;

    private CubeGridObject[][] mCubeGridObjects;

    private int mRowSize;
    private int mColumnSize;

    public void setUp(CubeGridManagerOption cubeGridManagerOption) {
        if (cubeGridManagerOption != null) {
            int cubeGridWidth = cubeGridManagerOption.getTotalWidth() / cubeGridManagerOption.getRowSize();
            int cubeGridHeight = cubeGridManagerOption.getTotalHeight() / cubeGridManagerOption.getColumnSize();
            mRowSize = cubeGridManagerOption.getRowSize();
            mColumnSize = cubeGridManagerOption.getColumnSize();
            mCubeGridObjects = new CubeGridObject[mRowSize][mColumnSize];
            Paint paint = new Paint(cubeGridManagerOption.getFillColor());
            for (int i = 0; i < mRowSize; i++) {
                for (int j = 0; j < mColumnSize; j++) {
                    mCubeGridObjects[i][j] = new CubeGridObject(j * cubeGridWidth, i * cubeGridHeight, cubeGridWidth,
                            cubeGridHeight, paint);
                }
            }
        }
    }

    public void startLoop(final View view) {

        ValueAnimator animator = ValueAnimator.ofFloat(0f, ANIM_TOTAl_TIME);
        animator.setDuration((int) (ANIM_TOTAl_TIME * 1000));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                setFraction(value);
                view.postInvalidate();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                resetFraction();
                startLoop(view);
            }
        });

        animator.start();
    }

    public void drawCanvas(Canvas canvas) {
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                mCubeGridObjects[i][j].drawCubeGrid(canvas);
            }
        }
    }

    private void setFraction(float curAnimValue) {
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                if (curAnimValue > mDelayTime[i][j] && curAnimValue - mDelayTime[i][j] <= ANIM_DURATION) {
                    float fraction = (curAnimValue - mDelayTime[i][j]) / ANIM_DURATION;
                    mCubeGridObjects[i][j].setFraction(fraction);
                }
            }
        }
    }

    private void resetFraction() {
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                mCubeGridObjects[i][j].setFraction(0f);
            }
        }
    }
}
