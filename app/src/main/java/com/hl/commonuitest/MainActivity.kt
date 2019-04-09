package com.hl.commonuitest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.hl.commonui.event.EventListenner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        am_counterCircle.start()
        am_counterOval.setCounterCallBack(callBack)
        am_counterOval.start()
        ///< 取消倒计时
        //am_counterOval.cancel();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
