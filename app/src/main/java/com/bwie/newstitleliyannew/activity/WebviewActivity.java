package com.bwie.newstitleliyannew.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.custom.MyCustomTitleBar;
import com.umeng.message.PushAgent;

public class WebviewActivity extends BaseActivity {

    private WebView webview;
    private ProgressBar bar;
    private String url;
    private MyCustomTitleBar title_bar;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        setContentView(R.layout.activity_webview);
        Intent it = getIntent();
        url = it.getStringExtra("url");
        title = it.getStringExtra("title");
        webview = (WebView) findViewById(R.id.webview);
        bar = (ProgressBar) findViewById(R.id.bar);
        title_bar = (MyCustomTitleBar) findViewById(R.id.title_bar);
        setwebView();
        title_bar.setTitlrText(title);
        title_bar.setbtnOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //设置webview
    private void setwebView() {
        webview.loadUrl(url);
        webview.setBackgroundColor(0);
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                bar.setProgress(newProgress);
            }
        });
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
