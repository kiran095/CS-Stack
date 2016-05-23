package com.csstack.subjects;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.csstack.R;
import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;






/**
 * Created by nandhu on 5/5/16.
 */
public class PPFrag extends Fragment {

    //A view to hold unit list , each unit has 5 strings
    public View layout;
    public MaterialViewPager mViewPager;

    ArrayList<String> sub_titles;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        layout=(View) inflater.inflate(R.layout.subject_layout,container,false);
        mViewPager=(MaterialViewPager)layout.findViewById(R.id.materialViewPager);
        Toolbar mToolbar=mViewPager.getToolbar();
        if (mToolbar != null) {
            AppCompatActivity activity=(AppCompatActivity)getActivity();
            activity.setSupportActionBar(mToolbar);
            ActionBar actionBar=activity.getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);

        }

        final DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();

            }
        });

        PagerAdapter adapter = new CustomAdapter(getActivity());



        mViewPager.getViewPager().setAdapter(adapter);
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getPagerTitleStrip().setBottom(0);
        TextView textView=(TextView) layout.findViewById(R.id.logo_white);
        textView.setText(R.string.pp);

        return layout;



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private class CustomAdapter extends PagerAdapter {
        private  int NUM_OF_PAGES=5;

        private  Context mContext;
        @Override
        public int getCount() {
            return NUM_OF_PAGES;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Parcelable saveState() {
            return super.saveState();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View weblayout=LayoutInflater.from(mContext).inflate(R.layout.smaple,container,false);
            container.addView(weblayout);
            return  weblayout;




        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                return "Introduction";

            }
            if (position==1){
                return "Introduction";

            }
            if (position==2){
                return "Problem";

            }
            if (position==3){
                return "Knowledge";

            }
            if (position==4){
                return "Learning";

            }
            return  "    " ;

        }

        public CustomAdapter(Context mContext) {
            this.mContext = mContext;
        }
    }
}
