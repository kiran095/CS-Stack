package com.csstack.subjects;

import android.app.Activity;
import android.app.FragmentManager;
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
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.csstack.R;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableWebView;

import java.util.ArrayList;






/**
 * Created by nandhu on 5/5/16.
 */
public class ComputerarchFragment extends Fragment {
    //A view to hold unit list , each unit has 5 strings

    public View layout;
    public MaterialViewPager mViewPager;
    ArrayList<String> sub_titles;
    ObservableScrollView scrollView;
    public  ObservableWebView mWebView;
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



        Log.d("COM_CSTACK","CA FRAGM");
        if (mToolbar != null) {
            Log.d("COM_CSTACK","true Toolbar");

           AppCompatActivity activity=((AppCompatActivity)getActivity());
                   activity.setSupportActionBar(mToolbar);
            ActionBar actionBar=activity.getSupportActionBar();
            if (actionBar==null){
                Log.d("COM_CSTACK","Action bar null");
            }
            else {
                Log.d("COM_CSTACK","ACtion bar not null");
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
            }


        }else {
            Log.d("COM_CSTACK","Toolar null");
        }

        final DrawerLayout drawerLayout=(DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
            actionBarDrawerToggle =new ActionBarDrawerToggle(getActivity(),drawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
            actionBarDrawerToggle.syncState();

            }
        });



        PagerAdapter adapter=new CustomAdapter(getActivity());
        mViewPager.getViewPager().setOffscreenPageLimit(3);



        mViewPager.getViewPager().setAdapter(adapter );
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.setBottom(0);
        TextView textView=(TextView) layout.findViewById(R.id.logo_white);
        if (textView==null){
            Log.d("COM_CSTACK","TEct view is null");
        }
        else {
            Log.d("COM_CSTACK","textview not null");
            textView.setText(R.string.ca);
        }

     //  scrollView=(ObservableScrollView)layout.findViewById(R.id.scrool_view);

        sub_titles=new ArrayList<>(5);
        sub_titles.add("Fundamentals of Computer System");
        sub_titles.add("Basic Processing unit");
        sub_titles.add("ILP & Current Trendss");
        sub_titles.add("Arthmetic for Computer");
        sub_titles.add("Memory");
        sub_titles.add("I/O");

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
       super.onViewCreated(view,savedInstanceState);
    //    ObservableScrollView observableScrollView =(ObservableWebView)layout.findViewById(R.id.scrollView);

    //    MaterialViewPagerHelper.registerWebView(getActivity(),mWebView,null);*/
     //   MaterialViewPagerHelper.registerScrollView(getActivity(),scrollView,null);
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
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onStop() {
        super.onStop();
    }



    private class CustomAdapter extends PagerAdapter {
        private  int NUM_OF_PAGES=5;

        private  Context mContext;
        public View weblayout;


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
           container.removeView((View)object);
        }

        @Override
        public Parcelable saveState() {
            return super.saveState();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            weblayout=LayoutInflater.from(mContext).inflate(R.layout.smaple,container,false);

            ObservableScrollView ob=(ObservableScrollView)weblayout.findViewById(R.id.scrollView);
            MaterialViewPagerHelper.registerScrollView(getActivity(),ob,null);
            container.addView(weblayout);

             return weblayout;


        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                Log.d("COM_CSTACK","Introduction returned");
                return "Introduction";

            }
            if (position==1){
                return "COMPUTERARCH";

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

        public CustomAdapter(Context fm) {
          mContext=fm;
            Log.d("COM_CSTACK","Custom ADapter");
        }
    }

    }
