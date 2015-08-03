package com.example.administrator.nettest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class HttpURLConnectActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnect);
        Button bt= (Button) this.findViewById(R.id.bt_start);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread td=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String urlStr="http://192.168.199.104:8080/bianMeile/user/getAllUser.action";
                        HttpURLConnection  conn;
                        URL rul= null;
                        try {
                            rul = new URL(urlStr);
                            conn = (HttpURLConnection) rul.openConnection();
                            conn.setDoOutput(true);
                            conn.setDoInput(true);
                            conn.setRequestMethod("POST");
                            conn.setUseCaches(false);
                            conn.connect();
                            OutputStream os=conn.getOutputStream();
                            DataOutputStream dos=new DataOutputStream(os);
                            dos.writeBytes("name="+ URLEncoder.encode("ÄãºÃ","UTF-8"));
                            dos.writeBytes("mobile=13053549598");
                            dos.close();
                            InputStream is = conn.getInputStream();
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String line = null;
                            StringBuffer sb = new StringBuffer();
                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                            }
                            System.out.println("================this is resource=============");
                            System.out.println(sb.toString());
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                td.start();
            }

        });
    }
}
