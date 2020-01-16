package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.carmel.guestjini.Settings.ChangePasswordFragment;
import com.carmel.guestjini.Settings.SettingsLandingFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SettingsLandingFragment changePasswordFragment=new SettingsLandingFragment();
//        SubscribedGroupChatFragment subscribedGroupConversationFragment=new SubscribedGroupChatFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.SettingsPlaceHolder,changePasswordFragment);
        fragmentTransaction.commit();
    }
}
