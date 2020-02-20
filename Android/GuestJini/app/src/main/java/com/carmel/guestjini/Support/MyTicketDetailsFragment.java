package com.carmel.guestjini.Support;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carmel.guestjini.R;

public class MyTicketDetailsFragment extends Fragment {

    private ImageView backArrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView ticketName,ticketStatus,ticketDateAndTime,ticketValue;
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_my_ticket_details, container, false);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        String ticket_name, ticket_status ,ticket_dateAndTime,ticket_value;
        ticketName=rootView.findViewById(R.id.ticketsStatus);
        ticketStatus=rootView.findViewById(R.id.ticketsName);
        ticketDateAndTime=rootView.findViewById(R.id.tickestsDateAndTime);
        ticketValue=rootView.findViewById(R.id.ticketsValue);

        final Bundle bundle = this.getArguments();
        if (bundle != null) {
            ticket_status  = bundle.getString("ticket_status");
            ticket_name  = bundle.getString("ticket_name");
            ticket_dateAndTime  = bundle.getString("ticket_dateAndTime");
            ticket_value  = bundle.getString("ticket_value");

            ticketName.setText(ticket_status);
            ticketStatus.setText(ticket_name);
            ticketDateAndTime.setText(ticket_dateAndTime);
            ticketValue.setText(ticket_value);
        }

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTicketsRecyclerViewFragment myTicketsRecyclerViewFragmentt=new MyTicketsRecyclerViewFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,myTicketsRecyclerViewFragmentt);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
