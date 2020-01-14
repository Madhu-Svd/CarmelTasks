package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    TextView emailErrorField,getOneNow,forgotPasswordErrorMessage;
    EditText email;
    Button resetPassword;
    ImageView backIcon;
    String MobilePattern = "[0-9]{10}";
    String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        emailErrorField=findViewById(R.id.emailErrorField);
        getOneNow=findViewById(R.id.getOneNow);
        email=findViewById(R.id.email);
        backIcon=findViewById(R.id.backArrowIcon);
        resetPassword=findViewById(R.id.resetPasswordButton);
        forgotPasswordErrorMessage=findViewById(R.id.forgotPasswordErrorMessage);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().length()==0){
                    emailErrorField.setVisibility(View.VISIBLE);
                    email.setBackgroundResource(R.drawable.edit_red_textbox);
                }else if(!email.getText().toString().trim().matches(EMAIL_PATTERN) && !email.getText().toString().trim().matches(MobilePattern)){
                    emailErrorField.setVisibility(View.VISIBLE);
                    email.setBackgroundResource(R.drawable.edit_red_textbox);
                    forgotPasswordErrorMessage.setVisibility(View.VISIBLE);
                    emailErrorField.setVisibility(View.GONE);
                    backIcon.setVisibility(View.GONE);
                    email.setBackgroundResource(R.drawable.edit_textbox);
                }
            }
        });

        getOneNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GetAccount.class);
                startActivity(intent);
            }
        });
    }
}
