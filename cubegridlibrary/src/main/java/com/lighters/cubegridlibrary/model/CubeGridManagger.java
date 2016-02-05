package com.lighters.cubegridlibrary.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;

/**
 * Created by david on 16/2/5.
 *
 *
 */
public class CubeGridManagger {

    /**
     * 一个完整动画执行的时长
     */
    public static float ANIM_DURATION = 1.3f;


    public static float ANIM_TOTAl_TIME = 1.3f + 0.4f;

    public static float LOOP_COUNT  = 2;

    private float[][] mDelayTime = { {0.2f, 0.3f, 0.4f}, {0.1f, 0.2f, 0.3f}, {0.0f,0.1f, 0.2f}};


    private int mLoopCount  = 1;

    public void startLoop(){

        ValueAnimator animator = ValueAnimator.ofFloat(0f, ANIM_TOTAl_TIME);
        animator.setDuration((int)(ANIM_TOTAl_TIME * 1000));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startLoop();
            }
        });

        startLoop();
    }

    public void drawCanvas(Canvas canvas){

    }

}
