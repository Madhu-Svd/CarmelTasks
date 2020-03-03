package com.carmel.guestjini.Groups;


import android.media.Image;
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

import com.carmel.guestjini.Community.CommunityLandingFragment;
import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.CommunityLandingAdapter;
import Model.CommunityLandingModel;

public class GroupsLandingFragment extends Fragment implements CommunityLandingAdapter.OnItemClickListener {
    private RecyclerView groupsRecyclerView;
    private ArrayList<CommunityLandingModel> groupsLandingModelArrayList=new ArrayList<>();
    private ImageView leftArrowMark;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_groups_landing, container, false);
        groupsRecyclerView=view.findViewById(R.id.groupsRecyclerView);
        leftArrowMark=view.findViewById(R.id.leftArrowMark);

        leftArrowMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityLandingFragment communityLandingFragment=new CommunityLandingFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.CommunityPlaceHolder, communityLandingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        groupsRecyclerView.setLayoutManager(linearLayoutManager);
        groupsRecyclerView.setHasFixedSize(true);
        CommunityLandingAdapter communityLandingAdapter=new CommunityLandingAdapter(groupsLandingModelArrayList,this);
        groupsRecyclerView.setAdapter(communityLandingAdapter);
        groupsLandingModelArrayList.add(new CommunityLandingModel(null,"INTEREST GROUPS","There is a group for every activity, hobby or topic. Connect with like minded people."));
        groupsLandingModelArrayList.add(new CommunityLandingModel(null,"COMMUNITY GROUPS","Explore groups created by the community members. Participate and catch all the action."));
        groupsLandingModelArrayList.add(new CommunityLandingModel(null,"MY GROUPS","Create and manage your own groups. Host parties, events or simply bond together."));
        return view;
    }

    @Override
    public void onProfileClick(int position) {

    }

    @Override
    public void onPeopleClick(int position) {

    }

    @Override
    public void onGroupsClick(int position) {

    }
}
