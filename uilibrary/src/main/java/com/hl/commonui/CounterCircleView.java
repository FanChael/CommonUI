package com.hl.commonui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hl.commonui.event.EventListenner;
import com.hl.commonui.utils.DensityUtil;

/*
 *@Description: 圆形倒计时控件
 *@Author: hl
 *@Time: 2019/4/4 16:39
 */
public class CounterCircleView extends View {
    private Paint painter;
    private Paint painterTv;
    private Paint painterOuter;

    private int size;
    private int halfSize;
    private int in_radius;
    private int text_size;
    private RectF mCircle;

    private boolean bUserStart = false;
    private CountDownTimer countDownTimer;
    private String percentS = 50 + "%";
    private float swipeAngle = 360;

    /**
     * 用户可配置信息
     */
    private float counter_number = 10;
    private boolean bPercent = false;
    private boolean bShowOuter = true;
    private int out_size = 10;
    private int textColor; //= "#334081";
    private int innerColor; // "#000000";
    private int innerColorAlpha = 10;
    private int outerColor; // "#2773FF";

    private EventListenner.CounterCallBack counterCallBack = null;

    public CounterCircleView(Context context) {
        this(context, null);
    }

    public CounterCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CounterCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CounterCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intStyledAttributes(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ///< 矫正控件的大小
        size = getMeasuredWidth();
        if (bPercent) {
            size = size < 130 ? 130 : size;
        } else {
            size = size < 105 ? 105 : size;
        }
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ///< 绘制一个圆圈吧-> drawCircle(float cx, float cy, float radius, Paint paint)
        canvas.drawCircle(halfSize, halfSize, in_radius, painter);

        ///< 绘制圆圈中心的进度
        Rect txRect = new Rect();
        painterTv.getTextBounds(percentS, 0, percentS.length(), txRect);
        ///< 关于起点，涉及到基线相关的知识(目前可以姑且暂时理解为绘制起始点是左下角)
        canvas.drawText(percentS,
                halfSize - txRect.width() / 2, halfSize + txRect.height() / 2,
                painterTv);

        if (bShowOuter) {
            ///< 绘制外圈进度
            canvas.drawArc(mCircle, 360,
                    swipeAngle,
                    false, painterOuter);
        }
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
        bUserStart = true;
        if (null != countDownTimer) {
            countDownTimer.start();
        }
    }

    /**
     * 取消定时
     */
    public void cancel(){
        bUserStart = false;
        if (null != countDownTimer) {
            countDownTimer.cancel();
        }
    }

    /**
     * 初始化
     */
    private void initView() {
        halfSize = size / 2;
        in_radius = (size - out_size * 2) / 2;
        text_size = 45 * size / DensityUtil.dip2px(getContext(), 100);
        text_size = text_size < 45 ? 45 : text_size;

        ///< 绘制外环
        mCircle = new RectF(); ///< 外切矩形
        mCircle.set(out_size / 2,
                out_size / 2,
                size - out_size / 2,
                size - out_size / 2);

        painter = new Paint();
        painter.setAntiAlias(true);
        painter.setColor(innerColor);
        painter.setAlpha(innerColorAlpha);

        painterTv = new Paint();
        painterTv.setTextSize(text_size);
        painterTv.setColor(textColor);

        painterOuter = new Paint();
        painterOuter.setAntiAlias(true);
        painterOuter.setStrokeWidth(out_size);
        painterOuter.setStyle(Paint.Style.STROKE);
        painterOuter.setColor(outerColor);

        /** 倒计时60秒，一次100毫秒 */
        final float pingLv = 10f;
        final float circlePercent = 360 / (bPercent ? counter_number * pingLv / 10f : counter_number * pingLv);
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
                swipeAngle -= circlePercent;
                if (swipeAngle < 0) {
                    swipeAngle = 0;
                }
                invalidate();
                if (null != counterCallBack) {
                    counterCallBack.onTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                counter_number = 0;
                percentS = bPercent ? counter_number + "%" : (int) counter_number + "s";
                swipeAngle = 0;
                invalidate();
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
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != counterCallBack) {
                    counterCallBack.onClick(v);
                }
            }
        });
        if (bUserStart){
            if (null != countDownTimer){
                countDownTimer.start();
            }
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
        bPercent = ta.getBoolean(R.styleable.counterview_styleable_s_c_b_percent, false);
        bShowOuter = ta.getBoolean(R.styleable.counterview_styleable_s_c_b_showouter, true);
        out_size = ta.getDimensionPixelOffset(R.styleable.counterview_styleable_s_c_out_size, DensityUtil.dip2px(context, 5));
        textColor = ta.getColor(R.styleable.counterview_styleable_s_c_text_color, Color.parseColor("#334081"));
        innerColor = ta.getColor(R.styleable.counterview_styleable_s_c_inner_color, Color.parseColor("#000000"));
        innerColorAlpha = ta.getInteger(R.styleable.counterview_styleable_s_c_inner_color_alpha, 10);
        outerColor = ta.getColor(R.styleable.counterview_styleable_s_c_outer_color, Color.parseColor("#2773FF"));
    }
}
