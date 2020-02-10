package com.carmel.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
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
import java.util.List;

import Adapter.MoviesAdapter;
import Model.MoviesList;

public class MainActivity extends AppCompatActivity {
    private static final String URL_DATA="https://api.myjson.com/bins/ttdxu";

    private RecyclerView moviesRecyclerView;
    private RecyclerView.Adapter adapter;
    private List<MoviesList> moviesLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesRecyclerView=(RecyclerView)findViewById(R.id.moviesRecyclerViewID);
        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        moviesLists=new ArrayList<>();
        loadRecyclerViewMoviesData();


    }
    private void loadRecyclerViewMoviesData(){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        JSONArray jsonArray=jsonObject.getJSONArray("movies");

                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            MoviesList moviesList=new MoviesList(
                                    object.getString("movie_name"),
                                    object.getString("theater_name"),
                                    object.getString("address")
                            );
                            moviesLists.add(moviesList);
                        }
                        adapter=new MoviesAdapter(getApplicationContext(),moviesLists);
                        moviesRecyclerView.setAdapter(adapter);
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
