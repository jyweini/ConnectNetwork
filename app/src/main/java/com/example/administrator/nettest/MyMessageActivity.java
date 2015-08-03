package com.example.administrator.nettest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import java.util.logging.LogRecord;


public class MyMessageActivity extends Activity {
    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        showMessage= (TextView) findViewById(R.id.showMessage);
        Thread td=new Thread((new Runnable() {
            @Override
            public void run() {
                String urlStr="http://192.168.199.104:8080/bianMeile/user/getAllUser.action";
                HttpURLConnection conn;
                URL rul= null;
                StringBuffer sb = new StringBuffer();
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
                    dos.writeBytes("name="+ URLEncoder.encode("ÄãºÃ", "UTF-8"));
                    dos.writeBytes("mobile=13053549598");
                    dos.close();
                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = null;

                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
//                    System.out.println("================this is resource=============");
//                    System.out.println(sb.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message msg=handler.obtainMessage();
                msg.what=1;
                Bundle bd=new Bundle();
                bd.putString("status",sb.toString());
                msg.setData(bd);
                handler.sendMessage(msg);
            }
        }));
        td.start();
    }

    private Handler handler=new Handler() {
        public void handleMessage(Message msg){
           String status=msg.getData().getString("status");
            int what=msg.what;
            if(what==1){
                showMessage.setText(status);
            }

        }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
