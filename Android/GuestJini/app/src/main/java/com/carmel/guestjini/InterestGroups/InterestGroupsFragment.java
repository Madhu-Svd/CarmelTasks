package com.carmel.guestjini.InterestGroups;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carmel.guestjini.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


import Adapter.InterestGroupsAdpater;
import Model.InterestGroupsModel;

public class InterestGroupsFragment extends Fragment implements InterestGroupsAdpater.OnItemClickListener {

   private RecyclerView interestGroupsRecyclerView;
    ArrayList<InterestGroupsModel> interestGroupsList=new ArrayList<>();
    private ImageView filterIcon;
    MaterialCardView filterPopup;
    private TextView filterTitle,subscribedTitle,ClearTitle,newTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_interest_groups, container, false);
        interestGroupsRecyclerView=view.findViewById(R.id.interestGroupsRecyclerView);
        filterIcon=view.findViewById(R.id.filterIcon);
        filterPopup=view.findViewById(R.id.filterPopup);
        filterTitle=view.findViewById(R.id.filterTitle);
        subscribedTitle=view.findViewById(R.id.subscribedTitle);
        newTitle=view.findViewById(R.id.newTitle);
        ClearTitle=view.findViewById(R.id.ClearTitle);
        filterIcon.setOnClickListener(new View.OnClickListener() {
            private boolean flag=true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    filterPopup.setVisibility(View.VISIBLE);
                }else {
                    flag=true;
                    filterPopup.setVisibility(View.GONE);
                }
            }
        });
        subscribedTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterPopup.setVisibility(View.GONE);
                filterTitle.setVisibility(View.VISIBLE);
                filterTitle.setText("Showing subscribed groups.");
                ClearTitle.setTextColor(ColorStateList.valueOf(Color
                        .parseColor("#32BDD2")));
                subscribedTitle.setTextColor(ColorStateList.valueOf(Color
                        .parseColor("#B5B5B5")));
//                newTitle.setTextColor(ColorStateList.valueOf(Color.parseColor()l));
            }
        });
        ClearTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterPopup.setVisibility(View.GONE);
                filterTitle.setVisibility(View.GONE);
                ClearTitle.setTextColor(ColorStateList.valueOf(Color
                        .parseColor("#B5B5B5")));
                filterTitle.setTextColor(ColorStateList.valueOf(Color
                        .parseColor("#747474")));

            }
        });
        newTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterPopup.setVisibility(View.GONE);
                filterTitle.setVisibility(View.VISIBLE);
                filterTitle.setText("Showing new groups.");
                ClearTitle.setTextColor(ColorStateList.valueOf(Color
                        .parseColor("#32BDD2")));
//                subscribedTitle.setTextColor(ColorStateList.valueOf(Color
//                        .parseColor("#B5B5B5")));

            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        interestGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        interestGroupsRecyclerView.setHasFixedSize(true);
        InterestGroupsAdpater interestGroupsAdpater=new InterestGroupsAdpater(interestGroupsList,this);
        interestGroupsRecyclerView.setAdapter(interestGroupsAdpater);

        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "CYCLING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.ONE_TYPE));

        interestGroupsList.add(new InterestGroupsModel("Tech",
                "ROBOTICS",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.TWO_TYPE));

        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "HIKING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.THIRD_TYPE));

        interestGroupsList.add(new InterestGroupsModel("OutDoor Adventure",
                "SKY DIVING",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien. ultricies.",
                "This group matches your interest.",R.drawable.indicator_icon,R.drawable.information_icon,InterestGroupsModel.FOURTH_TYPE));
        return view;
    }

    @Override
    public void onclickUnsubscribeGroup(int position) {
        SubscribedGroupChatFragment subscribedGroupChatFragment=new SubscribedGroupChatFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.interestGroupsPlaceHolder, subscribedGroupChatFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Bundle bundle=new Bundle();
        bundle.putString("Interest Group Type",interestGroupsList.get(position).getAddInterestCategoryTitle());
        bundle.putString("Interest Group Name",interestGroupsList.get(position).getAddInterestGroupTitle());
        bundle.putString("interestGroupDescription",interestGroupsList.get(position).getAddInterestGroupDescription());
        subscribedGroupChatFragment.setArguments(bundle);
    }

    @Override
    public void onclickSubscribeGroup(int position) {
        SubscribedGroupChatFragment subscribedGroupChatFragment=new SubscribedGroupChatFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.interestGroupsPlaceHolder, subscribedGroupChatFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Bundle bundle=new Bundle();
        bundle.putString("Interest Group Type",interestGroupsList.get(position).getAddInterestCategoryTitle());
        bundle.putString("Interest Group Name",interestGroupsList.get(position).getAddInterestGroupTitle());
        bundle.putString("interestGroupDescription",interestGroupsList.get(position).getAddInterestGroupDescription());
        subscribedGroupChatFragment.setArguments(bundle);

    }
}
