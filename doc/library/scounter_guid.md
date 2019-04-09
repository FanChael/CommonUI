# API说明-CounterCircleView.java CounterOvalView.java
# USE 
> 支持以下属性 - 具体看如下解释即可
```Java
<!--计时器属性配置-->
    <declare-styleable name="counterview_styleable">
        <!--倒计时公共属性-->
        <!--倒计时总数 - 不是百分比的话一般是10,5这些；百分比的话就是100之类的-->
        <attr name="s_c_counter_number" format="float"></attr>
        <!--是否是百分比倒计时-->
        <attr name="s_c_b_percent" format="boolean"></attr>
        <!--圆形倒计时 - 内环颜色   圆角倒计时 - 背景颜色，记得带透明度才好看-->
        <attr name="s_c_inner_color" format="color"></attr>

        <!--圆形倒计时-配置属性-->
        <!--是否显示外环倒计时-->
        <attr name="s_c_b_showouter" format="boolean"></attr>
        <!--外环大小-->
        <attr name="s_c_out_size" format="dimension"></attr>
        <!--文本颜色-->
        <attr name="s_c_text_color" format="color"></attr>
        <!--内环颜色透明度-->
        <attr name="s_c_inner_color_alpha" format="integer"></attr>
        <!--外环颜色-->
        <attr name="s_c_outer_color" format="color"></attr>

        <!--圆角倒计时-配置属性-非自定义View-->
        <!--圆角大小-->
        <attr name="s_c_corners" format="dimension"></attr>
        <!--文本前缀，比如跳过，内部包装为"跳过(5s)"-->
        <attr name="s_c_prefix" format="string"></attr>
    </declare-styleable>
```
# USE - 控件配置
a. 通过属性设置是否显示外环倒计时、外环颜色、内环颜色、文本颜色、倒计时总数等 - 圆形方式
```Java   
    <!--圆形倒计时-->
    <com.hl.commonui.CounterCircleView
        android:id="@+id/am_counterCircle"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="6dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:s_c_b_percent="false"
        app:s_c_b_showouter="true"
        app:s_c_counter_number="10"
        app:s_c_inner_color="#000000"
        app:s_c_inner_color_alpha="10"
        app:s_c_out_size="2dp"
        app:s_c_outer_color="#2773FF"
        app:s_c_text_color="#334081" />
```
b. 通过属性设置圆角大小、背景、倒计时总数等 - 圆角方式方式
```Java   
    <!--圆角倒计时-->
    <com.hl.commonui.CounterOvalView
        android:id="@+id/am_counterOval"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="6dp"
        android:text="@color/white"
        app:layout_constraintStart_toEndOf="@+id/am_counterCircle"
        app:layout_constraintTop_toTopOf="parent"
        app:s_c_corners="80dp"
        app:s_c_counter_number="10"
        app:s_c_inner_color="#60333333"
        app:s_c_prefix="跳过鸭" />
```
# USE - 代码控制启动以及设置倒计时回调(简单玩了把kotlin，Java直接设置时new回调就行)  
```Java 
 /**
     * 计时器回调鸭
     */
    class CallBack: EventListenner.CounterCallBack{
        var mcontext:Context

        constructor(context: Context){
            mcontext = context
        }

        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            Toast.makeText(mcontext, "结束了", Toast.LENGTH_SHORT).show()
        }

        override fun onClick(view: View?) {
            Toast.makeText(mcontext, "点我鸭", Toast.LENGTH_SHORT).show()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            //am_loginTv.text = stringFromJNI()
            var callBack = CallBack(this)
            am_counterCircle.setCounterCallBack(callBack)
            ///< 启动倒计时
            am_counterCircle.start()
            am_counterOval.setCounterCallBack(callBack)
            am_counterOval.start()
            ///< 取消倒计时
            //am_counterOval.cancel();
        }
```

# ATTENTION  
1.CounterOvalView继承AppCompatTextView，所以自行设置文本，颜色和文本大小  