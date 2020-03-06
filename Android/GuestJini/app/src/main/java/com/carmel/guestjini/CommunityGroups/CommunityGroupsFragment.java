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
import Model.CommunityGroupsModel;

public class CommunityGroupsFragment extends Fragment {
    private ArrayList<CommunityGroupsModel> communityGroupsList=new ArrayList<>();
    private RecyclerView communityGroupsRecyclerView;
    private ImageView communityGroupFilterIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_community_groups, container, false);
        communityGroupsRecyclerView=rootView.findViewById(R.id.RecyclerViewCommunityGroups);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        communityGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        communityGroupsRecyclerView.setHasFixedSize(true);
        CommunityGroupsAdapter communityGroupsAdapter=new CommunityGroupsAdapter(getContext(),communityGroupsList);
        communityGroupsAdapter.setHasStableIds(true);
        communityGroupsRecyclerView.setAdapter(communityGroupsAdapter);

        communityGroupsList.add(new CommunityGroupsModel("MOVIE NIGHT - LION KING",
                "Daisy Lake",
                "Today 11:38 AM (2 Hours ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
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
        return rootView;
    }

}
