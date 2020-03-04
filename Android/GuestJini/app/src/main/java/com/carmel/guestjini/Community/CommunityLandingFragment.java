package com.carmel.guestjini.Community;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carmel.guestjini.Groups.GroupsLandingFragment;
import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.CommunityLandingAdapter;
import Model.CommunityLandingModel;


public class CommunityLandingFragment extends Fragment implements CommunityLandingAdapter.OnItemClickListener {
    private RecyclerView communityRecyclerView;
    private ArrayList<CommunityLandingModel> communityLandingModelArrayList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_community_landing, container, false);
        communityRecyclerView=rootView.findViewById(R.id.communityRecyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        communityRecyclerView.setLayoutManager(linearLayoutManager);
        communityRecyclerView.setHasFixedSize(true);
        CommunityLandingAdapter communityLandingAdapter=new CommunityLandingAdapter(communityLandingModelArrayList,this);
        communityRecyclerView.setAdapter(communityLandingAdapter);
        communityLandingModelArrayList.add(new CommunityLandingModel(null,"MY PROFILE","Based on your profile, you will be able to connect with the best matches who share your interests. Go ahead and setup your profile."));
        communityLandingModelArrayList.add(new CommunityLandingModel(null,"PEOPLE","Meet the community members and make new friends."));
        communityLandingModelArrayList.add(new CommunityLandingModel(null,"GROUPS","Join the groups and catch all the action. You will get suggestions based on your profile."));

        return rootView;
    }

    @Override
    public void onProfileClick(int position) {
        GroupsLandingFragment groupsLandingFragment=new GroupsLandingFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.CommunityPlaceHolder, groupsLandingFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onPeopleClick(int position) {
//        Intent intent=new Intent(getContext().getApplicationContext(), Login.class);
//        startActivity(intent);
    }

    @Override
    public void onGroupsClick(int position) {
//        Intent intent=new Intent(getContext().getApplicationContext(), SupportActivity.class);
//        startActivity(intent);
    }
}
