package com.codepolitan.myapplicationviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.codepolitan.myapplicationviewpager.artikel.Artikel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Artikel artikel = intent.getParcelableExtra("ARTIKEL");
       // String title = intent.getStringExtra("title");
       // String link = intent.getStringExtra("link");

        //webview melempar browser ke sumber web asalnya
        Log.d("artikel",artikel.getLink());
        WebView webView = findViewById(R.id.browser);
        webView.setWebViewClient(new WebViewClient()); //webview di platform client
        webView.loadUrl(artikel.getLink());
        //webView.loadUrl(link);
        getSupportActionBar().setTitle("Artikel");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            finish();
            //onBackPressed();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
