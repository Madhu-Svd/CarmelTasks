package com.carmel.guestjini.Support;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.carmel.guestjini.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTicketsFragment extends Fragment {
    ImageView leftArrowMark;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_my_tickets, container, false);
        leftArrowMark=rootView.findViewById(R.id.leftArrowMark);
        leftArrowMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupportLandingFragment supportLandingFragment=new SupportLandingFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,supportLandingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}