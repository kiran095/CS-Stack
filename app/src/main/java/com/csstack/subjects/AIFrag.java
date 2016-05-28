package com.csstack.subjects;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csstack.R;
import com.csstack.ViewPagerAdapter;
import com.csstack.subjects.units.AIunits.AIunit1Fragment;
import com.csstack.subjects.units.AIunits.Aiunit2Fragment;
import com.csstack.subjects.units.AIunits.Aiunit3Fragment;
import com.csstack.subjects.units.AIunits.Aiunit4Fragment;
import com.csstack.subjects.units.AIunits.Aiunit5Fragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

/**
 * Created by nandhu on 5/5/16.
 */
public class AIFrag extends Fragment {
    //A view to hold unit list , each unit has 5 strings
    public View layout;
    public String CURRENT_PAGE="current_page";


    public MaterialViewPager mViewPager;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentStatePagerAdapter adapter;
    public int cPage;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Log.d("COM_CSTACK", "--->on Create view AI");

        layout = (View) inflater.inflate(R.layout.subject_layout, container, false);
        mViewPager = (MaterialViewPager) layout.findViewById(R.id.materialViewPager);
        Toolbar mToolbar = mViewPager.getToolbar();
        if (mToolbar != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(mToolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);

            } else {
                Log.d("COM_CSTACK", "Action bar null");
            }

        }


        //Action bar and title hamburger icon set up--cannot be done in activity

        final DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();

            }
        });

        //Adapter for View pager



       adapter = new ViewPagerAdapter(this.getChildFragmentManager());


        mViewPager.getViewPager().setAdapter(adapter);
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getPagerTitleStrip().setBottom(0);

        // tilte Customisation in header- view pager
        TextView textView = (TextView) layout.findViewById(R.id.logo_white);
        textView.setText(R.string.ai);

        return layout;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //we have a save instance state

        if (savedInstanceState!=null){
            Log.d("COM_CSTACK", "SAved instance exits");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
         cPage=mViewPager.getViewPager().getCurrentItem();
        outState.putInt(CURRENT_PAGE,cPage);
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


    /**
     * private class CustomAdapter extends PagerAdapter {
     * private  int NUM_OF_PAGES=5;
     * <p/>
     * private  Context mContext;
     * public View weblayout;
     *
     * @Override public int getCount() {
     * return NUM_OF_PAGES;
     * }
     * @Override public boolean isViewFromObject(View view, Object object) {
     * return view==object;
     * }
     * @Override public void destroyItem(ViewGroup container, int position, Object object) {
     * container.removeView((View)object);
     * }
     * @Override public Parcelable saveState() {
     * return super.saveState();
     * }
     * @Override public Object instantiateItem(ViewGroup container, int position) {
     * Log.d("COM_CSTACK","INStantiateing item");
     * weblayout=LayoutInflater.from(mContext).inflate(R.layout.smaple,container,false);
     * //     ObservableScrollView scrollView=(ObservableScrollView)weblayout.findViewById(R.id.scrollView);
     * MaterialViewPagerHelper.registerScrollView(getActivity(),scrollView,null);
     * container.addView(weblayout);
     * <p/>
     * return weblayout;
     * <p/>
     * <p/>
     * }
     * @Override public CharSequence getPageTitle(int position) {
     * if (position==0){
     * Log.d("COM_CSTACK","Introduction returned");
     * return "UNIT I";
     * <p/>
     * }
     * if (position==1){
     * return "Machine learning";
     * <p/>
     * }
     * if (position==2){
     * return "Knapsack problem";
     * <p/>
     * }
     * if (position==3){
     * return "Knowledge";
     * <p/>
     * }
     * if (position==4){
     * return "Learning";
     * <p/>
     * }
     * return  "    " ;
     * <p/>
     * }
     * <p/>
     * public CustomAdapter(Context fm) {
     * mContext=fm;
     * Log.d("COM_CSTACK","Custom ADapter");
     * }
     * }
     */




}
