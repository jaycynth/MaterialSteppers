package com.example.materialsteppers;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private Fragment mVerticalStepperFragment = new vertical_stepper();
    private Fragment mVerticalStepperAdapterFragment = new vertical_stepper_adapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            replaceFragment(mVerticalStepperFragment);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
                    mDrawerLayout.closeDrawer(mNavigationView);
                } else {
                    mDrawerLayout.openDrawer(mNavigationView);
                }
                return true;
            default:
                return false;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        mDrawerLayout.closeDrawer(mNavigationView);
        switch (item.getItemId()) {
            case R.id.item_vertical_stepper:
                replaceFragment(mVerticalStepperFragment);
                return true;
            case R.id.item_vertical_stepper_adapter:
                replaceFragment(mVerticalStepperAdapterFragment);
                return true;
            case R.id.action_fork_on_github:
                openWebsite();
                return true;
            default:
                return false;
        }
    }

        private void replaceFragment(Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

    private void openWebsite() {
        Toast.makeText(this, "https://github.com/jaycynth/MaterialSteppers", Toast.LENGTH_SHORT).show();
    }

}
