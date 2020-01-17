package com.carmel.guestjini.Settings;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.carmel.guestjini.R;

public class MyProfileFragment extends Fragment {
    ImageView backIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_my_profile, container, false);
        backIcon=rootView.findViewById(R.id.leftArrowMark);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsLandingFragment settingsLandingFragment=new SettingsLandingFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SettingsPlaceHolder,settingsLandingFragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
