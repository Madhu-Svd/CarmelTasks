package com.carmel.guestjini.Support;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import Adapter.ExploreTicketsAdapter;
import Model.TicketsModel;


public class ExploreFragment extends Fragment implements ExploreTicketsAdapter.OnItemClickListener{
    RecyclerView recyclerView;
    private ArrayList<TicketsModel> ticketsModelsList=new ArrayList<>();
    ImageView backArrow;
    MaterialButton exploreFilterIcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView=rootView.findViewById(R.id.recyclerView);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        exploreFilterIcon=rootView.findViewById(R.id.exploreFilterIcon);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ExploreTicketsAdapter exploreTicketsAdapter=new ExploreTicketsAdapter(rootView.getContext(),ticketsModelsList,this);
        recyclerView.setAdapter(exploreTicketsAdapter);
        recyclerView.setHasFixedSize(true);

        TicketsModel ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("Elevator is not working?");
        ticketsModel.setTicketsAuthorName("Author - John Doe");
        ticketsModel.setTicketsDate("10 Jan 2019");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModel.setNavigationIcon(R.drawable.ic_navigate_next_black_24dp);
        ticketsModelsList.add(ticketsModel);


        ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("Coffee machine is not working?");
        ticketsModel.setTicketsAuthorName("Author - Jaret Quartz");
        ticketsModel.setTicketsDate("03 Jan 2019");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModel.setNavigationIcon(R.drawable.ic_navigate_next_black_24dp);
        ticketsModelsList.add(ticketsModel);


        ticketsModel=new TicketsModel();
        ticketsModel.setTicketsName("What is the speed of Wifi?");
        ticketsModel.setTicketsAuthorName("Author - John Doe");
        ticketsModel.setTicketsDate("29 Dec 2018");
        ticketsModel.setTicketsDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales.");
        ticketsModel.setNavigationIcon(R.drawable.ic_navigate_next_black_24dp);
        ticketsModelsList.add(ticketsModel);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SupportLandingFragment supportLandingFragment=new SupportLandingFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,supportLandingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        exploreFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.explore_filter_list);
                WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = 50;   //x position
                wmlp.y = 320;   //y position

                dialog.show();
            }
        });

        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        ticketsModelsList.get(position);
        ArticlesDetailsFragment articlesDetailsFragment=new ArticlesDetailsFragment();
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.SuppotPlaceHolder,articlesDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Bundle bundle = new Bundle();
        bundle.putString("ticket_name", ticketsModelsList.get(position).getTicketsName());
        bundle.putString("ticket_author_name",ticketsModelsList.get(position).getTicketsAuthorName());
        bundle.putString("ticket_date",ticketsModelsList.get(position).getTicketsDate());
        articlesDetailsFragment.setArguments(bundle);
    }
}

