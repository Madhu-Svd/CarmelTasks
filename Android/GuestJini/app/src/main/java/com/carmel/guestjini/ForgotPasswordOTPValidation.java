package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ForgotPasswordOTPValidation extends AppCompatActivity {
    TextView resendOtp,otpErrorField,getOneNow;
    MaterialButton submitButton;
    TextInputEditText firstOtp,secondOtp,thirdOtp,fourthOtp;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_otpvalidation);
        resendOtp=findViewById(R.id.resendOtp);
        otpErrorField=findViewById(R.id.otpErrorMessage);
        submitButton=findViewById(R.id.submitButton);
        firstOtp=findViewById(R.id.firstOtp);
        secondOtp=findViewById(R.id.secondOtp);
        thirdOtp=findViewById(R.id.thirdOtp);
        fourthOtp=findViewById(R.id.fourthOtp);
        getOneNow=findViewById(R.id.getOneNow);


        final StringBuilder sb=new StringBuilder();

        firstOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.length() ==1) {
                    secondOtp.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

        secondOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    thirdOtp.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        thirdOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    fourthOtp.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        fourthOtp.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    firstOtp.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstOtpBox=firstOtp.getText().toString().trim();
                String secondOtpBox=secondOtp.getText().toString().trim();
                String thirdOtpBox=thirdOtp.getText().toString().trim();
                String fourthOtpBox=fourthOtp.getText().toString().trim();

                if((firstOtpBox.length()==0) && (secondOtpBox.length()==0) && (thirdOtpBox.length()==0) && (fourthOtpBox.length()==0)){
                    otpErrorField.setVisibility(View.VISIBLE);
//                    firstOtp.setBackgroundResource(R.drawable.otp_error_box);
//                    secondOtp.setBackgroundResource(R.drawable.otp_error_box);
//                    thirdOtp.setBackgroundResource(R.drawable.otp_error_box);
//                    fourthOtp.setBackgroundResource(R.drawable.otp_error_box);
                }else {
                    otpErrorField.setVisibility(View.GONE);
//                    firstOtp.setBackgroundResource(R.drawable.otp_box);
//                    secondOtp.setBackgroundResource(R.drawable.otp_box);
//                    thirdOtp.setBackgroundResource(R.drawable.otp_box);
//                    fourthOtp.setBackgroundResource(R.drawable.otp_box);
                }if(!(firstOtpBox.length()==1) || !(secondOtpBox.length()==1) || !(thirdOtpBox.length()==1) || (fourthOtpBox.length()==1)){
                    otpErrorField.setVisibility(View.VISIBLE);
                }else {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.alert_dailogbox);


                    TextView alertDailogTitle = (TextView) dialog.findViewById(R.id.alertDailogTitle);
                    alertDailogTitle.setText("FORGOT PASSWORD");

                    TextView alertDailogMessage = (TextView) dialog.findViewById(R.id.alertDailogDescription);
                    alertDailogMessage.setText("New password has been sent to your registered mobile number.");

                    FloatingActionButton doneButton = (FloatingActionButton) dialog.findViewById(R.id.done_button);
                    doneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), ForgotPasswordOTPValidation.class);
                            startActivity(intent);
                        }
                    });

                    dialog.show();
                }

            }
        });

    }
}
