package com.example.jevodan.lesson7_pager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
//import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);

        /*
        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(5); // specify total count of indicators
        pageIndicatorView.setSelection(2);
        */

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);//кешированных неудаляемых фрагментов пейджера.
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        adapter.addfragment(PagerFragment.newInstance(Color.BLUE));
        adapter.addfragment(PagerFragment.newInstance(Color.GRAY));
        adapter.addfragment(PagerFragment.newInstance(Color.GREEN));
        adapter.addfragment(PagerFragment.newInstance(Color.MAGENTA));
        adapter.addfragment(PagerFragment.newInstance(Color.RED));
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new MyPageTransformer());


    //    tableLayout.findViewById(R.id.table); Не разобрался в чем ошибка.
   //     tableLayout.setupWithViewPager(viewPager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
