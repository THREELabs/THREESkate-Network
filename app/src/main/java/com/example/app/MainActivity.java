package com.THREESkate.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new com.THREESkate.app.MyWebViewClient());

        //Improve webView performance Disabled for now
        //mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH); // Sets Priority
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // Use cache resources if available
        mWebView.getSettings().setAppCacheEnabled(true); // enables cache
        webSettings.setDomStorageEnabled(true);

        // REMOTE RESOURCE
         mWebView.loadUrl("https://threeskate.com/webview/");

        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}