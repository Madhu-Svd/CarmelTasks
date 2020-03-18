package com.carmel.guestjini.Accounts;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carmel.guestjini.R;


public class RentInvoiceDetailsFragment extends Fragment {
    String AccountsTitle,RentInvoiceDate,RentInvoiceNo,RentInvoiceAmount;
    private TextView rentInvoiceDate,rentInvoiceNo,rentInvoiceAmount,accountsTitle;
    private RelativeLayout moreDetailsHeader,moreDetailsLayout;
    private ImageView dropDownIcon,backArrow;
    private Button payNowButton;
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
        accountsTitle=rootView.findViewById(R.id.accountsHeaderTitle);
        backArrow=rootView.findViewById(R.id.backArrow);
        payNowButton=rootView.findViewById(R.id.payNowButton);



        final Bundle bundle=getArguments();
        if(bundle!=null){
            RentInvoiceDate=bundle.getString("RentInvoiceDate");
            RentInvoiceNo=bundle.getString("RentInvoiceNo");
            RentInvoiceAmount=bundle.getString("RentInvoiceAmount");
            AccountsTitle=bundle.getString("AccountsTitle");

            rentInvoiceDate.setText(RentInvoiceDate);
            rentInvoiceNo.setText(RentInvoiceNo);
            rentInvoiceAmount.setText(RentInvoiceAmount);
            accountsTitle.setText(AccountsTitle);
        }

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountsDetailsFragment accountsDetailsFragment=new AccountsDetailsFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.AccountsPlaceHolder,accountsDetailsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

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

        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentOptionsFragment paymentOptionsFragment=new PaymentOptionsFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.AccountsPlaceHolder,paymentOptionsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
