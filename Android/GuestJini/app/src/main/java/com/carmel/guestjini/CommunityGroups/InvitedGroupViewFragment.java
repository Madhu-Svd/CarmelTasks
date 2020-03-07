package com.carmel.guestjini.CommunityGroups;


import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.carmel.guestjini.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adapter.CommunityGroupMemberAdapter;

import Model.InterestGroupMembersModel;


public class InvitedGroupViewFragment extends Fragment {
    private ArrayList<InterestGroupMembersModel> communityGroupMemberModel=new ArrayList<>();
    private RecyclerView groupMemberRecyclerView;
    private TextView groupName,groupDescription,groupAdminName,groupCreationDateAndTime;
    String GroupName,GroupDescription,GroupAdminName,GroupCreationDateAndTime;
    private Button conversationButton,ignoreButton,exitButton;
    private RelativeLayout conversationMainLayout;
    private ImageView backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_invited_group_view, container, false);
        groupMemberRecyclerView = rootview.findViewById(R.id.groupMemberRecyclerView);
        groupName = rootview.findViewById(R.id.communityGroupName);
        groupDescription = rootview.findViewById(R.id.communityGroupDescription);
        groupAdminName = rootview.findViewById(R.id.systemTitle);
        groupCreationDateAndTime = rootview.findViewById(R.id.createDateTime);
        conversationButton = rootview.findViewById(R.id.conversationButton);
        ignoreButton = rootview.findViewById(R.id.ignoreButton);
        exitButton = rootview.findViewById(R.id.exitButton);
        conversationMainLayout=rootview.findViewById(R.id.conversationMainLayout);
        backButton=rootview.findViewById(R.id.backButton);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        groupMemberRecyclerView.setLayoutManager(linearLayoutManager);
        groupMemberRecyclerView.setHasFixedSize(true);
        CommunityGroupMemberAdapter communityGroupMemberAdapter = new CommunityGroupMemberAdapter(getContext(), communityGroupMemberModel);
        groupMemberRecyclerView.setAdapter(communityGroupMemberAdapter);

        InterestGroupMembersModel interestGroupMembersModel = new InterestGroupMembersModel();
        interestGroupMembersModel.setInterestGroupMemberProfileName("You");
        interestGroupMembersModel.setInterestGroupMemberProfileCreatedDate("Since 29 July 2019");
        communityGroupMemberModel.add(interestGroupMembersModel);

        interestGroupMembersModel = new InterestGroupMembersModel();
        interestGroupMembersModel.setInterestGroupMemberProfileName("Luke Ray");
        interestGroupMembersModel.setInterestGroupMemberProfileCreatedDate("Since 29 July 2019");
        communityGroupMemberModel.add(interestGroupMembersModel);

        interestGroupMembersModel = new InterestGroupMembersModel();
        interestGroupMembersModel.setInterestGroupMemberProfileName("Daisy Lake");
        interestGroupMembersModel.setInterestGroupMemberProfileCreatedDate("Since 29 July 2019");
        communityGroupMemberModel.add(interestGroupMembersModel);

        interestGroupMembersModel = new InterestGroupMembersModel();
        interestGroupMembersModel.setInterestGroupMemberProfileName("Mark Smith");
        interestGroupMembersModel.setInterestGroupMemberProfileCreatedDate("Since 29 July 2019");
        communityGroupMemberModel.add(interestGroupMembersModel);

        interestGroupMembersModel = new InterestGroupMembersModel();
        interestGroupMembersModel.setInterestGroupMemberProfileName("Dan Park");
        interestGroupMembersModel.setInterestGroupMemberProfileCreatedDate("Since 29 July 2019");
        communityGroupMemberModel.add(interestGroupMembersModel);

        Bundle bundle = getArguments();
        if (bundle != null) {
            GroupName = bundle.getString("GroupName");
            GroupDescription = bundle.getString("GroupDescription");
            GroupAdminName = bundle.getString("GroupAdminName");
            GroupCreationDateAndTime = bundle.getString("GroupCreationDateAndTime");

            groupName.setText(GroupName);
            groupDescription.setText(GroupDescription);
            groupAdminName.setText(GroupAdminName);
            groupCreationDateAndTime.setText(GroupCreationDateAndTime);

        }

        if (GroupName.equals("HAMPI TRIP")) {
            exitButton.setVisibility(View.VISIBLE);
            conversationMainLayout.setVisibility(View.GONE);
        } else {
            exitButton.setVisibility(View.GONE);
            conversationMainLayout.setVisibility(View.VISIBLE);
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityGroupsFragment communityGroupsFragment = new CommunityGroupsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.communityGroupsPlaceHolder, communityGroupsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.alert_dailogbox);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                alertDailogTitle.setText(getText(R.string.exit_group));
                alertDailogTitle.setTextColor(ColorStateList.valueOf(Color.parseColor("#E65959")));

                TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                alertDailogMessage.setText(getText(R.string.feedback_success));

                FloatingActionButton doneButton = (FloatingActionButton) dialog.findViewById(R.id.done_button);
                doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                        .parseColor("#E65959")));
                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        CommunityGroupsFragment communityGroupsFragment = new CommunityGroupsFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.communityGroupsPlaceHolder, communityGroupsFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                });

                dialog.show();
            }
        });

        conversationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityGroupsFragment communityGroupsFragment = new CommunityGroupsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.communityGroupsPlaceHolder, communityGroupsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ignoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.alert_dailogbox);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                alertDailogTitle.setText(getText(R.string.ignore));
                alertDailogTitle.setTextColor(ColorStateList.valueOf(Color.parseColor("#E65959")));

                TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                alertDailogMessage.setText(getText(R.string.feedback_success));

                FloatingActionButton doneButton = (FloatingActionButton) dialog.findViewById(R.id.done_button);
                doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                        .parseColor("#E65959")));
                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        CommunityGroupsFragment communityGroupsFragment = new CommunityGroupsFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.communityGroupsPlaceHolder, communityGroupsFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                });

                dialog.show();

            }
        });

        return rootview;
        }

    }
