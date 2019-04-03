# API说明-SSwitch.java
# USE 
> 支持以下属性- 分通过属性(stroke可以不设置)和drawable的形式设置开关样式
```Java
    <!--开关属性-->
    <declare-styleable name="sswitch_styleable">
        <!--通过属性GradientDrawable的形式 _s为按下状态-->
        <!--背景样式-->
        <attr name="s_track_bg_color" format="color"></attr>
        <attr name="s_track_bg_s_color" format="color"></attr>
        <attr name="s_track_stroke_color" format="color"></attr>
        <attr name="s_track_stroke_s_color" format="color"></attr>
        <attr name="s_track_corner_radius" format="dimension"></attr>

        <!--开关样式-->
        <attr name="s_thumb_bg_color" format="color"></attr>
        <attr name="s_thumb_bg_s_color" format="color"></attr>
        <attr name="s_thumb_stroke_color" format="color"></attr>
        <attr name="s_thumb_stroke_s_color" format="color"></attr>
        <attr name="s_thumb_size" format="dimension"></attr>
        
        <!--设置thumb特殊的宽度-如果设置了这个宽度，则不再是s_thumb_size作为宽度-->
        <attr name="s_thumb_special_w" format="dimension"></attr>

        <!--图片的形式设置-->
        <attr name="s_track_drawble" format="reference"></attr>
        <attr name="s_track_s_drawble" format="reference"></attr>
        <attr name="s_thumb_drawble" format="reference"></attr>
        <attr name="s_thumb_s_drawble" format="reference"></attr>
    </declare-styleable>
```
# USE 
a. 通过属性设置样式
```Java   
    <!--switch默认大小开关-->
    <com.hl.commonui.SSwitch
        android:id="@+id/am_switchSS"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:checked="true"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:s_thumb_bg_color="#D5D5D5"
        app:s_thumb_bg_s_color="#3a91fd"
        app:s_thumb_stroke_color="#aa91fd"
        app:s_thumb_stroke_s_color="#FF0000"
        app:s_track_bg_color="#BEBEBE"
        app:s_track_bg_s_color="#28b3ff"
        app:s_track_corner_radius="15dp"
        app:s_track_stroke_color="#aa91fd"
        app:s_track_stroke_s_color="#FF0000" />

    <!--switch设置宽高 - 宽度不设置具体值时=高度*2-->
    <com.hl.commonui.SSwitch
        android:id="@+id/am_switchSSa"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        android:layout_marginTop="6dp"
        android:checked="true"
        app:layout_constraintStart_toStartOf="@+id/am_switchSS"
        app:layout_constraintTop_toBottomOf="@+id/am_switchSS"
        app:s_thumb_bg_color="#D5D5D5"
        app:s_thumb_bg_s_color="#3a91fd"
        app:s_thumb_stroke_color="#aa91fd"
        app:s_thumb_stroke_s_color="#FF0000"
        app:s_track_bg_color="#BEBEBE"
        app:s_track_bg_s_color="#28b3ff"
        app:s_track_corner_radius="35dp"
        app:s_track_stroke_color="#aa91fd"
        app:s_track_stroke_s_color="#FF0000" />

    <!--switch默认宽度+高度以thumb_size为准-->
    <com.hl.commonui.SSwitch
        android:id="@+id/am_switchSSb"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:checked="true"
        app:layout_constraintStart_toStartOf="@+id/am_switchSSa"
        app:layout_constraintTop_toBottomOf="@+id/am_switchSSa"
        app:s_thumb_bg_color="#D5D5D5"
        app:s_thumb_bg_s_color="#3a91fd"
        app:s_thumb_size="30dp"
        app:s_thumb_stroke_color="#aa91fd"
        app:s_thumb_stroke_s_color="#FF0000"
        app:s_track_bg_color="#BEBEBE"
        app:s_track_bg_s_color="#28b3ff"
        app:s_track_corner_radius="15dp"
        app:s_track_stroke_color="#aa91fd"
        app:s_track_stroke_s_color="#FF0000" />

    <!--switch默认宽度+高度以thumb_size为准-->
    <com.hl.commonui.SSwitch
        android:id="@+id/am_switchSSb2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:checked="true"
        app:layout_constraintStart_toStartOf="@+id/am_switchSSb"
        app:layout_constraintTop_toBottomOf="@+id/am_switchSSb"
        app:s_thumb_bg_color="#D5D5D5"
        app:s_thumb_bg_s_color="#3a91fd"
        app:s_thumb_size="30dp"
        app:s_thumb_special_w="45dp"
        app:s_thumb_stroke_color="#aa91fd"
        app:s_thumb_stroke_s_color="#FF0000"
        app:s_track_bg_color="#BEBEBE"
        app:s_track_bg_s_color="#28b3ff"
        app:s_track_corner_radius="15dp"
        app:s_track_stroke_color="#aa91fd"
        app:s_track_stroke_s_color="#FF0000" />
```
b. switch设置图片的方式实现 - 如果不设置宽高要保证图片尺寸哟!
```Java   
<com.hl.commonui.SSwitch
        android:id="@+id/am_switchSSc"
        android:layout_width="166dp"
        android:layout_height="50dp"
        android:layout_marginTop="6dp"
        android:checked="true"
        app:layout_constraintStart_toStartOf="@+id/am_switchSSb"
        app:layout_constraintTop_toBottomOf="@+id/am_switchSSb"
        app:s_thumb_drawble="@drawable/test"
        app:s_thumb_s_drawble="@drawable/test"
        app:s_track_drawble="@drawable/testa"
        app:s_track_s_drawble="@drawable/testb" />
```
# ATTENTION  
1.注意如下样式(开关按钮可以设置为非圆形,此时设置s_thumb_special_w的宽度即可)   
<img src="https://github.com/FanChael/CommonUI/blob/master/doc/switch01.png" width="228" height="374" alt="switch01"/>  