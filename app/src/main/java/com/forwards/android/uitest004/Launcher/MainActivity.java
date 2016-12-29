package com.forwards.android.uitest004.Launcher;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.forwards.android.uitest004.R;

import com.h6ah4i.android.tablayouthelper.TabLayoutHelper;

public class MainActivity extends AppCompatActivity {
    private static final String FRAGMENT_TAG_OPTIONS_MENU = "options menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);

        pager.setAdapter(new LauncherPagerAdapter(getSupportFragmentManager()));

        TabLayoutHelper tabLayoutHelper = new TabLayoutHelper(tabLayout, pager);
        tabLayoutHelper.setAutoAdjustTabModeEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new OptionsMenuFragment(), FRAGMENT_TAG_OPTIONS_MENU)
                    .commit();
        }
    }
}