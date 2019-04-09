package com.hl.commonui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import com.hl.commonui.event.EventListenner;
import com.hl.commonui.utils.DensityUtil;

/*
 *@Description: 圆角倒计时控件
 *@Author: hl
 *@Time: 2019/4/4 16:39
 */
public class CounterOvalView extends android.support.v7.widget.AppCompatTextView {
    private CountDownTimer countDownTimer;
    private String percentS = 50 + "%";

    /**
     * 用户可配置信息
     */
    private String prefix = "跳过";
    private float counter_number = 10;
    private boolean bPercent = false;
    private int innerColor;
    private int corners = 100;

    private EventListenner.CounterCallBack counterCallBack = null;

    public CounterOvalView(Context context) {
       this(context, null);
    }

    public CounterOvalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CounterOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intStyledAttributes(context, attrs, defStyleAttr);
        setAttributes(context);
        initView(context);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (null != countDownTimer) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    /**
     * 设置倒计时回调
     * @param counterCallBack
     */
    public void setCounterCallBack(EventListenner.CounterCallBack counterCallBack) {
        this.counterCallBack = counterCallBack;
    }

    /**
     * 启动定时
     */
    public void start(){
        if (null != countDownTimer) {
            countDownTimer.start();
        }
    }

    /**
     * 取消定时
     */
    public void cancel(){
        if (null != countDownTimer) {
            countDownTimer.cancel();
        }
    }

    /**
     * 初始化/获取属性
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void intStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.counterview_styleable);
        counter_number = ta.getFloat(R.styleable.counterview_styleable_s_c_counter_number, 10);
        innerColor = ta.getColor(R.styleable.counterview_styleable_s_c_inner_color, Color.parseColor("#60333333"));
        bPercent = ta.getBoolean(R.styleable.counterview_styleable_s_c_b_percent, false);
        corners = ta.getDimensionPixelOffset(R.styleable.counterview_styleable_s_c_corners,DensityUtil.dip2px(context, 80));
        prefix = ta.getString(R.styleable.counterview_styleable_s_c_prefix);
    }

    /**
     * 设置属性
     * @param context
     */
    private void setAttributes(Context context) {
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(innerColor);
        setPadding(DensityUtil.dip2px(context, 20),
                DensityUtil.dip2px(context, 10),
                DensityUtil.dip2px(context, 20),
                DensityUtil.dip2px(context, 10));
        gd.setCornerRadius(corners);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(gd);
        }else{
            setBackgroundDrawable(gd);
        }
    }

    /**
     * 初始化界面
     * @param context
     */
    private void initView(Context context) {
        /** 倒计时60秒，一次100毫秒 */
        final float pingLv = 10f;
        //        final float circlePercent = 360 / (bPercent ? counter_number * pingLv / 10f : counter_number * pingLv);
        countDownTimer = new CountDownTimer((long) (bPercent ? (counter_number + 1) / pingLv * 1000 : (counter_number + 1) * 1000), (long) (1000f / pingLv)) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (counter_number < 0.01f) {
                    counter_number = 0.0f;
                } else {
                    if (bPercent) {
                        counter_number -= 10f / pingLv;
                    } else {
                        counter_number -= 1f / pingLv;
                    }
                }
                if (counter_number < 0.01f) {
                    counter_number = 0.0f;
                }
                String showValue = String.valueOf(counter_number);
                int lastDotPos = showValue.lastIndexOf(".");
                showValue = showValue.substring(0, showValue.length() > lastDotPos ? lastDotPos + 2 : showValue.length());

                if (!bPercent) {
                    showValue = (int) Double.parseDouble(showValue) + "";
                }
                percentS = showValue + (bPercent ? "%" : "s");
                //                swipeAngle -= circlePercent;
                //                if (swipeAngle < 0) {
                //                    swipeAngle = 0;
                //                }
                if (!bPercent && null != prefix && !prefix.equals("")){
                    setText(prefix + "(" + percentS + ")");
                }else{
                    setText(percentS);
                }
                if (null != counterCallBack) {
                    counterCallBack.onTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                counter_number = 0;
                percentS = bPercent ? counter_number + "%" : (int) counter_number + "s";
                //                swipeAngle = 0;
                if (!bPercent && null != prefix && !prefix.equals("")){
                    setText(prefix + "(" + percentS + ")");
                }else{
                    setText(percentS);
                }
                if (null != counterCallBack){
                    counterCallBack.onFinish();
                }
            }
        };//.start();
        if (bPercent) {
            percentS = counter_number + "%";
        } else {
            percentS = (int)counter_number + "s";
        }
        if (!bPercent && null != prefix && !prefix.equals("")){
            setText(prefix + "(" + percentS + ")");
        }else{
            setText(percentS);
        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != counterCallBack) {
                    counterCallBack.onClick(v);
                }
            }
        });
    }
}
