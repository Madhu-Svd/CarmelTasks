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

import com.carmel.guestjini.CommunityGroups.InvitedGroupViewFragment;
import com.carmel.guestjini.R;

import java.util.ArrayList;

import Adapter.MyGroupsAdapter;
import Model.CommunityGroupsModel;

public class MyGroupsFragment extends Fragment implements MyGroupsAdapter.OnItemClickListener{
    private  ImageView createIcon;
    private Button inviteButton;
    private RecyclerView myGroupsRecyclerView;
    private ArrayList<CommunityGroupsModel> myGroupsArrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_my_groups, container, false);
        createIcon=rootView.findViewById(R.id.createIcon);
        inviteButton=rootView.findViewById(R.id.inviteButton);
        myGroupsRecyclerView=rootView.findViewById(R.id.myGroupsRecyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        myGroupsRecyclerView.setLayoutManager(linearLayoutManager);
        myGroupsRecyclerView.setHasFixedSize(true);
        MyGroupsAdapter myGroupsAdapter=new MyGroupsAdapter(getContext(),myGroupsArrayList,this);
        myGroupsRecyclerView.setAdapter(myGroupsAdapter);


        myGroupsArrayList.add(new CommunityGroupsModel("Apache Riders",
                "John Doe",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Donec dignissim felis et magna mattis finibus." +
                        " Nulla elit ligula, placerat tincidunt ipsum eu, ornare semper felis. " +
                        "Duis arcu massa, venenatis eget ante sodales, posuere volutpat risus." +
                        " Aenean et justo eu massa sodales posuere.Duis arcu massa, venenatis eget ante sodales, posuere volutpat risus.",
                null,
                R.drawable.profile2,
                0,
                CommunityGroupsModel.JoinedGroupsCell));

        myGroupsArrayList.add(new CommunityGroupsModel("STAND-UP COMEDY",
                "YOU",
                "2nd July 2019 06:21 PM (4 Days ago)",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat sapien, ultricies.",
                null,
                R.drawable.profile2,
                0,
                CommunityGroupsModel.RemovedCell));


        createIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewGroupFragment newGroupFragment=new NewGroupFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.myGroupsPlaceHolder,newGroupFragment);
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
        return rootView;
    }

    @Override
    public void onClikJoinedGroup(int position) {
        myGroupsArrayList.get(position);
        MyGroupsDetailsFragment myGroupsDetailsFragment=new MyGroupsDetailsFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.myGroupsPlaceHolder,myGroupsDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        Bundle bundle=new Bundle();
        bundle.putString("GroupName",myGroupsArrayList.get(position).getCommunityGroupTitle());
        bundle.putString("GroupDescription",myGroupsArrayList.get(position).getCommunityGroupDescription());
        bundle.putString("GroupCreationDateAndTime",myGroupsArrayList.get(position).getCommunityGroupCreationDateAndTime());
        bundle.putInt("GroupIcon",myGroupsArrayList.get(position).getAdminProfileIcon());
        myGroupsDetailsFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    public void onClikRemovedGroup(int position) {

    }
}
