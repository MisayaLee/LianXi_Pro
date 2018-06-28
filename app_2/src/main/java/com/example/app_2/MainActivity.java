package com.example.app_2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.app_2.Fragment.List_ViewFragment;
import com.example.app_2.Fragment.MyFragment;
import com.example.app_2.Fragment.ServiceFragment;
import com.example.app_2.Fragment.WebFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_pager;
    List<String>titles = new ArrayList<>();
    List<Fragment>fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //四个标题“下载”，“列表”，“服务”，“我的”
        titles.add("下载");
        titles.add("列表");
        titles.add("服务");
        titles.add("我的");
        //四个Fragment
        fragmentList.add(new WebFragment());
        fragmentList.add(new List_ViewFragment());
        fragmentList.add(new ServiceFragment());
        fragmentList.add(new MyFragment());

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        view_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(view_pager);
    }

    private void initView() {
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
