package com.lighters.cubegridlibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.lighters.cubegridlibrary.R;
import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;
import com.lighters.cubegridlibrary.model.CubeGridManager;
import com.lighters.cubegridlibrary.model.CubeGridManagerOption;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridFrameLayout extends FrameLayout {

    private CubeGridManager mCubeGridManager;

    private CubeGridManagerOption.Builder mBuilder;

    public CubeGridFrameLayout(Context context) {
        this(context, null);
    }

    public CubeGridFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CubeGridImageView);
        int loopCount = a.getInt(R.styleable.CubeGridImageView_loopCount, 1);
        mBuilder = new CubeGridManagerOption.Builder();
        mBuilder.loopCount(loopCount);
        int cornerSize = a.getDimensionPixelSize(R.styleable.CubeGridImageView_roundCornerSize, 0);
        mBuilder.cornerSize(cornerSize);
        int color = a.getColor(R.styleable.CubeGridImageView_fillColor, Color.WHITE);
        mBuilder.fillColor(color);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mCubeGridManager == null) {
            mCubeGridManager = new CubeGridManager();
            mBuilder.totalWidth(getWidth());
            mBuilder.totalHeight(getHeight());
            mCubeGridManager.setUp(mBuilder.build());
        }

        if (mCubeGridManager != null) {
            canvas.save();
            mCubeGridManager.drawCanvas(canvas);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    /**
     * 执行开始动画
     */
    public void start() {
        start(null);
    }

    /**
     * 开始执行闪烁的动画
     *
     * @param cubeGridAnimCallback 动画接口回调
     */
    public void start(ICubeGridAnimCallback cubeGridAnimCallback) {
        mCubeGridManager.setCubeGridAnimCallback(cubeGridAnimCallback);
        mCubeGridManager.startLoop(CubeGridFrameLayout.this);
    }

}
