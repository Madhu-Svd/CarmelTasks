package com.carmel.guestjini.Support;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Model.MyTicketsModel;


public class MyTicketsRecyclerViewFragment extends Fragment {

    RecyclerView ticketsRecyclerView;
    ArrayList<MyTicketsModel> myTicketsModelsList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_my_tickets_recycler_view, container, false);
        ticketsRecyclerView=rootView.findViewById(R.id.myTicketsRecyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        ticketsRecyclerView.setLayoutManager(linearLayoutManager);
        MyTicktesAdapter myTicktesAdapter=new MyTicktesAdapter(rootView.getContext(),myTicketsModelsList);
        ticketsRecyclerView.setAdapter(myTicktesAdapter);


        MyTicketsModel myTicketsModel=new MyTicketsModel();
        myTicketsModel.setTicketsStatus("OPEN");
        myTicketsModel.setTicketsName("Elevator is not working most of the time.");
        myTicketsModel.setTicketsNo("Ticket #");
        myTicketsModel.setClock("Clock");
        myTicketsModelsList.add(myTicketsModel);

        return rootView;

    }

}
