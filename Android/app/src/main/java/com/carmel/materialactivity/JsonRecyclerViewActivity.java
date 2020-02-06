package com.carmel.materialactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Adapter.ContactAdapter;
import Model.JsonModel;

public class JsonRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<JsonModel> jsonModels ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        jsonModels= new ArrayList<>();


          JsonModel jsonModel=new JsonModel();
          jsonModel.setName("djjdhd");
          jsonModel.setPrice("dhjdhjd");
          jsonModels.add(jsonModel);

        jsonModel=new JsonModel();
        jsonModel.setName("djjdhd");
        jsonModel.setPrice("dhjdhjd");
        jsonModels.add(jsonModel);

        jsonModel=new JsonModel();
        jsonModel.setName("djjdhd");
        jsonModel.setPrice("dhjdhjd");
        jsonModels.add(jsonModel);

        jsonModel=new JsonModel();
        jsonModel.setName("djjdhd");
        jsonModel.setPrice("dhjdhjd");
        jsonModels.add(jsonModel);

        jsonModel=new JsonModel();
        jsonModel.setName("djjdhd");
        jsonModel.setPrice("dhjdhjd");
        jsonModels.add(jsonModel);

        adapter = new ContactAdapter(getApplicationContext(), jsonModels);
        recyclerView.setAdapter(adapter);

    }

    }


