package com.lighters.cubegridlibrary.callback;

/**
 * Created by david on 16/2/5.
 *
 * Cube Grid 动画执行回调
 */
public interface ICubeGridAnimCallback {

    /**
     * 动画执行开始
     */
    void onAnimStart();

    /**
     * 动画执行过程中的回调, 当前执行的圈数 (以九宫格左下角的方块为准)
     * @param curLoopCount 返回动画执行的圈数
     */
    void onAnimExecute(int curLoopCount);

    /**
     * 动画执行结束
     */
    void onAnimEnd();

}
