package com.hl.commonuitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.hl.commonui.SWebview;

public class WebviewActivity extends AppCompatActivity {
    private SWebview sWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        sWebview = findViewById(R.id.sWebview);
        sWebview.enableZoom(false);
        sWebview.setUrl("https://www.baidu.com");
        //sWebview.setUrl("https://www.lieyunwang.com");
        //sWebview.loadUrl("file:///android_asset/js_java_interaction.html");
    }

    /**
     * 设置返回键动作（防止按返回键直接退出程序)
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.getAction() == KeyEvent.ACTION_DOWN) {
            if (sWebview.canGoBack()) {  ///< 当webview不是处于第一页面时，返回上一个页面
                sWebview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
