package com.example.loginlogin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> fragmentList = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);              //화면의 실제 frgament 반환
    }

    @Override
    public int getCount() {
        return fragmentList.size();                     //page수
    }



    public void addFragment (Fragment fragment){
        fragmentList.add(fragment);                     //viewpage에 fragment 넣기
    }
}
