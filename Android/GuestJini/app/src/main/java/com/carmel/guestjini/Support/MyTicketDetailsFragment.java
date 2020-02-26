package com.carmel.guestjini.Support;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carmel.guestjini.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyTicketDetailsFragment extends Fragment {

    private ImageView backArrow;
    private LinearLayout foreground;
    private String ticket_status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView ticketName,ticketStatus,ticketDateAndTime,ticketValue;
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_my_ticket_details, container, false);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        String ticket_name,ticket_dateAndTime,ticket_value;
        ticketStatus=rootView.findViewById(R.id.ticketsStatus);
        ticketName =rootView.findViewById(R.id.ticketsName);
        ticketDateAndTime=rootView.findViewById(R.id.tickestsDateAndTime);
        ticketValue=rootView.findViewById(R.id.ticketsValue);
        foreground=rootView.findViewById(R.id.foreground);
        RelativeLayout attchFile=rootView.findViewById(R.id.materialCardViewLayout);
        ConstraintLayout closed=rootView.findViewById(R.id.closedLayout);

        FloatingActionButton attachFilesIcon=(FloatingActionButton)rootView.findViewById(R.id.attachFilesIcon);
        final ConstraintLayout attachFiles=rootView.findViewById(R.id.attachfilesLayout);

        attachFilesIcon.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag) {
                    flag=false;
                    attachFiles.setVisibility(View.VISIBLE);
                }else {
                    flag=true;
                    attachFiles.setVisibility(View.GONE);
                }
            }
        });

        foreground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foreground.setVisibility(View.GONE);
            }
        });
        final Bundle bundle = this.getArguments();
        if (bundle != null) {
            ticket_status  = bundle.getString("ticket_status");
            ticket_name  = bundle.getString("ticket_name");
            ticket_dateAndTime  = bundle.getString("ticket_dateAndTime");
            ticket_value  = bundle.getString("ticket_value");

            ticketName.setText(ticket_name);
            ticketStatus.setText(ticket_status);
            ticketDateAndTime.setText(ticket_dateAndTime);
            ticketValue.setText(ticket_value);
        }
        if(ticket_status.equals("OPEN")){
            attchFile.setVisibility(View.VISIBLE);
            closed.setVisibility(View.GONE);
        }
        else {
            closed.setVisibility(View.VISIBLE);
            attchFile.setVisibility(View.GONE);
            foreground.setVisibility(View.GONE);
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
