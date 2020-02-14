package com.carmel.multiviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;

import Adapter.ContactAdapter;
import Model.Contact_list;

public class MainActivity extends AppCompatActivity {
    private ContactAdapter listAdapter;
    private ArrayList<Contact_list> contactsList = new ArrayList<>();
    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        listAdapter=new ContactAdapter(contactsList);
        recycler.setAdapter(listAdapter);



            contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.ONE_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));
        contactsList.add(new Contact_list("hi",Contact_list.TWO_TYPE));

    }
}
