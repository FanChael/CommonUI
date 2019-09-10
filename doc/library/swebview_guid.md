# API说明-SWebview.java
# 属性 
> 支持以下属性 - 进度条样式
```Java
        <!--进度条属性-->
        <attr name="s_progress_h" format="dimension"></attr>
        <attr name="s_corner_radius" format="dimension"></attr>
        <attr name="s_bg_color" format="color"></attr>
        <attr name="s_progress_color" format="color"></attr>
```
> 加载监听回调
```Java
/**
     * 加载回调
     */
    public interface LoadCallBack {
        // false -> 不拦截   true -> 拦截网页内的点击跳转
        boolean shouldOverrideUrlLoading(WebView view, String url);
        void onReceivedError(WebView view, int errorCode,
                             String description, String failingUrl);
        void onPageFinished(WebView view, String url);

        void onReceivedTitle(WebView view, String title);
    }
```
# USE 
a. 通过属性主要是设置顶部进度条的样式
```Java   
  <!--支持顶部进度条定义 - 不定义则不显示-->
    <com.hl.commonui.SWebview
        android:id="@+id/sWebview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:s_bg_color="#009BFB"
        app:s_corner_radius="1dp"
        app:s_progress_color="#e4e4e4"
        app:s_progress_h="4dp" />
```

# 对外的方法  
```Java
/**
     * 开启缩放 - 默认是不允许缩放
     * @param bHideControlTool - 支持缩放的同时是否显示缩放控件
     */
    public void enableZoom(boolean bHideControlTool) {
    }

    /**
     * 设置Url/注入Js - url
     *
     * @param urlOrJs
     */
    public void setUrl(String urlOrJs) {
    }

    /**
     * 设置html文本 - data字符串
     *
     * @param hmtlData
     */
    public void setHtml(String hmtlData) {
    }
    
    /**
     * 设置加载监听回调
     *
     * @param _loadListenner
     */
    public void setLoadListenner(LoadCallBack _loadListenner) {
    }      
```

# USE - 代码控制是否显示Webview缩放控件以及加载数据+设置监听回调(回调可以获取网页title)
```Java 
         SWebview sWebview = findViewById(R.id.sWebview);
         sWebview.enableZoom(false);
         //sWebview.setUrl("https://www.baidu.com");
         sWebview.setUrl("https://www.lieyunwang.com");
         //sWebview.loadUrl("file:///android_asset/js_java_interaction.html");
         sWebview.setLoadListenner(new SWebview.LoadCallBack() {
                     @Override
                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                         return false;   // 表示不拦截
                         // return true; // 拦截网页内的点击跳转
                         // if (url.contains("lywselflink=1")){return false;} //特定的链接允许跳转
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
```

# ATTENTION  
1.如果返回键要能依次返回上一个页面，需要拦截物理返回监听事件并做处理
```Java
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
```
2.如果要支持选择本地文件并进行处理，需要在onActivityResult中添加如下设置:
```Java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理文件选择回调事件 - 不添加，则不会处理选择的文件
        sWebview.onActivityResult(requestCode, resultCode, data);
    }
```