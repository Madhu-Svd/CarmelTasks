package com.carmel.guestjini.Support;


import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adapter.AttachFilesAdapter;
import Model.AttachFilesModel;

public class AttachFilesFragment extends Fragment {
    MaterialButton attachFiles;
    DrawerLayout attachDrawerLayout;
    RecyclerView attachFilesRecyclerView;
    ArrayList<AttachFilesModel> attachFilesModelArrayList=new ArrayList<>();
    MaterialButton doneButoon;
    ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_attach_files, container, false);
        attachFiles=rootView.findViewById(R.id.attachFiles);
        attachDrawerLayout=rootView.findViewById(R.id.attachFilesDrawerLayout);
        attachFilesRecyclerView=rootView.findViewById(R.id.attachFilesRecyclerView);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        doneButoon=rootView.findViewById(R.id.done);
        attachFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attachDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTicketFragment newTicketFragment=new NewTicketFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,newTicketFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        attachFilesRecyclerView.setLayoutManager(linearLayoutManager);
        AttachFilesAdapter attachFilesAdapter=new AttachFilesAdapter(rootView.getContext(),attachFilesModelArrayList);
        attachFilesRecyclerView.setAdapter(attachFilesAdapter);

        AttachFilesModel attachFilesModel=new AttachFilesModel();
        attachFilesModel.setAttachFilesName("screenshot_2018-06-18-52-668.jpg");
        attachFilesModel.setAttachFilesSize("578 KB");
        attachFilesModelArrayList.add(attachFilesModel);

        attachFilesModel=new AttachFilesModel();
        attachFilesModel.setAttachFilesName("screenshot_2018-06-18-52-688.jpg");
        attachFilesModel.setAttachFilesSize("719 KB");
        attachFilesModelArrayList.add(attachFilesModel);

        attachFilesModel=new AttachFilesModel();
        attachFilesModel.setAttachFilesName("screenshot_2018-06-18-52-668.jpg");
        attachFilesModel.setAttachFilesSize("278 KB");
        attachFilesModelArrayList.add(attachFilesModel);


        doneButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.alert_dailogbox);

                TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                alertDailogTitle.setText(getText(R.string.failed));
                alertDailogTitle.setTextColor(Color.parseColor("#E65959"));

                TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                alertDailogMessage.setText("Please attach a file to continue.");

                FloatingActionButton doneButton= (FloatingActionButton) dialog.findViewById(R.id.done_button);
                doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                        .parseColor("#E65959")));
                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return rootView;
    }

}
