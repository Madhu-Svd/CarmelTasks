package com.carmel.guestjini.Accounts;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carmel.guestjini.R;


public class RentInvoiceDetailsFragment extends Fragment {
    String RentInvoiceDate,RentInvoiceNo,RentInvoiceAmount;
    private TextView rentInvoiceDate,rentInvoiceNo,rentInvoiceAmount;
    private RelativeLayout moreDetailsHeader,moreDetailsLayout;
    private ImageView dropDownIcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_rent_invoice_details, container, false);
        rentInvoiceDate=rootView.findViewById(R.id.rentDate);
        rentInvoiceNo=rootView.findViewById(R.id.rentNo);
        rentInvoiceAmount=rootView.findViewById(R.id.totalAmount);
        moreDetailsHeader=rootView.findViewById(R.id.moreDetailsHeader);
        moreDetailsLayout=rootView.findViewById(R.id.moreDetailsLayout);
        dropDownIcon=rootView.findViewById(R.id.dropDownIcon);


        final Bundle bundle=getArguments();
        if(bundle!=null){
            RentInvoiceDate=bundle.getString("RentInvoiceDate");
            RentInvoiceNo=bundle.getString("RentInvoiceNo");
            RentInvoiceAmount=bundle.getString("RentInvoiceAmount");

            rentInvoiceDate.setText(RentInvoiceDate);
            rentInvoiceNo.setText(RentInvoiceNo);
            rentInvoiceAmount.setText(RentInvoiceAmount);
        }

        moreDetailsHeader.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag) {
                    flag = false;
                    dropDownIcon.setImageResource(R.drawable.drop_up_icon);
                    moreDetailsLayout.setVisibility(View.VISIBLE);
                }else{
                    flag = true;
                    dropDownIcon.setImageResource(R.drawable.drop_down_icon_xhdpi);
                    moreDetailsLayout.setVisibility(View.GONE);
                }

            }
        });
        return rootView;
    }

}
