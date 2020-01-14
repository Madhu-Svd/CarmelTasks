package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView emailErrorField,passwordErrorField,forgotPassword,invalidCredentials,getOneNow;
    EditText email,password;
    ImageView passwordIcon;
    Button loginButton;
    ConstraintLayout passwordLayout;
    String MobilePattern = "[0-9]{10}";
    String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String  PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.* [@#$%^&+=])(?=\\S+$).{4,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailErrorField=findViewById(R.id.emailErrorField);
        passwordErrorField=findViewById(R.id.passwordErrorField);
        forgotPassword=findViewById(R.id.forgotPassword);
        invalidCredentials=findViewById(R.id.invalidCredentials);
        getOneNow=findViewById(R.id.getOneNow);
        passwordIcon=findViewById(R.id.passwordMaskingIcon);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginButton=findViewById(R.id.login);
        passwordLayout=findViewById(R.id.passwordLayout);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().length()==0 && password.getText().toString().trim().length()==0){
                    emailErrorField.setVisibility(View.VISIBLE);
                    passwordErrorField.setVisibility(View.VISIBLE);
                    email.setBackgroundResource(R.drawable.edit_red_textbox);
                    passwordLayout.setBackgroundResource(R.drawable.edit_red_textbox);
                }else {
                    emailErrorField.setVisibility(View.GONE);
                    passwordErrorField.setVisibility(View.GONE);
                    email.setBackgroundResource(R.drawable.edit_textbox);
                    passwordLayout.setBackgroundResource(R.drawable.edit_textbox);
                    if(email.getText().toString().trim().length()==0){
                        emailErrorField.setVisibility(View.VISIBLE);
                        email.setBackgroundResource(R.drawable.edit_red_textbox);
                        invalidCredentials.setVisibility(View.GONE);
                    }else if(password.getText().toString().trim().length()==0){
                        passwordErrorField.setVisibility(View.VISIBLE);
                        passwordLayout.setBackgroundResource(R.drawable.edit_red_textbox);
                        invalidCredentials.setVisibility(View.GONE);
                    }else if(!email.getText().toString().trim().matches(EMAIL_PATTERN) && !email.getText().toString().trim().matches(MobilePattern)){
                        invalidCredentials.setVisibility(View.VISIBLE);
                        emailErrorField.setVisibility(View.GONE);
                        email.setBackgroundResource(R.drawable.edit_textbox);
                        passwordLayout.setBackgroundResource(R.drawable.edit_textbox);
                    }else if (password.getText().toString().trim().length()<8){
                        passwordErrorField.setVisibility(View.GONE);
                        invalidCredentials.setVisibility(View.VISIBLE);
                        email.setBackgroundResource(R.drawable.edit_textbox);
                        passwordLayout.setBackgroundResource(R.drawable.edit_textbox);
                    }else {
                        Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                        startActivity(intent);
                    }
                }
            }
        });


        passwordIcon.setOnClickListener(new View.OnClickListener() {
            private boolean flag=true;
            @Override
            public void onClick(View v) {
                if(flag){
                    flag=false;
                    passwordIcon.setImageResource(R.drawable.password_unmasking_icon);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    flag=true;
                    passwordIcon.setImageResource(R.drawable.password_masking_icon);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);
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
