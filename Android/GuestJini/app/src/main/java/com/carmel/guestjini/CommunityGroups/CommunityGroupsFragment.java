package com.carmel.guestjini.CommunityGroups;


import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.carmel.guestjini.CommunityActivity;
import com.carmel.guestjini.GroupsActivity;
import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.CommunityGroupsAdapter;
import Model.CommunityGroupsModel;

public class CommunityGroupsFragment extends Fragment implements CommunityGroupsAdapter.OnItemClickListener {
    private ArrayList<CommunityGroupsModel> communityGroupsList=new ArrayList<>();
    private RecyclerView communityGroupsRecyclerView;
    private ImageView communityGroupFilterIcon,backArrow;
    private ConstraintLayout searchLayout,noResultFoundLayout,recyclerViewLayout;
    private TextView searchResultCount;
    private EditText search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_community_groups, container, false);
        communityGroupsRecyclerView=rootView.findViewById(R.id.RecyclerViewCommunityGroups);
        backArrow=rootView.findViewById(R.id.backArrow);
        searchLayout=rootView.findViewById(R.id.searchLayout);
        noResultFoundLayout=rootView.findViewById(R.id.noResultFoundLayout);
        recyclerViewLayout=rootView.findViewById(R.id.recyclerViewLayout);
        searchResultCount=rootView.findViewById(R.id.searchResultCount);
        search=rootView.findViewById(R.id.search);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        communityGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        communityGroupsRecyclerView.setHasFixedSize(true);
        CommunityGroupsAdapter communityGroupsAdapter=new CommunityGroupsAdapter(getContext(),communityGroupsList,this);
        communityGroupsAdapter.setHasStableIds(true);
        communityGroupsRecyclerView.setAdapter(communityGroupsAdapter);

        communityGroupsList.add(new CommunityGroupsModel("MOVIE NIGHT - LION KING",
                "Daisy Lake",
                "Today 11:38 AM (2 Hours ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies." +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                "You have been invited to join this group.",
                 R.drawable.profile_image,
                 R.drawable.information_icon,
                 CommunityGroupsModel.InvitedUnreadUserCell));

        communityGroupsList.add(new CommunityGroupsModel("HAMPI TRIP",
                "Nora Bravos",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                "Your request has been accepted.",
                R.drawable.profile_image,
                R.drawable.done_button_xhdpi,
                CommunityGroupsModel.RequestAcceptedCell));

        communityGroupsList.add(new CommunityGroupsModel("HOLI CELEBRATIONS",
                "Eddie Murphy",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                null,
                R.drawable.profile_image,
                0,
                CommunityGroupsModel.JoinedGroupsCell));

        communityGroupsList.add(new CommunityGroupsModel("STAND-UP COMEDY",
                "YOU",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                null,
                R.drawable.profile_image,
                0,
                CommunityGroupsModel.RemovedCell));

        communityGroupsList.add(new CommunityGroupsModel("POT LUCK",
                "Nora Bravos",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                "You have requested to join this group.",
                R.drawable.profile_image,
                R.drawable.exclamation_icon_xhdpi,
                CommunityGroupsModel.RequestedCell));

        communityGroupsList.add(new CommunityGroupsModel("GEEKS",
                "Markus Lawless",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                "Send a request to join this group.",
                R.drawable.profile_image,
                R.drawable.information_icon,
                CommunityGroupsModel.UnsubscribedCell));

        communityGroupsList.add(new CommunityGroupsModel("MOVIE NIGHT - LION KING",
                "Daisy Lake",
                "Today 11:38 AM (2 Hours ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                "You have been invited to join this group.",
                R.drawable.profile_image,
                R.drawable.information_icon,
                CommunityGroupsModel.InvitedReadCell));

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), GroupsActivity.class);
                startActivity(intent);
            }
        });

        searchLayout.setOnClickListener(new View.OnClickListener() {
            private boolean flag=true;
            @Override
            public void onClick(View v) {
                if(flag) {
                    flag=false;
                    noResultFoundLayout.setVisibility(View.VISIBLE);
                    recyclerViewLayout.setVisibility(View.GONE);
                    search.setText("Boxing");
                }else {
                    flag=true;
                    searchResultCount.setVisibility(View.VISIBLE);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onClikInvitedUnreadGroup(int position) {
        communityGroupsList.get(position);
        InvitedGroupViewFragment invitedGroupViewFragment=new InvitedGroupViewFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.communityGroupsPlaceHolder,invitedGroupViewFragment);
        fragmentTransaction.addToBackStack(null);
        Bundle bundle=new Bundle();
        bundle.putString("GroupName",communityGroupsList.get(position).getCommunityGroupTitle());
        bundle.putString("GroupDescription",communityGroupsList.get(position).getCommunityGroupDescription());
        bundle.putString("GroupAdminName",communityGroupsList.get(position).getCommunityGroupAdmin());
        bundle.putString("GroupCreationDateAndTime",communityGroupsList.get(position).getCommunityGroupCreationDateAndTime());
        fragmentTransaction.commit();
        invitedGroupViewFragment.setArguments(bundle);

    }

    @Override
    public void onClikRequestAcceptedGroup(int position) {
        communityGroupsList.get(position);
        CommunityGroupChatFragment communityGroupChatFragment=new CommunityGroupChatFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.communityGroupsPlaceHolder,communityGroupChatFragment);
        fragmentTransaction.addToBackStack(null);
        Bundle bundle=new Bundle();
        bundle.putString("GroupName",communityGroupsList.get(position).getCommunityGroupTitle());
        bundle.putString("GroupDescription",communityGroupsList.get(position).getCommunityGroupDescription());
        bundle.putString("GroupAdminName",communityGroupsList.get(position).getCommunityGroupAdmin());
        bundle.putString("GroupCreationDateAndTime",communityGroupsList.get(position).getCommunityGroupCreationDateAndTime());
        communityGroupChatFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    public void onClikRemovedGroup(int position) {

    }

    @Override
    public void onClikRequestedGroup(int position) {

    }

    @Override
    public void onClikUnsubscribedGroup(int position) {

    }
}
