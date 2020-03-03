package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.carmel.guestjini.Groups.GroupsLandingFragment;
import com.carmel.guestjini.People.PeopleLandingFragment;

public class GroupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        GroupsLandingFragment groupsLandingFragment=new GroupsLandingFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.groupsPlaceHolder,groupsLandingFragment);
        fragmentTransaction.commit();

    }
}
