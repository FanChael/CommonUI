package com.hl.commonuitest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

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
        sWebview.setLoadListenner(new SWebview.LoadCallBack() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理文件选择回调事件 - 不添加，则不会处理选择的文件
        sWebview.onActivityResult(requestCode, resultCode, data);
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
