package com.carmel.guestjini.CommunityGroups;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.CommunityGroupsAdapter;
import Model.CommunityGroupsModel;


public class CommunityGroups1Fragment extends Fragment {
    private ArrayList<CommunityGroupsModel> communityGroupsList=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_community_groups1, container, false);
        recyclerView=rootview.findViewById(R.id.hi);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        CommunityGroupsAdapter communityGroupsAdapter=new CommunityGroupsAdapter(getContext(),communityGroupsList);
        communityGroupsAdapter.setHasStableIds(true);
        recyclerView.setAdapter(communityGroupsAdapter);

        communityGroupsList.add(new CommunityGroupsModel("ho","jdhd","dhghdgd","dhjhdjd",
                "dhdg",R.drawable.profile_image,R.drawable.information_icon,CommunityGroupsModel.InvitedUnreadUserCell));

        communityGroupsList.add(new CommunityGroupsModel("ho","jdhd","dhghdgd","dhjhdjd",
                "dhdg",R.drawable.profile_image,R.drawable.information_icon,CommunityGroupsModel.InvitedUnreadUserCell));
        return rootview;
    }

}
