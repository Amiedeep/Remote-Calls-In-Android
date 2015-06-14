package com.mycompany.remotecallsinandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {
//    String URL = "https://anujapp.herokuapp.com/api";
//    JSONParser jsonParser;
//    static InputStream is = null;
//    static JSONObject json = null;
//    static String outPut = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


//    public void getRemoteProducts(View view) {
//        jsonParser = new JSONParser();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
////            System.out.println(url);
//        HttpGet httpGet = new HttpGet("http://www.google.com");
//        System.out.println(httpGet);
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        JSONObject json = jsonParser.getJSONFromUrl(URL);
//        System.out.println(json);
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void getJSONFromUrl(View view) {

//this will pop up a list of app's you want to use...
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "hello");
//        sendIntent.setType(HTTP.PLAIN_TEXT_TYPE); // "text/plain" MIME type
//
//// Verify that the intent will resolve to an activity
//        if (sendIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(sendIntent);
//        }


        EditText view1 = (EditText)findViewById(R.id.api_address);
        ASYNCTask task = new ASYNCTask();

        AsyncTask task1 = task.execute(view1.getText().toString());
        try {
            System.out.println(task1.get().equals("[{\"id\":1,\"type_of_product\":\"Drinks\",\"name\":\"Pepsi\",\"company\":\"Cocacola\",\"price\":\"10000\",\"created_at\":\"2015-06-10T07:41:01.585Z\",\"updated_at\":\"2015-06-10T07:41:01.585Z\"}]"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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
