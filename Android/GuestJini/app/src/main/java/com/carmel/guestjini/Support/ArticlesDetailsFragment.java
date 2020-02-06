package com.carmel.guestjini.Support;


import android.app.Dialog;
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

import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import Adapter.ReviewAdapter;
import Model.ReviewModel;


public class ArticlesDetailsFragment extends Fragment {
  private RecyclerView reviewRecyclerView;
  private ImageView backArrow;
  private MaterialButton submitButton;

    ArrayList<ReviewModel> reviewModelArrayList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_articles_details, container, false);
        reviewRecyclerView=rootView.findViewById(R.id.reviewerRecyclerView);
        backArrow=rootView.findViewById(R.id.leftArrowMark);
        submitButton=rootView.findViewById(R.id.writeReviewSubmitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.feedback_loader_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
