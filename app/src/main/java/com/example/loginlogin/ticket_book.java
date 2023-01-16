package com.example.loginlogin;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

//import com.google.android.material.tabs.TabLayout;

public class ticket_book extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView back;


    private ticket_bk_frag all_fg;
    private ticket_bk_frag2 year_fg;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_book);


        back = findViewById(R.id.img_back12);
        back.setOnClickListener(v -> onBackPressed());

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);

        createFragment();


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(all_fg);
        viewPagerAdapter.addFragment(year_fg);
        viewPager.setEnabled(false);
        viewPager.setAdapter(viewPagerAdapter);

        getResources().getFont(R.font.notosanskrmedium);
        tabLayout.addTab(tabLayout.newTab().setText("전체")) ;
        tabLayout.addTab(tabLayout.newTab().setText("연도별")) ;

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition() ;
                if(pos == 0){
                    viewPager.setCurrentItem(0);
                }else if(pos == 1){
                    viewPager.setCurrentItem(1);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {




            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            /// ... 코드 생략
        }) ;

    }




    private void createFragment(){
        all_fg = new ticket_bk_frag();
        year_fg = new ticket_bk_frag2();
    }


}