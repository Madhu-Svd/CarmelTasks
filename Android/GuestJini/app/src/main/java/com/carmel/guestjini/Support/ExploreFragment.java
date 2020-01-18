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

import Model.TicketsModel;


public class ExploreFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<TicketsModel> ticketsModelsList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView=rootView.findViewById(R.id.recyclerView);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ExploreTicketsAdapter exploreTicketsAdapter=new ExploreTicketsAdapter(rootView.getContext(),ticketsModelsList);
        recyclerView.setAdapter(exploreTicketsAdapter);

        TicketsModel ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("Elevator is not working?");
        ticketsModel.setTicketsAuthorName("Author - John Doe");
        ticketsModel.setTicketsDate("10 Jan 2019");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModelsList.add(ticketsModel);


        ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("Coffee machine is not working?");
        ticketsModel.setTicketsAuthorName("Author - Jaret Quartz");
        ticketsModel.setTicketsDate("03 Jan 2019");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModelsList.add(ticketsModel);


        ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("What is the speed of Wifi?");
        ticketsModel.setTicketsAuthorName("Author - John Doe");
        ticketsModel.setTicketsDate("29 Dec 2018");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModelsList.add(ticketsModel);

        return rootView;
    }

}

