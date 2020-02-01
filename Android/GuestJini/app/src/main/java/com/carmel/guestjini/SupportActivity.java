package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.carmel.guestjini.Support.ArticlesDetailsFragment;
import com.carmel.guestjini.Support.SupportLandingFragment;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
//        ArticlesDetailsFragment articlesDetailsFragment=new ArticlesDetailsFragment();
        SupportLandingFragment supportLandingFragment=new SupportLandingFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.SuppotPlaceHolder,supportLandingFragment);
        fragmentTransaction.commit();

    }
}
