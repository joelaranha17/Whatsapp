package com.firstapp.joel.Whatsapp_fake;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

     TabLayout tabLayout;             //this is the tablayout
     private ViewPager viewPager;             //this is the viewpager

//---------------------------------------------------------------------------------------------------------------------
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

//-----------------------------------------------------------------------------------------------------------------------
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//-----------------------------------Adding Toolbar to Activity----------------------------------------------------------
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
    setSupportActionBar(toolbar);

    final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout1);

    //Adding the tabs using addTab() method
    tabLayout.addTab(tabLayout.newTab().setText("Chats"));
    tabLayout.addTab(tabLayout.newTab().setText("Status"));
    tabLayout.addTab(tabLayout.newTab().setText("Calls"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    viewPager = (ViewPager) findViewById(R.id.pager);
    Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
    viewPager.setAdapter(adapter);
    tabLayout.setOnTabSelectedListener(this);

    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tabLayout.setScrollPosition(position, 0, true);
            tabLayout.setSelected(true);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
}
}


