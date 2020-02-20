package com.carmel.guestjini.Support;


import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adapter.TicketAdapter;
import Model.MyTicketsModel;


public class MyTicketsRecyclerViewFragment extends Fragment implements TicketAdapter.OnItemClickListener {

    RecyclerView ticketsRecyclerView;
    DrawerLayout drawerLayout;
    MaterialButton ticketsFilterIcon;
    FloatingActionButton addIcon;
    ImageView backArrow;
    Spinner spinner;
    ArrayList<MyTicketsModel> myTicketsModelsList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_my_tickets_recycler_view, container, false);
        ticketsRecyclerView=rootView.findViewById(R.id.myTicketsRecyclerView);
        drawerLayout=rootView.findViewById(R.id.drawerLayout);
        ticketsFilterIcon=rootView.findViewById(R.id.filterIcon);
        addIcon=rootView.findViewById(R.id.addIcon);
        backArrow=rootView.findViewById(R.id.leftArrowMark);


        spinner=rootView.findViewById(R.id.selectDateSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupportLandingFragment supportLandingFragment=new SupportLandingFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,supportLandingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               NewTicketFragment newTicketFragment=new NewTicketFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,newTicketFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        ticketsFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        ticketsRecyclerView.setLayoutManager(linearLayoutManager);
        ticketsRecyclerView.setHasFixedSize(true);
        TicketAdapter ticketAdapter=new TicketAdapter(myTicketsModelsList,this);
        ticketAdapter.setHasStableIds(true);
        ticketsRecyclerView.setAdapter(ticketAdapter);

        myTicketsModelsList.add(new MyTicketsModel(
                "OPEN",
                "09:15 AM",
                "Elevator is not working most of the time.",
                "Ticket #",
                "TT/AV/004/2016",
                "Clock",
                "05:48",
                "delete",
                MyTicketsModel.ONE_TYPE

                ));

        myTicketsModelsList.add(new MyTicketsModel(
                "DRAFT",
                "25 July 2019 11:47 AM",
                "Lorem ipsum dolor sit amet, consectetur.",
                "Ticket #",
                "TT/AV/004/2016",
                "Clock",
                "05:48",
                "delete",
                MyTicketsModel.TWO_TYPE

        ));
        myTicketsModelsList.add(new MyTicketsModel(
                "CLOSED",
                "25 July 2019 11:47 AM",
                "Lorem ipsum dolor sit amet, consectetur.",
                "Ticket #",
                "TT/AV/003/2016",
                "Clock",
                "2 Days 05:48",
                "delete",
                MyTicketsModel.ONE_TYPE

        ));
        myTicketsModelsList.add(new MyTicketsModel(
                "OPEN",
                "24 July 2019 11:47 AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Ticket #",
                "TT/AV/002/2016",
                "Clock",
                "3 Days 05:48",
                "delete",
                MyTicketsModel.ONE_TYPE

        ));

        return rootView;

    }

    @Override
    public void onItemClick(int position) {
        myTicketsModelsList.get(position);
        MyTicketDetailsFragment myTicketDetailsFragment=new MyTicketDetailsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.SuppotPlaceHolder, myTicketDetailsFragment);
        fragmentTransaction.commit();

        Bundle bundle = new Bundle();
        bundle.putString("ticket_name", myTicketsModelsList.get(position).getTicketsName());
        bundle.putString("ticket_status",myTicketsModelsList.get(position).getTicketsStatus());
        bundle.putString("ticket_dateAndTime",myTicketsModelsList.get(position).getTicketsDateAndTime());
        bundle.putString("ticket_value",myTicketsModelsList.get(position).getTicketsValue());
        myTicketDetailsFragment.setArguments(bundle);

    }
}
