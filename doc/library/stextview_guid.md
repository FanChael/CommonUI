# API说明-STextView.java
# USE 
> 支持以下属性(不设置就是普通文本框)
```Java
app:s_bg_color="#9e9e9e"        - 背景颜色
app:s_corner_radius="4dp"       - 圆角半径
app:s_paddings="10,4,10,4"      - 内容间距
app:s_stroke_color="#009BFB"    - 边框线颜色
app:s_stroke_w="1dp"            - 边框线宽度(厚度) 
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