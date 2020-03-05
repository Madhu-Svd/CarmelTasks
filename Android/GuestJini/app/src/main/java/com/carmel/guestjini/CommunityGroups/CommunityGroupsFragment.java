package com.carmel.guestjini.CommunityGroups;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.CommunityGroupsAdapter;
import Model.CommunityGroupsListModel;

public class CommunityGroupsFragment extends Fragment {
    private ArrayList<CommunityGroupsListModel> communityGroupsList=new ArrayList<>();
    private RecyclerView communityGroupsRecyclerView;
    private ImageView communityGroupFilterIcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_community_groups, container, false);
        communityGroupsRecyclerView=rootView.findViewById(R.id.communityGroupsRecyclerView);
        communityGroupFilterIcon=rootView.findViewById(R.id.filterIcon);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        communityGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        CommunityGroupsAdapter communityGroupsAdapter=new CommunityGroupsAdapter(getContext(),communityGroupsList);
        communityGroupsRecyclerView.setAdapter(communityGroupsAdapter);

        CommunityGroupsListModel communityGroupsListModel=new CommunityGroupsListModel();
        communityGroupsListModel.setAddCommunityGroupTitle("MOVIE NIGHT - LION KING");
        communityGroupsListModel.setAddCommunityGroupAdminName("Daisy Lake");
        communityGroupsListModel.setAddCommunityGroupCreationDateAndTime("Today 11:38 AM (2 Hours ago)");
        communityGroupsListModel.setAddCommunityGroupDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.");
        communityGroupsListModel.setAddCommunityGroupInformationMessage("You have been invited to join this group.");
        communityGroupsList.add(communityGroupsListModel);

      communityGroupsListModel=new CommunityGroupsListModel();
        communityGroupsListModel.setAddCommunityGroupTitle("MOVIE NIGHT - LION KING");
        communityGroupsListModel.setAddCommunityGroupAdminName("Daisy Lake");
        communityGroupsListModel.setAddCommunityGroupCreationDateAndTime("Today 11:38 AM (2 Hours ago)");
        communityGroupsListModel.setAddCommunityGroupDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.");
        communityGroupsListModel.setAddCommunityGroupInformationMessage("You have been invited to join this group.");
        communityGroupsList.add(communityGroupsListModel);


 communityGroupsListModel=new CommunityGroupsListModel();
        communityGroupsListModel.setAddCommunityGroupTitle("MOVIE NIGHT - LION KING");
        communityGroupsListModel.setAddCommunityGroupAdminName("Daisy Lake");
        communityGroupsListModel.setAddCommunityGroupCreationDateAndTime("Today 11:38 AM (2 Hours ago)");
        communityGroupsListModel.setAddCommunityGroupDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.");
        communityGroupsListModel.setAddCommunityGroupInformationMessage("You have been invited to join this group.");
        communityGroupsList.add(communityGroupsListModel);


        return rootView;
    }

}
