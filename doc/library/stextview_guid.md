# API说明-STextView.java
# USE 
> 支持以下属性(不设置就是普通文本框) - 根据需求，不用全部设置.
```Java
app:s_bg_color="#9e9e9e"        - 背景颜色
app:s_corner_radius="4dp"       - 圆角半径
app:s_paddings="10,4,10,4"      - 内容间距
app:s_stroke_color="#009BFB"    - 边框线颜色
app:s_stroke_w="1dp"            - 边框线宽度(厚度)   
  
app:s_gradient_angle="180"                  - 渐变-角度
app:s_gradient_centerx="0.02"               - 渐变-中心x位置
app:s_gradient_centery="1.0"                - 渐变-中心y位置
app:s_gradient_endcolor="#28b3ff"           - 渐变-终止颜色
app:s_gradient_orientation="LEFT_RIGHT"     - 渐变方向
app:s_gradient_startcolor="#3a91fd"         - 渐变-起始颜色
app:s_gradient_type="LINEAR_GRADIENT"       - 渐变类型
  
app:s_pressed_bg_color="#9e9e9e"        - 按下状态-背景颜色
app:s_pressed_stroke_bg_color="#777777" - 按下状态-边框颜色
```
# USE 
a. 圆角、边缘stroke、背景颜色、padding设置文本框
```Java   
<com.hl.commonui.STextView
        android:id="@+id/am_loginTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:text="登录"
        android:textColor="@color/white"
        android:textSize="16sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:s_bg_color="#9e9e9e"
        app:s_corner_radius="4dp"
        app:s_paddings="10,4,10,4"
        app:s_stroke_color="#009BFB"
        app:s_stroke_w="1dp" />
```
b. 增加圆环、渐变、以及按下简单状态设置(可以设置按下边框颜色、背景颜色) -完整粘贴
```Java   
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white"
    tools:context=".MainActivity">

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:text="登录"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:s_bg_color="#9e9e9e"
        app:s_corner_radius="4dp"
        app:s_paddings="10,4,10,4"
        app:s_stroke_color="#009BFB"
        app:s_stroke_w="1dp" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTvR"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:text="注册"
        android:textColor="@color/black"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv"
        app:layout_constraintTop_toTopOf="parent"
        app:s_corner_radius="4dp"
        app:s_paddings="10,4,10,4"
        app:s_stroke_color="#cccccc"
        app:s_stroke_w="1dp" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:text="02日/04月"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/am_loginTv"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:text="1日/04"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv2"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv2"
        app:s_corner_radius="100dp"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:text="02日/04月"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv3"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv2"
        app:s_corner_radius="100dp"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT"
        app:s_paddings="10,4,10,4" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:text="哇塞"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv4"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv2"
        app:s_corner_radius="100dp"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT"
        app:s_paddings="10,4,10,4"
        app:s_stroke_color="@color/black_a"
        app:s_stroke_w="1dp" />

    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv6"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="5dp"
        android:gravity="center"
        android:text="圆/椭圆"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/am_loginTv2"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT"
        app:s_shape="OVAL"
        app:s_stroke_color="@color/red_a"
        app:s_stroke_w="1dp" />

    <!--内部渐变-->
    <!--app:s_gradient_angle="180"-->
    <!--app:s_gradient_centerx="0.02"-->
    <!--app:s_gradient_centery="1.0"-->
    <!--app:s_gradient_endcolor="#28b3ff"-->
    <!--app:s_gradient_orientation="LEFT_RIGHT"-->
    <!--app:s_gradient_startcolor="#3a91fd"-->
    <!--app:s_gradient_type="LINEAR_GRADIENT"-->
    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv7"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="10dp"
        android:gravity="center"
        android:text="圆环"
        android:textColor="@color/black_a"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv6"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv6"
        app:s_inner_color="@color/white"
        app:s_outer_color="@color/blue_b"
        app:s_outer_radius="25dp"
        app:s_shape="RING" />

    <!--圆环外环-外环有按下状态变化-->
    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv8"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="10dp"
        android:gravity="center"
        android:text="按下1"
        android:textColor="@color/black_a"
        android:textSize="15sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv7"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv7"
        app:s_inner_color="@color/white"
        app:s_outer_color="@color/blue_b"
        app:s_outer_radius="12dp"
        app:s_pressed_stroke_bg_color="@color/blue_a"
        app:s_shape="RING" />

    <!--圆角无背景-边缘按下状态变化-->
    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv9"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:text="按下2"
        android:textColor="@color/black"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/am_loginTv8"
        app:layout_constraintTop_toTopOf="@+id/am_loginTv8"
        app:s_corner_radius="4dp"
        app:s_paddings="10,4,10,4"
        app:s_pressed_stroke_bg_color="@color/deep_gray"
        app:s_stroke_color="#cccccc"
        app:s_stroke_w="1dp" />

    <!--渐变圆角-按下边缘有按下状态变化-->
    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv10"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:text="按下3"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="@+id/am_loginTv9"
        app:layout_constraintTop_toBottomOf="@+id/am_loginTv9"
        app:s_corner_radius="100dp"
        app:s_gradient_angle="180"
        app:s_gradient_centerx="0.02"
        app:s_gradient_centery="1.0"
        app:s_gradient_endcolor="#28b3ff"
        app:s_gradient_orientation="LEFT_RIGHT"
        app:s_gradient_startcolor="#3a91fd"
        app:s_gradient_type="LINEAR_GRADIENT"
        app:s_paddings="10,4,10,4"
        app:s_pressed_stroke_bg_color="@color/blue_b"
        app:s_stroke_color="@color/black_a"
        app:s_stroke_w="1dp" />

    <!--圆角stroke-按下边缘、背景均有按下状态变化-->
    <com.hl.commonui.STextView
        android:id="@+id/am_loginTv11"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:text="按下4"
        android:textColor="@color/black"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="@+id/am_loginTv10"
        app:layout_constraintTop_toBottomOf="@+id/am_loginTv10"
        app:s_bg_color="#f6f6f6"
        app:s_corner_radius="4dp"
        app:s_paddings="10,4,10,4"
        app:s_pressed_bg_color="#9e9e9e"
        app:s_pressed_stroke_bg_color="#777777"
        app:s_stroke_color="#cccccc"
        app:s_stroke_w="1dp" />

</android.support.constraint.ConstraintLayout>
```