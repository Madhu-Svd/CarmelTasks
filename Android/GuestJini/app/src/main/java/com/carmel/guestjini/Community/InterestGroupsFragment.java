package com.carmel.guestjini.Community;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carmel.guestjini.R;

import java.util.ArrayList;


import Adapter.InterestGroupsAdpater;
import Model.InterestGroupsModel;

public class InterestGroupsFragment extends Fragment {

   private RecyclerView interestGroupsRecyclerView;
    ArrayList<InterestGroupsModel> interestGroupsList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_interest_groups, container, false);
        interestGroupsRecyclerView=view.findViewById(R.id.interestGroupsRecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        interestGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        interestGroupsRecyclerView.setHasFixedSize(true);
        InterestGroupsAdpater interestGroupsAdpater=new InterestGroupsAdpater(interestGroupsList);
        interestGroupsRecyclerView.setAdapter(interestGroupsAdpater);


//        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
//                "CYCLING",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
//                null,0,0));
        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "HIKING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.ONE_TYPE));
        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "HIKING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.TWO_TYPE));

        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "HIKING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.THIRD_TYPE));
        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "HIKING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.FOURTH_TYPE));
        return view;
    }

}
