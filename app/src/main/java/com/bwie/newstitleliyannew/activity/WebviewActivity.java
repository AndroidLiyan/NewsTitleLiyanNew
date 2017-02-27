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
import com.umeng.message.PushAgent;

public class WebviewActivity extends AppCompatActivity {

    private WebView webview;
    private ProgressBar bar;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        setContentView(R.layout.activity_webview);
        Intent it = getIntent();
        url = it.getStringExtra("url");
        webview = (WebView) findViewById(R.id.webview);
        bar = (ProgressBar) findViewById(R.id.bar);
        setwebView();
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
