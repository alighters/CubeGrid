package com.lighters.cubegridlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lighters.cubegridlibrary.model.CubeGridManager;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridImageView extends ImageView {

    private CubeGridManager mCubeGridManager;

    public CubeGridImageView(Context context) {
        this(context, null);
    }

    public CubeGridImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCubeGridManager != null) {
            canvas.save();
            mCubeGridManager.drawCanvas(canvas);
            canvas.restore();
        }
    }

    /**
     * 执行开始的动画
     */
    public void start(final CubeGridManager cubeGridManager) {
        post(new Runnable() {
            @Override
            public void run() {
                if (cubeGridManager != null) {
                    mCubeGridManager = cubeGridManager;
                    mCubeGridManager.startLoop(CubeGridImageView.this);
                }
            }
        });
    }

}
