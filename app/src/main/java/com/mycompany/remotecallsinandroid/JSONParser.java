package com.mycompany.remotecallsinandroid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

public class JSONParser extends AsyncTask<URL, Integer, Long> {

    static InputStream is = null;
    static JSONObject json = null;
    static String outPut = "";
    private static final String TAG = "MainActivity";


    // constructor
    public JSONParser() {

    }

    @Override
    protected Long doInBackground(URL... params) {
        return null;
    }

    public JSONObject getJSONFromUrl(String url) {

        // Making the HTTP request
        System.out.println();
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
//            System.out.println(url);
            HttpGet httpGet = new HttpGet("http://www.google.com");
            System.out.println(httpGet);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity(); // todo
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            outPut = sb.toString();
            Log.e("JSON", outPut);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        try {
            json = new JSONObject(outPut);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return json;

    }
}