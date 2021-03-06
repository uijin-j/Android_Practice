package com.example.doitmission10;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.doitmission10.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentMenu1 fragment1;
    FragmentMenu2 fragment2;
    FragmentMenu3 fragment3;

    ViewPager pager;

    DrawerLayout drawer;
    Toolbar toolbar;

    BottomNavigationView bottomNavigation;
    private MenuItem prevBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment1 = new FragmentMenu1(); adapter.addItem(fragment1);
        fragment2 = new FragmentMenu2(); adapter.addItem(fragment2);
        fragment3 = new FragmentMenu3(); adapter.addItem(fragment3);

        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevBottomNavigation != null) {
                    prevBottomNavigation.setChecked(false);
                }
                prevBottomNavigation = bottomNavigation.getMenu().getItem(position);
                prevBottomNavigation.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "??? ?????? ??? ?????????", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(0);
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "??? ?????? ??? ?????????", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(1);
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "??? ?????? ??? ?????????", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(3);
                        return true;
                }

                return false;
            }
        });


    }

    @Override
    //????????? [BACK] ?????? ????????? ???
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //???????????? ????????? ???????????? ??????
            drawer.closeDrawer(GravityCompat.START); //???????????? ?????? ??????
        } else {
            super.onBackPressed();
        }
    }

    @Override
    //???????????? ????????? ???????????? ????????? ???
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_menu1) {
            Toast.makeText(this, "????????? ?????? ?????????.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(0);

        } else if (id == R.id.nav_menu2) {
            Toast.makeText(this, "????????? ?????? ?????????.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(1);
        } else if (id == R.id.nav_menu3) {
            Toast.makeText(this, "????????? ?????? ?????????.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(2);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>(); //?????????????????? ????????? ??????

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            //??????????????? ????????????
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            //??????????????? ????????????
            return items.get(position);
        }

        @Override
        public int getCount() {
            //??????????????? ?????? ??????
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //?????????????????? ??????
            return "????????? " + position;
        }
    }



}