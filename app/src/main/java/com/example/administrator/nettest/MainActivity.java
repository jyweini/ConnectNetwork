package com.example.administrator.nettest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnect);
//        ConnectivityManager connManager=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo ni=connManager.getActiveNetworkInfo();
//        if(ni.isAvailable()){
//            Toast.makeText(this, "网络连接正常" + ni.getTypeName(), Toast.LENGTH_LONG).show();
//
//        }
//        else{
//            Toast.makeText(MainActivity.this, "网络连接异常, 请连接网络",Toast.LENGTH_LONG).show();
//            startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
//
//        }
//
//        NetworkInfo.State state=connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
//        if(NetworkInfo.State.CONNECTED==state){
//            Log.i("通知", "WIFI网络已连接");
//        }

//        if(ni.getType()==ConnectivityManager.TYPE_WIFI){
//            startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
//        }
//        else if(ni.getType()==ConnectivityManager.TYPE_MOBILE){
//            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
//        }
//        WebView webView=(WebView)this.findViewById(R.id.webView);
//        webView.loadUrl("http://www.baidu.com");
//        webView.getSettings().setJavaScriptEnabled(true);
    }


}
