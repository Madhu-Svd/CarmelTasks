package com.carmel.guestjini.MyGroups;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.JoinedMembersAdapter;
import Adapter.PendingRequestsAdapter;
import Model.InvitingMembersModel;
import Model.JoinedMemberModel;

public class MyGroupsDetailsFragment extends Fragment {
    private TextView groupName,groupDescription,groupCreationDateAndTime;
    String GroupName,GroupDescription,GroupCreationDateAndTime;
    private ImageView backArrow;
    private Button inviteButton;
    private ArrayList<JoinedMemberModel> joinedMembersArrayList=new ArrayList<>();
    private ArrayList<InvitingMembersModel> pendingRequestsArrayList=new ArrayList<>();
    private RecyclerView joinedMembersRecyclerView,pendingRequestsRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_my_groups_details, container, false);
        groupName = rootView.findViewById(R.id.myGroupName);
        groupCreationDateAndTime = rootView.findViewById(R.id.myGroupCreationDate);
        groupDescription = rootView.findViewById(R.id.myGroupDescription);
        backArrow=rootView.findViewById(R.id.backArrow);
        inviteButton=rootView.findViewById(R.id.inviteButton);
        pendingRequestsRecyclerView=rootView.findViewById(R.id.pendingRequestsRecyclerView);
        joinedMembersRecyclerView=rootView.findViewById(R.id.joinedMembersRecyclerView);

        Bundle bundle = getArguments();
        if (bundle != null) {
            GroupName = bundle.getString("GroupName");
            GroupCreationDateAndTime = bundle.getString("GroupCreationDateAndTime");
            GroupDescription = bundle.getString("GroupDescription");

            groupName.setText(GroupName);
            groupCreationDateAndTime.setText(GroupCreationDateAndTime);
            groupDescription.setText(GroupDescription);
        }

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyGroupsFragment myGroupsFragment=new MyGroupsFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.myGroupsPlaceHolder,myGroupsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        inviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvitingMembersFragment invitingMembersFragment=new InvitingMembersFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.myGroupsPlaceHolder,invitingMembersFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        joinedMembersRecyclerView.setLayoutManager(linearLayoutManager);
        joinedMembersRecyclerView.setHasFixedSize(true);
        JoinedMembersAdapter joinedMembersAdapter=new JoinedMembersAdapter(getContext(),joinedMembersArrayList);
        joinedMembersRecyclerView.setAdapter(joinedMembersAdapter);

        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile2,"Soloman Jakes","Today (Just now)"));
        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile,"Luke Ray","Since 29 Jun 2019 (2 Hours ago"));
        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile1,"Daisy Lake","Since 29 Jun 2019 (1 Day ago"));
        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile2,"Mark Smith","Since 29 Jun 2019 (3 Days ago"));
        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile,"Lucy Lake","Since 29 Jun 2019 (1 Day ago"));
        joinedMembersArrayList.add(new JoinedMemberModel(R.drawable.profile2,"Dan Smith","Since 29 Jun 2019 (3 Days ago"));



        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext());
        pendingRequestsRecyclerView.setLayoutManager(linearLayoutManager1);
        pendingRequestsRecyclerView.setHasFixedSize(true);
        PendingRequestsAdapter pendingRequestsAdapter=new PendingRequestsAdapter(getContext(),pendingRequestsArrayList);
        pendingRequestsRecyclerView.setAdapter(pendingRequestsAdapter);

        InvitingMembersModel invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.no_profile_picture);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Solomon Jakes");
        invitingMembersModel.setProfileGender("Male,21 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile1);
        invitingMembersModel.setFavouritesIndicator(R.drawable.favourite_icon);
        invitingMembersModel.setProfileName("Linda Raymond");
        invitingMembersModel.setProfileGender("Female,23 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile_image);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Daisy Lake");
        invitingMembersModel.setProfileGender("Female");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile);
        invitingMembersModel.setFavouritesIndicator(R.drawable.favourite_icon);
        invitingMembersModel.setProfileName("Diana Smith");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile1);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Dan Park");
        invitingMembersModel.setProfileGender("Female,27 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);

        invitingMembersModel=new InvitingMembersModel();
        invitingMembersModel.setProfilePicture(R.drawable.profile2);
        invitingMembersModel.setFavouritesIndicator(0);
        invitingMembersModel.setProfileName("Nora Bravos");
        invitingMembersModel.setProfileGender("64 Years");
        invitingMembersModel.setInvitationSentMessage("Invitation Sent");
        invitingMembersModel.setInvitationSentDate(" 21 July 2019");
        pendingRequestsArrayList.add(invitingMembersModel);


        return rootView;

    }

}
