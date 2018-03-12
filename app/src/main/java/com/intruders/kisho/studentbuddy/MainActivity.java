package com.intruders.kisho.studentbuddy;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.view.MenuItem;

import com.intruders.kisho.studentbuddy.Fragment.ForumFragment;
import com.intruders.kisho.studentbuddy.Fragment.FriendsFragment;
import com.intruders.kisho.studentbuddy.Fragment.HomeFragment;
import com.intruders.kisho.studentbuddy.Fragment.NearbyFragment;
import com.intruders.kisho.studentbuddy.Fragment.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    MenuItem prevMenuItem;
    FragmentTransaction ft;
    private String JSON_EVENT_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Transition ts = new Explode();
        ts.setDuration(5000);
        getWindow().setEnterTransition(ts);
        getWindow().setExitTransition(ts);

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);


        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                switch (tabId) {
                    case R.id.tab_home:
                        // viewPager.setCurrentItem(0);
                        HomeFragment homeFragment = new HomeFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, homeFragment).commit();
                        break;
                    case R.id.tab_forum:
                        // viewPager.setCurrentItem(1);
                        ForumFragment forumFragment = new ForumFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, forumFragment).commit();

                        break;
                    case R.id.tab_nearby:
                        //  viewPager.setCurrentItem(2);
                        NearbyFragment nearbyFragment = new NearbyFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, nearbyFragment).commit();
                        break;
                    case R.id.tab_friends:
                        // viewPager.setCurrentItem(3);
                        FriendsFragment friendsFragment = new FriendsFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, friendsFragment).commit();

                        break;
                    case R.id.tab_profile:
                        // viewPager.setCurrentItem(4);
                        ProfileFragment profileFragment = new ProfileFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, profileFragment).commit();

                        break;
                }

            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
            }
        });


    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
