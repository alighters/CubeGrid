package com.lighters.cubegridlibrary.model;

import com.lighters.cubegridlibrary.callback.ICubeGridAnimCallback;

/**
 * Created by david on 16/2/5.
 * <p/>
 * 整个方块的应用配置
 */
public class CubeGridManagerOption {

    /**
     * 划分为小方块的列数
     */
    private int mColumnSize = 3;
    /**
     * 划分为小方块的横数
     */
    private int mRowSize = 3;

    /**
     * 整个方块的宽度
     */
    private int mTotalWidth;

    /**
     * 整个方块的高度
     */
    private int mTotalHeight;

    /**
     * 对应每个小方块的填充色
     */
    private int mFillColor;

    /**
     * 动画执行的回调
     */
    private ICubeGridAnimCallback mCubeGridAnimCallback;

    /**
     * 动画执行圈数
     */
    private int mLoopCount;

    /**
     * 圆角大小
     */
    private int mCornerSize;

    private CubeGridManagerOption(Builder builder) {
        if (builder.mColumnSize > 0)
            setColumnSize(builder.mColumnSize);
        if (builder.mRowSize > 0)
            setRowSize(builder.mRowSize);
        setTotalWidth(builder.mTotalWidth);
        setTotalHeight(builder.mTotalHeight);
        setFillColor(builder.mFillColor);
        setLoopCount(builder.mLoopCount);
        setCornerSize(builder.mCornerSize);
        setCubeGridAnimCallback(builder.mCubeGridAnimCallback);
    }

    public int getColumnSize() {
        return mColumnSize;
    }

    public void setColumnSize(int columnSize) {
        mColumnSize = columnSize;
    }

    public int getRowSize() {
        return mRowSize;
    }

    public void setRowSize(int rowSize) {
        mRowSize = rowSize;
    }

    public int getTotalWidth() {
        return mTotalWidth;
    }

    public void setTotalWidth(int totalWidth) {
        mTotalWidth = totalWidth;
    }

    public int getTotalHeight() {
        return mTotalHeight;
    }

    public void setTotalHeight(int totalHeight) {
        mTotalHeight = totalHeight;
    }

    public int getLoopCount() {
        return mLoopCount;
    }

    public void setLoopCount(int loopCount) {
        mLoopCount = loopCount;
    }

    public int getCornerSize() {
        return mCornerSize;
    }

    public void setCornerSize(int cornerSize) {
        mCornerSize = cornerSize;
    }

    public int getFillColor() {
        return mFillColor;
    }

    public void setFillColor(int fillColor) {
        mFillColor = fillColor;
    }

    public ICubeGridAnimCallback getCubeGridAnimCallback() {
        return mCubeGridAnimCallback;
    }

    public void setCubeGridAnimCallback(ICubeGridAnimCallback cubeGridAnimCallback) {
        mCubeGridAnimCallback = cubeGridAnimCallback;
    }

    public static final class Builder {
        private int mColumnSize;
        private int mRowSize;
        private int mTotalWidth;
        private int mTotalHeight;
        private int mFillColor;
        private int mCornerSize;
        private int mLoopCount;
        private ICubeGridAnimCallback mCubeGridAnimCallback;

        public Builder() {
        }

        public Builder columnSize(int val) {
            mColumnSize = val;
            return this;
        }

        public Builder rowSize(int val) {
            mRowSize = val;
            return this;
        }

        public Builder totalWidth(int val) {
            mTotalWidth = val;
            return this;
        }

        public Builder totalHeight(int val) {
            mTotalHeight = val;
            return this;
        }

        public Builder fillColor(int val) {
            mFillColor = val;
            return this;
        }

        public Builder cubeGridAnimCallback(ICubeGridAnimCallback val) {
            mCubeGridAnimCallback = val;
            return this;
        }

        public Builder cornerSize(int val) {
            mCornerSize = val;
            return this;
        }

        public Builder loopCount(int val) {
            mLoopCount = val;
            return this;
        }

        public CubeGridManagerOption build() {
            return new CubeGridManagerOption(this);
        }
    }
}
