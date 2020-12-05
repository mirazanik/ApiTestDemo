package com.miraz.tvmaze.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.miraz.tvmaze.R;
import com.miraz.tvmaze.model.database.SharedPrefConfig;

public class MyProfileActivity extends AppCompatActivity {
    TextView tvName, tvAddress, tvEmail;
    Button logoutButton;
    private SharedPrefConfig sharedPrefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        tvName = findViewById(R.id.dash_tv_nameID);
        tvAddress = findViewById(R.id.dash_tv_addressID);
        tvEmail = findViewById(R.id.dash_tv_emailID);
        logoutButton = findViewById(R.id.logout_buttonID);

        sharedPrefConfig = new SharedPrefConfig(getApplicationContext());
        SharedPreferences sharedPreferences=getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("sp_name","Data not found");
        String address = sharedPreferences.getString("sp_address","Data not found");
        String email = sharedPreferences.getString("sp_email","Data not found");

        tvName.setText(name);
        tvAddress.setText(address);
        tvEmail.setText(email);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefConfig.writeLoginStatus(false);
                startActivity(new Intent(MyProfileActivity.this, LoginActivityMain.class));
            }
        });

    }
}
