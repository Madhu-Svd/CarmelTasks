package com.carmel.materialactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import Model.ContactsModel;

public class JsonRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<ContactsModel> contactsModelsObject = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("contacts");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String val1 = jo_inside.getString("mobile");
                String val2 = jo_inside.getString("mail");
                String val3 = jo_inside.getString("name");
                String val4 = jo_inside.getString("company");
                String val5 = jo_inside.getString("department");
                String val6 = jo_inside.optString("title");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("mobile", val1);
                m_li.put("mail", val2);
                m_li.put("name", val3);
                m_li.put("company", val4);
                m_li.put("department", val5);
                m_li.put("title", val6);

                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerViewstart();
        loadJSONFromAsset();
        adapter = new MyColleaguesAdapter(contactsModelsObject, this);
        recyclerView.setAdapter(adapter);
    }
}
}
