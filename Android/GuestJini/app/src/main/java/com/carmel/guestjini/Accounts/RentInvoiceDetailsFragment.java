package com.carmel.guestjini.Accounts;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
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
    String AccountsTitle,RentInvoiceDate,RentInvoiceNo,RentInvoiceAmount,Amount,ReceiptsDate,ReceiptsAmount;
    private TextView rentInvoiceDate,rentInvoiceNo,rentInvoiceAmount,accountsTitle,receiptsDate,receiptsAmount;
    private RelativeLayout moreDetailsHeader,moreDetailsLayout,transactionSuccessfulLayout,rentInvoiceDetails;
    private ImageView dropDownIcon,backArrow;
    private Button payNowButton;
    private ConstraintLayout receiptsDetailsLayout;
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
        transactionSuccessfulLayout=rootView.findViewById(R.id.transactionSuccessfulLayout);
        receiptsDetailsLayout=rootView.findViewById(R.id.receiptsDetailsLayout);
        receiptsDate=rootView.findViewById(R.id.receiptsDateValue);
        receiptsAmount=rootView.findViewById(R.id.amountValue);
        rentInvoiceDetails=rootView.findViewById(R.id.rentInvoiceDetails);



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

        final Bundle bundle1=getArguments();
        if(bundle1!=null){
            ReceiptsDate=bundle1.getString("ReceiptsDate");
            ReceiptsAmount=bundle1.getString("ReceiptsAmount");
            AccountsTitle=bundle1.getString("AccountsTitle");

            receiptsDate.setText(ReceiptsDate);
            receiptsAmount.setText(ReceiptsAmount);
            accountsTitle.setText(AccountsTitle);
        }
        if (AccountsTitle.equals("RECEIPTS")){
            receiptsDetailsLayout.setVisibility(View.VISIBLE);
            rentInvoiceDetails.setVisibility(View.GONE);
        }

//        final Bundle bundle1=getArguments();
//        if(bundle1!=null){
//
//            Amount=bundle1.getString("amount");
////            rentInvoiceAmount.setText(Amount);
//            payNowButton.setVisibility(View.GONE);
//            transactionSuccessfulLayout.setVisibility(View.VISIBLE);
//        }

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
                    dropDownIcon.setImageResource(R.drawable.drop_down_icon_xhdpi);
                    moreDetailsLayout.setVisibility(View.GONE);
                }else{
                    flag = true;
                    dropDownIcon.setImageResource(R.drawable.drop_up_icon);
                    moreDetailsLayout.setVisibility(View.VISIBLE);
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
