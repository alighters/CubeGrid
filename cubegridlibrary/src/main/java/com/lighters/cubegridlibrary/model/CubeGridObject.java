package com.lighters.cubegridlibrary.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.lighters.cubegridlibrary.callback.ICubeGridDraw;

/**
 * Created by david on 16/2/5.
 * <p/>
 * 对应单个显示的小方块
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
     * 圆角大小
     */
    private int cornerSize = 40;

    /**
     * 小方块的绘制画笔
     */
    private Paint paint;

    /**
     * 小方块的显示大小比例
     */
    private float fraction = 1f;

    /**
     * 当前动画执行的圈数
     */
    private int curLoopCount;

    /**
     * 当前方块执行的最大圈数
     */
    private int maxLoopCount = Integer.MAX_VALUE;

    public int getCurLoopCount() {
        return curLoopCount;
    }

    public void setCurLoopCount(int curLoopCount) {
        this.curLoopCount = curLoopCount;
    }

    public int getMaxLoopCount() {
        return maxLoopCount;
    }

    public void setMaxLoopCount(int maxLoopCount) {
        this.maxLoopCount = maxLoopCount;
    }

    /**
     * 小方块的圆角位置
     */
    private CornerLocation mCornerLocation;

    public CubeGridObject(float x, float y, int width, int height, Paint paint) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paint = paint;
        curLoopCount = 0;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public void setCornerLocation(CornerLocation cornerLocation) {
        this.mCornerLocation = cornerLocation;
    }

    public void setCornerSize(int cornerSize) {
        if (cornerSize > 0) {
            this.cornerSize = cornerSize;
        }
    }

    @Override
    public void drawCubeGrid(Canvas canvas) {
        if (curLoopCount > maxLoopCount) {
            fraction = 1;
        }
        float xSpace = (1 - fraction) * width / 2;
        float left = x + xSpace;
        float right = x + width - xSpace;
        float ySpace = (1 - fraction) * height / 2;
        float top = y + ySpace;
        float bottom = y + height - ySpace;
        if (mCornerLocation != null) {
            if (CornerLocation.LEFTBOTTOM.equals(mCornerLocation)) {
                drawLeftBottomCubeGridWithCorner(canvas, left, top, right, bottom, paint);
            } else if (CornerLocation.LEFTTOP.equals(mCornerLocation)) {
                drawLeftTopCubeGridWithCorner(canvas, left, top, right, bottom, paint);
            } else if (CornerLocation.RIGHTBOTTOM.equals(mCornerLocation)) {
                drawRightBottomCubeGridWithCorner(canvas, left, top, right, bottom, paint);
            } else if (CornerLocation.RIGHTTOP.equals(mCornerLocation)) {
                drawRightTopCubeGridWithCorner(canvas, left, top, right, bottom, paint);
            } else {
                canvas.drawRect(left, top, right, bottom, paint);
            }
        } else {
            canvas.drawRect(left, top, right, bottom, paint);
        }
    }

    /**
     * 绘制左上角的圆角矩形
     */
    private void drawLeftTopCubeGridWithCorner(Canvas canvas, float left, float top, float right, float bottom, Paint
        paint) {
        Path path = new Path();
        float corner = cornerSize * fraction;
        if (left + corner > right || top + corner > bottom) {
            corner = 0f;
        }
        path.moveTo(left + corner, top);
        path.lineTo(right, top);
        path.lineTo(right, bottom);
        path.lineTo(left, bottom);
        path.lineTo(left, top + corner);
        path.arcTo(new RectF(left, top, left + corner, top + corner), 180f, 90f);
        path.close();
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制左下角的圆角矩形
     */
    private void drawLeftBottomCubeGridWithCorner(Canvas canvas, float left, float top, float right, float bottom, Paint
        paint) {
        Path path = new Path();
        float corner = cornerSize * fraction;
        if (left + corner > right || top + corner > bottom) {
            corner = 0f;
        }
        path.moveTo(left, top);
        path.lineTo(right, top);
        path.lineTo(right, bottom);
        path.lineTo(left + corner, bottom);
        path.arcTo(new RectF(left, bottom - corner, left + corner, bottom), 90f, 90f);
        path.lineTo(left, top);
        path.close();
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制右上角的圆角矩形
     */
    private void drawRightTopCubeGridWithCorner(Canvas canvas, float left, float top, float right, float bottom, Paint
        paint) {
        Path path = new Path();
        float corner = cornerSize * fraction;
        if (left + corner > right || top + corner > bottom) {
            corner = 0f;
        }
        path.moveTo(left, top);
        path.lineTo(right - corner, top);
        path.arcTo(new RectF(right - corner, top, right, top + corner), 270f, 90f);
        path.lineTo(right, bottom);
        path.lineTo(left, bottom);
        path.lineTo(left, top);
        path.close();
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制右下角的圆角矩形
     */
    private void drawRightBottomCubeGridWithCorner(Canvas canvas, float left, float top, float right, float bottom,
        Paint paint) {
        Path path = new Path();
        float corner = cornerSize * fraction;
        if (left + corner > right || top + corner > bottom) {
            corner = 0f;
        }
        path.moveTo(left, top);
        path.lineTo(right, top);
        path.lineTo(right, bottom - corner);
        path.arcTo(new RectF(right - corner, bottom - corner, right, bottom), 0f, 90f);
        path.lineTo(left, bottom);
        path.lineTo(left, top);
        path.close();
        canvas.drawPath(path, paint);
    }
}
