package com.carmel.guestjini.Support;


import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import Model.MyTicketsModel;


public class MyTicketsRecyclerViewFragment extends Fragment {

    RecyclerView ticketsRecyclerView;
    DrawerLayout drawerLayout;
    MaterialButton ticketsFilterIcon;
    ArrayList<MyTicketsModel> myTicketsModelsList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_my_tickets_recycler_view, container, false);
        ticketsRecyclerView=rootView.findViewById(R.id.myTicketsRecyclerView);
        drawerLayout=rootView.findViewById(R.id.drawerLayout);
        ticketsFilterIcon=rootView.findViewById(R.id.filterIcon);

        ticketsFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        ticketsRecyclerView.setLayoutManager(linearLayoutManager);
        MyTicktesAdapter myTicktesAdapter=new MyTicktesAdapter(rootView.getContext(),myTicketsModelsList);
        ticketsRecyclerView.setAdapter(myTicktesAdapter);


        MyTicketsModel myTicketsModel=new MyTicketsModel();
        myTicketsModel.setTicketsStatus("OPEN");
        myTicketsModel.setTicketsDateAndTime("09:15 AM");
        myTicketsModel.setTicketsName("Elevator is not working most of the time.");
        myTicketsModel.setTicketsNo("Ticket #");
        myTicketsModel.setTicketsValue("TT/AV/004/2016");
        myTicketsModel.setClock("Clock");
        myTicketsModel.setTicketsTime("05:48");
        myTicketsModelsList.add(myTicketsModel);

        myTicketsModel=new MyTicketsModel();
        myTicketsModel.setTicketsStatus("CLOSED");
        myTicketsModel.setTicketsDateAndTime("25 July 2019 11:47 AM");
        myTicketsModel.setTicketsName("Lorem ipsum dolor sit amet, consectetur.");
        myTicketsModel.setTicketsNo("Ticket #");
        myTicketsModel.setTicketsValue("TT/AV/003/2016");
        myTicketsModel.setClock("Clock");
        myTicketsModel.setTicketsTime("2 Days 05:48");
        myTicketsModelsList.add(myTicketsModel);

        myTicketsModel=new MyTicketsModel();
        myTicketsModel.setTicketsStatus("OPEN");
        myTicketsModel.setTicketsDateAndTime("24 July 2019 11:47 AM");
        myTicketsModel.setTicketsName("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        myTicketsModel.setTicketsNo("Ticket #");
        myTicketsModel.setTicketsValue("TT/AV/002/2016");
        myTicketsModel.setClock("Clock");
        myTicketsModel.setTicketsTime("3 Days 05:48");
        myTicketsModelsList.add(myTicketsModel);

        return rootView;

    }

}
