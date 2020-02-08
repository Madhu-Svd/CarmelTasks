package com.carmel.moviesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapter.MovieAdapter;
import Model.ListMovies;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<ListMovies> listMovies;
    private static final String URL_DATA="https://api.themoviedb.org/3/movie/popular?api_key=65b0f0c1dca6b0957d34d1fceaf3107a&language=en-US&page=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.moviesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listMovies=new ArrayList<>();
        parseJson();
    }
    private void parseJson(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                 JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("results");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        ListMovies movies=new ListMovies(object.getString("poster_path"),object.getInt("popularity"),
                                object.getString("original_title"),object.getString("original_language"),object.getString("overview"));
                        listMovies.add(movies);
                    }
                    adapter=new MovieAdapter(getApplicationContext(),listMovies);
                    recyclerView.setAdapter(adapter);

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
            requestQueue.add(stringRequest);
    }
}
