package com.carmel.materialactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MaterialButton login;
    TextInputEditText textInputEditText;
    FloatingActionButton fab,doneBtn;
    PopupWindow popupWindow;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.loginButton);
        fab=findViewById(R.id.cameraIcon);

        linearLayout=findViewById(R.id.layout);
        textInputEditText=findViewById(R.id.userName);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),SupportMaterialsActivity.class);
//                startActivity(intent);
//                fab.setBackgroundTintList(ColorStateList.valueOf(Color
//                        .parseColor("#33691E")));
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.alert_dailogbox,null);

//                closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);
                doneBtn=customView.findViewById(R.id.done_button);
                doneBtn.setBackgroundTintList(ColorStateList.valueOf(Color
                        .parseColor("#32BDD2")));
                //instantiate popup window
                popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(linearLayout, Gravity.CENTER, 0, 0);

                //close the popup window on button click
                doneBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}
