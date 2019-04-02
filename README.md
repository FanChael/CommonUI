# CommonUI - Android公共/基础组件库
[ ![Download](https://api.bintray.com/packages/resetmyself/holdon/commonui/images/download.svg?version=1.0.0) ](https://bintray.com/resetmyself/holdon/commonui/1.0.0/link) 

（Android common/base component library - Android常用控件封装整理集合，有需求/问题请issue）.  
# Description
>主要利用自定义属性、动态创建GradientDrawable等方式进行组合包装  

>经过三个项目，觉得还是有个基础组件库比较方便(不然总要去搬shape)  

# Feature  

>起个头,TextView走起(背景、字体颜色、圆角大小、描边stroke宽度和颜色) - 愚人节快乐!  

>增加圆环、渐变、以及按下简单状态设置(可以设置按下边框颜色、背景颜色)  

>将会持续完善...  

# Effect  
>总的效果 
  
<table border="1">
  <tr>
    <th>文本控件_Rectangle</th>
    <th>文本控件_增加渐变+按下简单状态</th>
  </tr>
  <tr>
    <td><img src="https://github.com/FanChael/CommonUI/blob/master/doc/2019.04.01_stextview_rectangle.jpg" width="228" height="374" alt="文本控件_Rectangle"/></td>
    <td><img src="https://github.com/FanChael/CommonUI/blob/master/doc/2019.04.02_stextview_alla.gif" width="228" height="374" alt="文本控件_增加渐变+按下简单状态"/></td>
  </tr>
</table> 

##### [Demo apk下载](https://github.com/FanChael/CommonUI/blob/master/doc/commonui.apk)

# Import Library  
>For gradle:  
```Java
//文本框走起
implementation 'com.hl:uilibrary:1.0.1'
```
>Or in maven:  
```Java
<dependency>
    <groupId>com.hl</groupId>
    <artifactId>uilibrary</artifactId>
    <version>1.0.1</version>
    <type>pom</type>
</dependency>
```
# 传送门  
> 使用
* [文本框使用](https://github.com/FanChael/CommonUI/blob/master/doc/library/stextview_guid.md)

> Hold on！
* [更新日志](https://github.com/FanChael/CommonUI/blob/master/doc/library/update_guid.md)
* [学习博客](https://github.com/FanChael/CommonUI/blob/master/doc/library/study_guid.md)
* [指教交流QQ群: 752871516](https://github.com/FanChael/CommonUI#传送门)

# ATTENTION  
1.目前支持属性(均以s_开头)配置在<declare-styleable name="common_styleable">中，如下:  
```Java
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="common_styleable">
        <!--声明我们的属性，名称为radius,取值类型为尺寸类型（dp,px等）-->
        <attr name="s_corner_radius" format="dimension"></attr>
        <!--声明我们的属性，名称为paddings, 分别为"l,t,r,b"的px值-->
        <attr name="s_paddings" format="string"></attr>
        <attr name="s_bg_color" format="color"></attr>
        <attr name="s_stroke_w" format="dimension"></attr>
        <attr name="s_stroke_color" format="color"></attr>
        <attr name="s_shape" format="enum">
            <enum name="RECTANGLE" value="0" />
            <enum name="OVAL" value="1" />
            <enum name="LINE" value="2" />
            <enum name="RING" value="3" />
        </attr>
        <!--圆环属性-->
        <attr name="s_outer_radius" format="dimension"></attr>
        <attr name="s_inner_color" format="color"></attr>
        <attr name="s_outer_color" format="color"></attr>
        <!--渐变-->
        <attr name="s_gradient_orientation" format="enum">
            <enum name="TOP_BOTTOM" value="0" />
            <enum name="TR_BL" value="1" />
            <enum name="RIGHT_LEFT" value="2" />
            <enum name="BR_TL" value="3" />
            <enum name="BOTTOM_TOP" value="4" />
            <enum name="BL_TR" value="5" />
            <enum name="LEFT_RIGHT" value="6" />
            <enum name="TL_BR" value="7" />
        </attr>
        <attr name="s_gradient_angle" format="float"></attr>
        <attr name="s_gradient_centerx" format="float"></attr>
        <attr name="s_gradient_centery" format="float"></attr>
        <attr name="s_gradient_startcolor" format="color"></attr>
        <attr name="s_gradient_endcolor" format="color"></attr>
        <attr name="s_gradient_type" format="enum">
            <enum name="LINEAR_GRADIENT" value="0" />
            <enum name="RADIAL_GRADIENT" value="1" />
            <enum name="SWEEP_GRADIENT" value="2" />
        </attr>
        <!--按下状态颜色 - 内部只做边缘变化处理-->
        <attr name="s_pressed_stroke_bg_color" format="color"></attr>
        <attr name="s_pressed_bg_color" format="color"></attr>
    </declare-styleable>
</resources>
```
2.后续关于GradientDrawable的使用慢慢完善后提出工具类使用，届时对外也提供方法...   
