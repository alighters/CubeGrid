package com.lighters.cubegridlibrary.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.lighters.cubegridlibrary.callback.ICubeGridDraw;

/**
 * Created by david on 16/2/5.
 */
public class CubeGridObject implements ICubeGridDraw {

    /**
     * 小方块的x坐标
     */
    private float x;
    /**
     * 小方块的y坐标
     */
    private float y;

    /**
     * 小方块对应的宽度
     */
    private int width;

    /**
     * 小方块对应的高度
     */
    private int height;

    /**
     * 小方块的绘制画笔
     */
    private Paint paint;

    /**
     * 小方块的显示大小比例
     */
    private float fraction = 1f;

    public CubeGridObject(float x, float y, int width, int height, Paint paint) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paint = paint;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    @Override
    public void drawCubeGrid(Canvas canvas) {
        float xSpace = (1 - fraction) * width;
        float left = x + xSpace;
        float right = x + width - xSpace;
        float ySpace = (1 - fraction) * height;
        float top = y + ySpace;
        float bottom = y + height - ySpace;
        canvas.drawRect(left, top, right, bottom, paint);
    }
}
