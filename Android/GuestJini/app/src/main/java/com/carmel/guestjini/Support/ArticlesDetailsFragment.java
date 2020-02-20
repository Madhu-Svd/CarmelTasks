package com.carmel.guestjini.Support;


import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adapter.ReviewAdapter;
import Model.ReviewModel;


public class ArticlesDetailsFragment extends Fragment {
  private RecyclerView reviewRecyclerView;
  private ImageView backArrow;
  private MaterialButton submitButton;
  private TextView ticketAuthorName,ticketName,ticketDate;

    ArrayList<ReviewModel> reviewModelArrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_articles_details, container, false);
        reviewRecyclerView=rootView.findViewById(R.id.reviewerRecyclerView);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        submitButton=rootView.findViewById(R.id.writeReviewSubmitButton);
        ticketAuthorName=rootView.findViewById(R.id.ticketAuthorName);
        ticketName=rootView.findViewById(R.id.ticketName);
        ticketDate=rootView.findViewById(R.id.ticketDate);

        final Bundle bundle = this.getArguments();
        if (bundle != null) {
         String   ticket_author_name  = bundle.getString("ticket_author_name");
         String   ticket_name  = bundle.getString("ticket_name");
         String   ticket_date  = bundle.getString("ticket_date");
//            ticket_value  = bundle.getString("ticket_value");

            ticketAuthorName.setText(ticket_author_name);
            ticketName.setText(ticket_name);
            ticketDate.setText(ticket_date);
//            ticketValue.setText(ticket_value);
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.feedback_loader_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                RelativeLayout loaderDialogLayout=(RelativeLayout)dialog.findViewById(R.id.loaderDialogLayout);
                loaderDialogLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        final Dialog dialog=new Dialog(getContext());
                        dialog.setContentView(R.layout.alert_dailogbox);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                        alertDailogTitle.setText(getText(R.string.failed));
                        alertDailogTitle.setTextColor(Color.parseColor("#E65959"));

                        TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                        alertDailogMessage.setText(getText(R.string.feedback_failed));

                        FloatingActionButton doneButton= (FloatingActionButton) dialog.findViewById(R.id.done_button);
                        doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                                .parseColor("#E65959")));

                        doneButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();

                                final Dialog dialog=new Dialog(getContext());
                                dialog.setContentView(R.layout.alert_dailogbox);
                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                                TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                                alertDailogTitle.setText(getText(R.string.success));

                                TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                                alertDailogMessage.setText(R.string.feedback_success);

                                FloatingActionButton doneButton= (FloatingActionButton) dialog.findViewById(R.id.done_button);
                                doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                                        .parseColor("#32BDD2")));
                                doneButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
//                                        MyTicketsRecyclerViewFragment myTicketsRecyclerViewFragment=new MyTicketsRecyclerViewFragment();
//                                        FragmentManager fragmentManager=getFragmentManager();
//                                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                                        fragmentTransaction.replace(R.id.SuppotPlaceHolder,myTicketsRecyclerViewFragment);
//                                        fragmentTransaction.addToBackStack(null);
//                                        fragmentTransaction.commit();
                                    }
                                });
                                dialog.show();
                            }
                        });

                        dialog.show();
                    }
                });

                dialog.show();
            }
        });


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        reviewRecyclerView.setLayoutManager(linearLayoutManager);
        ReviewAdapter reviewAdapter=new ReviewAdapter(getContext(),reviewModelArrayList);
        reviewRecyclerView.setAdapter(reviewAdapter);

        ReviewModel reviewModel=new ReviewModel();
        reviewModel.setReviewerName("Raman Goel");
        reviewModel.setReviewDate("18 Mar 2019");
        reviewModel.setReviewDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales primis, mollis viverra conubia ligula inceptos laoreet libero tortor.");
        reviewModelArrayList.add(reviewModel);

        reviewModel=new ReviewModel();
        reviewModel.setReviewerName("Raman Raghav");
        reviewModel.setReviewDate("18 Mar 2019");
        reviewModel.setReviewDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit sodales primis, mollis viverra conubia ligula inceptos laoreet libero tortor.");
        reviewModelArrayList.add(reviewModel);


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExploreFragment exploreFragment=new ExploreFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.SuppotPlaceHolder,exploreFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
