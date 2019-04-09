package com.hl.commonui.event;

import android.view.View;

/*
*@Description: 事件监听
*@Author: hl
*@Time: 2019/4/9 18:10
*/
public class EventListenner {
    /**
     * 倒计时相关回调
     */
    public interface CounterCallBack {
        void onTick(long millisUntilFinished);
        void onFinish();
        void onClick(View view);
    }
}
