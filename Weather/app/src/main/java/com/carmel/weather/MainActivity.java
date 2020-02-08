package com.carmel.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
//    private static final String URL_DATA="http://api.openweathermap.org/data/2.5/weather?q=islamabad,pakistan&appid=90ebdc57172a838d0fce0abbc044df8e";

    private TextView t1_temp,t1_city,t1_description,t1_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1_temp=findViewById(R.id.degree);
        t1_city=findViewById(R.id.myCity);
        t1_description=findViewById(R.id.sunny);
        t1_date=findViewById(R.id.date);

        find_weather();

    }
    private void find_weather(){
        String url="http://api.openweathermap.org/data/2.5/weather?q=islamabad,pakistan&appid=90ebdc57172a838d0fce0abbc044df8e";
        final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject=response.getJSONObject("main");
                    JSONArray jsonArray=response.getJSONArray("weather");
                    JSONObject object=jsonArray.getJSONObject(0);
                    String temp=String.valueOf(jsonObject.getDouble("temp"));
                    String description=object.getString("description");
                    String city=response.getString("name");

                    t1_temp.setText(temp);
                    t1_description.setText(description);
                    t1_city.setText(city);

                    Calendar calendar=Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE-MM-DD");
                    String formatted_date=simpleDateFormat.format(calendar.getTime());

                    t1_date.setText(formatted_date);

                    double temp_int=Double.parseDouble(temp);
                    double centi=(temp_int-32)/1.8000;
                    centi=Math.round(centi);

                    int i=(int)centi;
                    t1_temp.setText(String.valueOf(i));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}
