package com.example.administrator.nettest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.administrator.nettest.R.id.clientBt;


public class HttpClientActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);
        Button bt= (Button) this.findViewById(clientBt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread td=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpClient cliet=new DefaultHttpClient();
                        HttpGet get=new HttpGet("http://192.168.199.104:8080/bianMeile/user/getAllUser.action?mobile=13053549598");
                        try {
                            HttpResponse response=cliet.execute(get);
                            HttpEntity entity=response.getEntity();
                            InputStream is=entity.getContent();
                            BufferedReader br=new BufferedReader(new InputStreamReader(is));
                            String line=null;
                            StringBuffer sb=new StringBuffer();
                            while((line=br.readLine())!=null){
                                sb.append(line);
                            }
                            System.out.println(sb.toString());
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
