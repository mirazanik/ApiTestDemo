package com.miraz.tvmaze.view.activities;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import com.miraz.tvmaze.R;
import com.miraz.tvmaze.model.entitites.UserInfo;
import com.miraz.tvmaze.model.interactors.UserViewModel;

public class RegActivity extends AppCompatActivity {
    CardView cardLogButon;
    ImageView submitButton;
    EditText etFName, etAddress, etEmail, etPassword;
    UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        cardLogButon = findViewById(R.id.register_goLogButton_ID);
        submitButton = findViewById(R.id.register_submitButton_ID);
        etFName = findViewById(R.id.reg_et_fName_ID);
        etAddress = findViewById(R.id.reg_et_address_ID);
        etEmail = findViewById(R.id.reg_et_email_ID);
        etPassword = findViewById(R.id.reg_et_password_ID);

        cardLogButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegActivity.this, LoginActivityMain.class));
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFName = etFName.getText().toString();
                String strAddress = etAddress.getText().toString();
                String strEmail = etEmail.getText().toString();
                String strPassword = etPassword.getText().toString();

                UserInfo userInfo = new UserInfo(strFName, strAddress, strEmail, strPassword);
                userViewModel.insertUserInfo(userInfo);

                etFName.setText("");
                etAddress.setText("");
                etEmail.setText("");
                etPassword.setText("");

                Toast.makeText(RegActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegActivity.this, LoginActivityMain.class));
            }
        });
    }
}
