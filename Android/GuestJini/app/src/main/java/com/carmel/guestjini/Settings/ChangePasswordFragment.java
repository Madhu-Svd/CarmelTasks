package com.carmel.guestjini.Settings;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.carmel.guestjini.ForgotPasswordOTPValidation;
import com.carmel.guestjini.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class ChangePasswordFragment extends Fragment {
TextInputLayout currentPasswordLayout,newPasswordLayout,confirmPasswordLayout;
TextInputEditText currentPasswordEditText,newPasswordEditText,confirmPasswordEditText;
TextView currentPaswordErrorField,newPaswordErrorField,confirmPaswordErrorField;
MaterialButton changePasswordButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_change_password, container, false);
//        currentPasswordLayout=rootview.findViewById(R.id.);
        currentPasswordEditText=rootview.findViewById(R.id.currentPasswordEditText);
        currentPaswordErrorField=rootview.findViewById(R.id.currentPasswordErrorField);
//        currentPasswordLayout.setBoxStrokeColorStateList(ColorStateList.valueOf(Color
//                .parseColor("#E65959")));

//        newPasswordLayout=rootview.findViewById(R.id.newPasswordLayout);
        newPasswordEditText=rootview.findViewById(R.id.newPasswordEditText);
        newPaswordErrorField=rootview.findViewById(R.id.newPasswordErrorField);

//        confirmPasswordLayout=rootview.findViewById(R.id.confirmPasswordLayout);
        confirmPasswordEditText=rootview.findViewById(R.id.confirmPasswordEditText);
        confirmPaswordErrorField=rootview.findViewById(R.id.confirmPasswordErrorField);

        changePasswordButton=rootview.findViewById(R.id.changePasswordButton);
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPasswordEditText.getText().toString().trim().length()==0 && newPasswordEditText.getText().toString().trim().length()==0 && confirmPasswordEditText.getText().toString().trim().length()==0 ){
                    currentPaswordErrorField.setVisibility(View.VISIBLE);
                    newPaswordErrorField.setVisibility(View.VISIBLE);
                    confirmPaswordErrorField.setVisibility(View.VISIBLE);
//                    currentPasswordLayout.setBackgroundResource(R.drawable.edit_red_textbox);
//                    newPasswordLayout.setBackgroundResource(R.drawable.edit_red_textbox);
//                    confirmPasswordLayout.setBackgroundResource(R.drawable.edit_red_textbox);
                }else {
                    final Dialog dialog=new Dialog(getContext());
                    dialog.setContentView(R.layout.alert_dailogbox);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                    alertDailogTitle.setText("FAILED");
                    alertDailogTitle.setTextColor(Color.parseColor("#E65959"));

                    TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                    alertDailogMessage.setText("There was some error while changing password. Please try again!!");

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
                            alertDailogTitle.setText("SUCCESS");

                            TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                            alertDailogMessage.setText("Your password has been successfully changed.");

                            FloatingActionButton doneButton= (FloatingActionButton) dialog.findViewById(R.id.done_button);
                            doneButton.setBackgroundTintList(ColorStateList.valueOf(Color
                                    .parseColor("#32BDD2")));
                            doneButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                    SettingsLandingFragment settingsLandingFragment=new SettingsLandingFragment();
                                    FragmentManager fragmentManager=getFragmentManager();
                                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.SettingsPlaceHolder,settingsLandingFragment);
                                    fragmentTransaction.commit();
                                }
                            });
                            dialog.show();
                        }
                    });

                    dialog.show();

                }
            }
        });


        return rootview;
    }


}
