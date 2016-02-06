package com.lighters.cubegridlibrary.model;

/**
 * Created by david on 16/2/5.
 *
 * 整个方块的应用配置
 *
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

    private CubeGridManagerOption(Builder builder) {
        setColumnSize(builder.mColumnSize);
        setRowSize(builder.mRowSize);
        setTotalWidth(builder.mTotalWidth);
        setTotalHeight(builder.mTotalHeight);
        setFillColor(builder.mFillColor);
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

    public int getFillColor() {
        return mFillColor;
    }

    public void setFillColor(int fillColor) {
        mFillColor = fillColor;
    }

    public static final class Builder {
        private int mColumnSize;
        private int mRowSize;
        private int mTotalWidth;
        private int mTotalHeight;
        private int mFillColor;

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

        public CubeGridManagerOption build() {
            return new CubeGridManagerOption(this);
        }
    }
}
