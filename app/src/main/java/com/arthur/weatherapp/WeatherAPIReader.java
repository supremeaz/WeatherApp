package com.arthur.weatherapp;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Arthur on 25/01/2016.
 */
public class WeatherAPIReader extends AsyncTask<String,Void,String> {
    String content="";
    @Override
    protected String doInBackground(String... url) {
        try {

            URL apiURL=new URL(url[0]);
            HttpURLConnection connection=(HttpURLConnection)apiURL.openConnection();
            InputStream in=connection.getInputStream();
            InputStreamReader inReader=new InputStreamReader(in);
            int current=inReader.read();
            while(current!=-1){
                content+=(char)current;
                current=inReader.read();
            }
            return content;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Failed";
    }
    protected void onPostExecute(String s){
        super.onPostExecute(s);
    }
}
