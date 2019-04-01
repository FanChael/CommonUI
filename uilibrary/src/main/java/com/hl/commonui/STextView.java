package com.hl.commonui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import com.hl.commonui.utils.DensityUtil;

/*
 *@Description: 扩展TextView
 *@Author: hl
 *@Time: 2019/4/1 11:53
 */
public class STextView extends android.support.v7.widget.AppCompatTextView {
    private int padding_l = 0;
    private int padding_t = 0;
    private int padding_r = 0;
    private int padding_b = 0;
    private int bg_color;
    private int corner_radius;
    private int stroke_w = -1;
    private int stroke_color;

    public STextView(Context context) {
        this(context, null);
    }

    public STextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public STextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intStyledAttributes(context, attrs, defStyleAttr);
        setAttributes();
    }

    /**
     * 设置基本属性
     */
    private void setAttributes() {
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        if (-1 != bg_color){
            gd.setColor(bg_color);
        }
        if (corner_radius > 0) {
            gd.setCornerRadius(corner_radius);
        }
        if (stroke_w > 0) {
            gd.setStroke(stroke_w, stroke_color);
        }
        this.setBackgroundDrawable(gd);

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

        ta.recycle();
    }
}
