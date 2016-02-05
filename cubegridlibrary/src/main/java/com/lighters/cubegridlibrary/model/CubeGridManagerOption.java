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


}
