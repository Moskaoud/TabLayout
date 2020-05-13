package com.moskaoud.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.main_tabLayout);
        viewPager = findViewById(R.id.main_pager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        Category food = new Category(1 ,"Food");
        Category drinks = new Category(2 ,"Drinks");
        Category desserts = new Category(3 ,"Desserts");
        Category others = new Category(4 ,"others");

        adapter.addTab(new MyTab(food,CategoryFragment.newInstance(1,"Food")));
        adapter.addTab(new MyTab(drinks,CategoryFragment.newInstance(2,"Drinks")));
        adapter.addTab(new MyTab(desserts,CategoryFragment.newInstance(3,"Desserts")));
        adapter.addTab(new MyTab(others,CategoryFragment.newInstance(4,"others")));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, R.string.selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, R.string.unselected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, R.string.reselected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
