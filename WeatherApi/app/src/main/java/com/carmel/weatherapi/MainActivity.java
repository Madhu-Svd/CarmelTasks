package com.carmel.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    class WeatherInfo extends AsyncTask<String, Void, String >{

        @Override
        protected String doInBackground(String... strings) {

            try {

                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                urlConnection.connect();

                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);

                int data=inputStreamReader.read();
                String apiDeatils="";
                char current;

                while (data!=-1){
                    current=(char) data;
                    apiDeatils+=current;
                    data=inputStreamReader.read();
                }
                return apiDeatils;
            }catch (Exception e){

            }
            return null;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherInfo weatherInfo=new WeatherInfo();

        EditText cityName=(EditText)findViewById(R.id.cityName);
        Button weatherButton=(Button)findViewById(R.id.showButton);
        try {

            String weatherApiDetails=weatherInfo.execute("https://samples.openweathermap.org/data/2.5/weather?q="+cityName.getText().toString()+"&appid=b1b15e88fa797225412429c1c50c122a1").get();
            Log.i("weather",weatherApiDetails);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
