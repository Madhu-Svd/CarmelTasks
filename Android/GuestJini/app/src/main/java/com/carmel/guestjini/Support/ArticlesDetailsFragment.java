package com.carmel.guestjini.Support;


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

import Model.ReviewModel;


public class ArticlesDetailsFragment extends Fragment {
    RecyclerView reviewRecyclerView;
    ImageView backArrow;
    ArrayList<ReviewModel> reviewModelArrayList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_articles_details, container, false);
        reviewRecyclerView=rootView.findViewById(R.id.reviewerRecyclerView);
        backArrow=rootView.findViewById(R.id.leftArrowMark);

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

            }
        });
        return rootView;
    }

}
