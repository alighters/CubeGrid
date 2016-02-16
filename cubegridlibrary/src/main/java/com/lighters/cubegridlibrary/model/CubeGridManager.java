package com.lighters.cubegridlibrary.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridManager {

    /**
     * 一个完整动画执行的大小值
     */
    public static int ANIM_CYCLE_VALUE = 1300;

    /**
     * 执行动画的单个延时
     */
    public static int ANIM_DELAY = 100;

    /**
     * 动画循环的周期次数, 默认值为2圈
     */
    public static int LOOP_COUNT = 5;

    /**
     * 整个动画执行的大小值
     */
    public static int ANIM_TOTAl_VALUE = ANIM_CYCLE_VALUE * LOOP_COUNT + ANIM_DELAY * 4;

    /**
     * 完整动画执行的时间长短
     */
    public static long ANIM_CYCLE_DURATION = 1500;

    /**
     * 对应每个小方块延时的时长
     */
    private int[][] mDelayTime = {
            {ANIM_DELAY * 2, ANIM_DELAY * 3, ANIM_DELAY * 4},
            {ANIM_DELAY, ANIM_DELAY * 2, ANIM_DELAY * 3},
            {0, ANIM_DELAY, ANIM_DELAY * 2}};

    private CubeGridObject[][] mCubeGridObjects;

    private int mRowSize;
    private int mColumnSize;

    /**
     * 设置方块的参数
     * @param cubeGridManagerOption
     */
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

    /**
     * 在指定的View上, 做Canvas动画
     * @param view
     */
    public void startLoop(final View view) {

        ValueAnimator animator = ValueAnimator.ofInt(0, ANIM_TOTAl_VALUE);
        animator.setDuration(ANIM_CYCLE_DURATION * LOOP_COUNT);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                setFraction(value);
                view.invalidate();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                resetFraction();
//                startLoop(view);
            }
        });

        animator.start();
    }

    /**
     * 在Canvas画出对应的显示CubeGridObject数组
     * @param canvas
     */
    public void drawCanvas(Canvas canvas) {
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                mCubeGridObjects[i][j].drawCubeGrid(canvas);
            }
        }
    }

    /**
     * 设置对应每个CubeGridObject显示的比例
     * @param curAnimValue 指定动画的大小值
     */
    private void setFraction(int curAnimValue) {
        int curCubeObjectAnimValue = 0;
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                curCubeObjectAnimValue = curAnimValue - mDelayTime[i][j];
                if (curCubeObjectAnimValue > 0 && curCubeObjectAnimValue / ANIM_CYCLE_VALUE < LOOP_COUNT) {
                    float animRate = (curCubeObjectAnimValue % ANIM_CYCLE_VALUE) * 1.0f / ANIM_CYCLE_VALUE;
                    Log.d("animRate", "i=" + i + ",j=" + j + ", animRate=" + animRate);
                    mCubeGridObjects[i][j].setFraction(getAnimFraction(animRate));
                }else{
                    Log.d("animRate", "i=" + i + ",j=" + j + ", animRate= 0");
                }
            }
        }
    }

    /**
     * 根据动画执行的时间比率, 获取对应小方块大小比例
     * 0-0.35% 执行 1 -> 0 的缩小动画
     * 0.35%-0.7% 执行 0-> 1 的动画
     * 0.7% 维持1不变
     *
     * @param animRate
     * @return
     */
    private float getAnimFraction(float animRate) {
        if (animRate <= 0.35f) {
            return 1 - animRate / 0.35f;
        } else if (animRate <= 0.7f) {
            return (animRate - 0.35f) / 0.35f;
        }
        return 1f;
    }

    private void resetFraction() {
        for (int i = 0; i < mRowSize; i++) {
            for (int j = 0; j < mColumnSize; j++) {
                mCubeGridObjects[i][j].setFraction(1f);
            }
        }
    }
}
