package com.example.afinal;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.HomeFragment;
import com.example.afinal.MapsFragment;
import com.example.afinal.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    HomeFragment firstFragment = new HomeFragment();
    MapsFragment secondFragment = new MapsFragment();
    SettingsFragment thirdFragment = new SettingsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, firstFragment)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.maps) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, secondFragment)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.setting) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, thirdFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
