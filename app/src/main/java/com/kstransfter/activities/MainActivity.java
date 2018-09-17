package com.kstransfter.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kstransfter.R;
import com.kstransfter.fragments.HomeFragment;
import com.kstransfter.utils.PoupUtils;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;
    private ImageView imgMenu;
    private NavigationView navigationView;
    private TextView txtDriver, txtBookingHistoy, txtSupport, txtTermAndCond, txtRegisterCar, txtRegisterDriver, txtLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        imgMenu = findViewById(R.id.imgMenu);
        //txtDriver,txtBookingHistoy,txtSupport,txtTermAndCond,txtRegisterCar,txtRegisterDriver,txtLogOut
        txtDriver = findViewById(R.id.txtDriver);
        txtBookingHistoy = findViewById(R.id.txtBookingHistoy);
        txtSupport = findViewById(R.id.txtSupport);
        txtTermAndCond = findViewById(R.id.txtTermAndCond);
        txtRegisterCar = findViewById(R.id.txtRegisterCar);
        txtRegisterDriver = findViewById(R.id.txtRegisterDriver);
        txtLogOut = findViewById(R.id.txtLogOut);
        txtDriver.setOnClickListener(this);
        txtBookingHistoy.setOnClickListener(this);
        txtSupport.setOnClickListener(this);
        txtTermAndCond.setOnClickListener(this);
        txtRegisterCar.setOnClickListener(this);
        txtRegisterDriver.setOnClickListener(this);
        txtLogOut.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        imgMenu.setOnClickListener(this);

        try {
            initial();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initial() {
        //Relace Fragment
        HomeFragment homeFragment = new HomeFragment();
        replaceFragmenr(homeFragment, homeFragment.getTag(), false);
    }

    private void openNavigation() {
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    private void closeNavigation() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //txtDriver,txtBookingHistoy,txtSupport,txtTermAndCond,txtRegisterCar,,txtLogOut
            case R.id.imgMenu:
                openNavigation();
                break;
            case R.id.txtDriver:
                closeNavigation();
                break;
            case R.id.txtBookingHistoy:
                closeNavigation();
                break;
            case R.id.txtSupport:
                closeNavigation();
                break;
            case R.id.txtTermAndCond:
                closeNavigation();
                break;
            case R.id.txtRegisterCar:
                closeNavigation();
                break;
            case R.id.txtLogOut:
                closeNavigation();
                PoupUtils.showConfirmationDailog(MainActivity.this, "Are You sure want exit from application ?",
                        yes -> {
                            Toast.makeText(MainActivity.this, "click yes", Toast.LENGTH_SHORT).show();
                        }, no -> {
                            Toast.makeText(MainActivity.this, "click no", Toast.LENGTH_SHORT).show();
                        });

                break;
            default:
                break;
        }
    }

}