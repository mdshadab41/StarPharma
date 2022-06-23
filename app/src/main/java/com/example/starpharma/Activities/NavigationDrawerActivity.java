package com.example.starpharma.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.starpharma.Fragments.HelpSupportFragment;
import com.example.starpharma.Fragments.HomeFragment;
import com.example.starpharma.Fragments.LogOutFragment;
import com.example.starpharma.Fragments.MyOrderFragment;
import com.example.starpharma.Fragments.MyProfileFragment;
import com.example.starpharma.Fragments.OfferDiscountFragment;
import com.example.starpharma.Fragments.OrderTrackFragment;
import com.example.starpharma.Fragments.PinDropFragment;
import com.example.starpharma.Fragments.ShoppingCartFragment;
import com.example.starpharma.Fragments.UploadPrescriptionFragment;
import com.example.starpharma.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = findViewById(R.id.nav_toolbar);


        drawer = findViewById(R.id.drawer_layout);
        nav = findViewById(R.id.nav_view);


         toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
               R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        getSupportFragmentManager().beginTransaction().replace(R.id.btm_fragment_container, new UploadPrescriptionFragment()).commit();
        nav.setCheckedItem(R.id.nav_upload_prescription);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp = null;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_upload_prescription:
                        temp = new UploadPrescriptionFragment();
                        Toast.makeText(NavigationDrawerActivity.this, "hbbhb", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.nav_shopping_cart:
                        temp = new MyOrderFragment();
                        break;
                    case R.id.nav_profile:
                        temp = new MyProfileFragment();
                        break;
                    case R.id.nav_offers_discounts:
                        temp = new OfferDiscountFragment();
                        break;

                    case R.id.nav_help_support:
                        temp = new HelpSupportFragment();
                        break;

                    case R.id.nav_logout:
                        temp = new LogOutFragment();
                        break;
                }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, temp).commit();
                    drawer.closeDrawer(GravityCompat.START);


                return true;
            }
        });



           //------------------Bottom navigation Start here-------------------------------
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // When we open the application first
        // time the fragment should be shown to the user
        // in this case it is home fragment
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.btm_fragment_container, fragment, "");
        fragmentTransaction.commit();

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