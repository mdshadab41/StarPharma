package com.example.starpharma.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.starpharma.Fragments.HomeFragment;
import com.example.starpharma.Fragments.OrderTrackFragment;
import com.example.starpharma.Fragments.PinDropFragment;
import com.example.starpharma.Fragments.ShoppingCartFragment;
import com.example.starpharma.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView  bottomNavigationView = findViewById(R.id.bottom_navigation);

            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {

                        case R.id.btm_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.btm_pin_drop:
                            selectedFragment = new PinDropFragment();
                            break;

                        case R.id.btm_shopping_cart:
                            selectedFragment = new ShoppingCartFragment();
                            break;
                        case R.id.btm_order_track:
                            selectedFragment = new OrderTrackFragment();
                            break;
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.btm_fragment_container, selectedFragment).commit();
                    }

                    return true;
                }

            });
        }
    }