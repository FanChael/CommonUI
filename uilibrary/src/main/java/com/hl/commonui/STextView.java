package com.hl.commonui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;

import com.hl.commonui.utils.DensityUtil;

/*
 *@Description: 扩展TextView
 *@Author: hl
 *@Time: 2019/4/1 11:53
 */
public class STextView extends android.support.v7.widget.AppCompatTextView {
    /**
     * 基础
     */
    private int padding_l = 0;
    private int padding_t = 0;
    private int padding_r = 0;
    private int padding_b = 0;
    private int bg_color;
    private int corner_radius;
    private int stroke_w = -1;
    private int stroke_color;
    private int shape;

    /**
     * 圆环属性 - 利用oval实现
     */
    private int outer_color;
    private int inner_color;
    private int outer_radius;

    /**
     * 渐变
     */
    private GradientDrawable.Orientation gradient_orientation = GradientDrawable.Orientation.LEFT_RIGHT;
    private float gradient_angle = 180f;
    private float gradient_centerX = 0.5f;
    private float gradient_centerY = 0.5f;
    private int gradient_startColor = -1;
    private int gradient_endColor = -1;
    private int gradient_type;

    /**
     * 点击背景颜色
     */
    private int press_stoke_bg_color = -1;
    private int press_bg_color = -1;

    public STextView(Context context) {
        this(context, null);
    }

    public STextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public STextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ///< 允许点击
        this.setClickable(true);
        intStyledAttributes(context, attrs, defStyleAttr);
        setAttributes(context);
    }

    /**
     * 设置基本属性
     */
    private void setAttributes(Context context) {
        GradientDrawable gd;
        if (-1 != gradient_startColor && -1 != gradient_endColor){
            int colors[] = { gradient_startColor , gradient_endColor};
            gd = new GradientDrawable(gradient_orientation, colors);
            gd.setGradientCenter(gradient_centerX, gradient_centerY);
            gd.setGradientRadius(gradient_angle);
            if (-1 == gradient_type){
                gradient_type = GradientDrawable.LINEAR_GRADIENT;
            }
            gd.setGradientType(gradient_type);
        }else{
            gd = new GradientDrawable();
        }
        gd.setShape(shape);
        if (-1 != bg_color){
            gd.setColor(bg_color);
        }
        if (corner_radius > 0) {
            gd.setCornerRadius(corner_radius);
        }
        if (stroke_w > 0) {
            gd.setStroke(stroke_w, stroke_color);
        }

        ///< 圆环按照椭圆方式处理
        if (shape == GradientDrawable.RING){
            gd.setUseLevel(false);
            gd.setShape(GradientDrawable.OVAL);
            gd.setStroke(outer_radius, outer_color);
            gd.setColor(inner_color);
        }

        ///< 按下时的状态
        GradientDrawable gd2 = null;
        if (-1 != press_stoke_bg_color || -1 != press_bg_color){
            if (-1 != gradient_startColor && -1 != gradient_endColor){
                int colors[] = { gradient_startColor , gradient_endColor};
                gd2 = new GradientDrawable(gradient_orientation, colors);
                gd2.setGradientCenter(gradient_centerX, gradient_centerY);
                gd2.setGradientRadius(gradient_angle);
                if (-1 == gradient_type){
                    gradient_type = GradientDrawable.LINEAR_GRADIENT;
                }
                gd2.setGradientType(gradient_type);
            }else{
                gd2 = new GradientDrawable();
            }
            gd2.setShape(shape);
            if (-1 != press_bg_color){
                gd2.setColor(press_bg_color);
            }else{
                if (-1 != bg_color){
                    gd.setColor(bg_color);
                }
            }
            if (corner_radius > 0) {
                gd2.setCornerRadius(corner_radius);
            }
            gd2.setStroke(DensityUtil.dip2px(context, 2), press_stoke_bg_color);

            ///< 圆环按照椭圆方式处理
            if (shape == GradientDrawable.RING){
                gd2.setUseLevel(false);
                gd2.setShape(GradientDrawable.OVAL);
                gd2.setStroke(outer_radius, press_stoke_bg_color);
                if (-1 == press_bg_color){
                    gd2.setColor(inner_color);
                }
            }
        }

        ///< 动态生成Selector - 取负值就表示pressed为false的意思
        int pressed = android.R.attr.state_pressed;
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (null != gd2){
            stateListDrawable.addState(new int[]{ pressed }, gd2);
        }
        stateListDrawable.addState(new int[]{ -pressed }, gd);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(stateListDrawable);
        }else{
            this.setBackgroundDrawable(stateListDrawable);
        }
        this.setPadding(padding_l, padding_t, padding_r, padding_b);
    }

    /**
     * 初始化/获取属性
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void intStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        ///< @a 获取自定义属性值
        //        for (int i = 0; i < attrs.getAttributeCount(); ++i){
        //            if (attrs.getAttributeName(i).equals("paddings")){
        //
        //            }else if (attrs.getAttributeName(i).equals("radius")){
        //
        //            }
        //            Log.e("attrs", "" + i + "-name=" + attrs.getAttributeName(i) + " value=" + attrs.getAttributeValue(i));
        //        }

        ///< @b 获取自定义属性数值值-方便取值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.common_styleable);

        ///< 获取用户设置相关值
        String padding = ta.getString(R.styleable.common_styleable_s_paddings);
        if (null != padding) {
            String[] paddings = padding.split(",");
            padding_l = DensityUtil.dip2px(context, Integer.valueOf(paddings[0]));
            padding_t = DensityUtil.dip2px(context, Integer.valueOf(paddings[1]));
            padding_r = DensityUtil.dip2px(context, Integer.valueOf(paddings[2]));
            padding_b = DensityUtil.dip2px(context, Integer.valueOf(paddings[3]));
        }
        bg_color = ta.getColor(R.styleable.common_styleable_s_bg_color, -1);
        corner_radius = ta.getDimensionPixelOffset(R.styleable.common_styleable_s_corner_radius, 0);

        stroke_w = ta.getDimensionPixelOffset(R.styleable.common_styleable_s_stroke_w, -1);
        stroke_color = ta.getColor(R.styleable.common_styleable_s_stroke_color, -1);
        if (-1 == stroke_color && -1 != bg_color) {
            stroke_color = bg_color;
        }
        shape = ta.getInt(R.styleable.common_styleable_s_shape, -1);
        if (-1 == shape){
            shape = GradientDrawable.RECTANGLE;
        }

        ///< 圆环属性
        outer_color = ta.getColor(R.styleable.common_styleable_s_outer_color, -1);
        inner_color = ta.getColor(R.styleable.common_styleable_s_inner_color, -1);
        outer_radius = ta.getDimensionPixelOffset(R.styleable.common_styleable_s_outer_radius, 0);

        ///< 渐变
        int g_orientation = ta.getInt(R.styleable.common_styleable_s_gradient_orientation, -1);
        if (-1 != g_orientation){
            gradient_orientation = GradientDrawable.Orientation.values()[g_orientation];
        }
        gradient_angle = ta.getFloat(R.styleable.common_styleable_s_gradient_angle, -1);
        gradient_centerX = ta.getFloat(R.styleable.common_styleable_s_gradient_centerx, -1);
        gradient_centerY = ta.getFloat(R.styleable.common_styleable_s_gradient_centery, -1);
        gradient_startColor = ta.getColor(R.styleable.common_styleable_s_gradient_startcolor, -1);
        gradient_endColor = ta.getColor(R.styleable.common_styleable_s_gradient_endcolor, -1);
        gradient_type = ta.getInt(R.styleable.common_styleable_s_gradient_type, -1);
        if (-1 == gradient_type){
            gradient_type = GradientDrawable.LINEAR_GRADIENT;
        }

        ///< 按下状态 - 只做边缘处理
        press_stoke_bg_color = ta.getColor(R.styleable.common_styleable_s_pressed_stroke_bg_color, -1);
        press_bg_color = ta.getColor(R.styleable.common_styleable_s_pressed_bg_color, -1);

        ta.recycle();
    }
}
