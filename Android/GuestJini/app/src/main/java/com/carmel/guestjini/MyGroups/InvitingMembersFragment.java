package com.carmel.guestjini.MyGroups;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.InvitingMembersAdapter;
import Model.InvitingMembersModel;

public class InvitingMembersFragment extends Fragment implements InvitingMembersAdapter.OnItemClickListener{
    private RecyclerView inviteGroupsRecyclerView;
    private ArrayList<InvitingMembersModel> invitingMembersArrayList=new ArrayList<>();
    private EditText search;
    private TextView searchResultCount;
    private ImageView filterIcon,backArrow;
    private ConstraintLayout searchLayout,noResultFoundLayout,recyclerViewLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_inviting_members, container, false);
        inviteGroupsRecyclerView=rootView.findViewById(R.id.inviteGroupsRecyclerView);
        searchLayout=rootView.findViewById(R.id.searchLayout);
        noResultFoundLayout=rootView.findViewById(R.id.noResultFoundLayout);
        recyclerViewLayout=rootView.findViewById(R.id.recyclerViewLayout);
        search=rootView.findViewById(R.id.search);
        searchResultCount=rootView.findViewById(R.id.searchResultCount);
        backArrow=rootView.findViewById(R.id.backArrow);
        filterIcon=rootView.findViewById(R.id.filterIcon);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        inviteGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        inviteGroupsRecyclerView.setHasFixedSize(true);
        InvitingMembersAdapter invitingMembersAdapter=new InvitingMembersAdapter(getContext(),invitingMembersArrayList,this);
        inviteGroupsRecyclerView.setAdapter(invitingMembersAdapter);

        InvitingMembersModel invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.no_profile_picture);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Solomon Jakes");
        invitingMembersModel.setProfileGender("Male,21 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);

         invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile1);
        invitingMembersModel.setFavouritesIndicator(R.drawable.favourite_icon);
        invitingMembersModel.setProfileName("Linda Raymond");
        invitingMembersModel.setProfileGender("Female,23 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile_image);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Daisy Lake");
        invitingMembersModel.setProfileGender("Female");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile);
        invitingMembersModel.setFavouritesIndicator(R.drawable.favourite_icon);
        invitingMembersModel.setProfileName("Diana Smith");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile1);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Dan Park");
        invitingMembersModel.setProfileGender("Female,27 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile2);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Nora Bravos");
        invitingMembersModel.setProfileGender("64 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        invitingMembersArrayList.add(invitingMembersModel);


        searchLayout.setOnClickListener(new View.OnClickListener() {
            private boolean flag=true;
            @Override
            public void onClick(View v) {
                if(flag) {
                    flag=false;
                    noResultFoundLayout.setVisibility(View.VISIBLE);
                    recyclerViewLayout.setVisibility(View.GONE);
                    search.setText("John");
                }else {
                    flag=true;
                    searchResultCount.setVisibility(View.VISIBLE);
                }

            }
        });
        return rootView;
    }

    @Override
    public void onItemClick(int position) {

    }
}
