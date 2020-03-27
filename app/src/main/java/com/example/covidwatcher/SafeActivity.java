package com.example.covidwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class SafeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        WebView wv = findViewById(R.id.webview);
        wv.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/prepare/prevention.html");

    }
}
