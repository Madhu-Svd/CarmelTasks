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
    ImageView backIcon,profileToggleButton,gender,age,mobileNo,place,email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_my_profile, container, false);
        backIcon=rootView.findViewById(R.id.leftArrowMark);
        profileToggleButton=rootView.findViewById(R.id.profileToggleButton);
        gender=rootView.findViewById(R.id.genderToggleIcon);
        age=rootView.findViewById(R.id.ageToggleIcon);
        mobileNo=rootView.findViewById(R.id.mobileNoToggleIcon);
        place=rootView.findViewById(R.id.yourPlaceToggleIcon);
        email=rootView.findViewById(R.id.emailToggleIcon);



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

        profileToggleButton.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    profileToggleButton.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }else{
                    flag=true;
                    profileToggleButton.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }

            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    gender.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }else{
                    flag=true;
                    gender.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }

            }
        });

        mobileNo.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    mobileNo.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }else{
                    flag=true;
                    mobileNo.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }

            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    age.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }else{
                    flag=true;
                    age.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }

            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    place.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }else{
                    flag=true;
                    place.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }

            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    email.setImageResource(R.drawable.toggle_icon_off_xxhdpi);
                }else{
                    flag=true;
                    email.setImageResource(R.drawable.toggle_icon_on_xxhdpi);
                }

            }
        });
        return rootView;
    }

}
