package com.mycompany.remotecallsinandroid;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {
    String URL = "https://anujapp.herokuapp.com/api";
    JSONParser jsonParser;
    static InputStream is = null;
    static JSONObject json = null;
    static String outPut = "";
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

    public void getJSONFromUrl(View view) throws ExecutionException, InterruptedException, JSONException {
        EditText view1 = (EditText)findViewById(R.id.api_address);
        ASYNCTask task = new ASYNCTask();

        AsyncTask task1 = task.execute(view1.getText().toString());
        Object str = task1.get();

        System.out.println(str);
        System.out.println();
        JSONArray array = new JSONArray((String)str);

        JSONObject obj = array.getJSONObject(0);
        System.out.println(obj);
        System.out.println();
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
