package com.miraz.tvmaze.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.miraz.tvmaze.R;
import com.miraz.tvmaze.view.fragments.FavoriteFragment;
import com.miraz.tvmaze.view.fragments.ListShowsFragment;
import com.miraz.tvmaze.view.fragments.QueryFragment;
import com.miraz.tvmaze.view.fragments.QueryPersonFragment;
import com.miraz.tvmaze.view.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateFragment(new ListShowsFragment());
        BottomNavigationView nav = findViewById(R.id.bottom_navigation);
        nav.setOnNavigationItemSelectedListener(this);

    }

    private void inflateFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.page_1:
                inflateFragment(new ListShowsFragment());
                return true;
            case R.id.page_2:
                inflateFragment(new QueryFragment());
                return true;
            case R.id.page_3:
                inflateFragment(new QueryPersonFragment());
                return true;
            case R.id.page_4:
                //inflateFragment(new SettingsFragment());MyProfileActivity
                startActivity(new Intent(MainActivity.this, MyProfileActivity.class));
               // finish();

                return true;
            case R.id.page_5:
                inflateFragment(new FavoriteFragment());
                return true;
            default:
                return false;
        }
    }

}