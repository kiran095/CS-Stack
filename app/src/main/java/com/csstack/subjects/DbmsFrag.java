package com.csstack.subjects;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.csstack.subjects.units.DBMSunits.DBMS1;
import com.csstack.subjects.units.DBMSunits.DBMS2;
import com.csstack.subjects.units.DBMSunits.DBMS3;
import com.csstack.subjects.units.DBMSunits.DBMS4;
import com.csstack.subjects.units.DBMSunits.DBMS5;
import com.github.florent37.materialviewpager.MaterialViewPager;

;
;




/**
 * Created by nandhu on 5/5/16.
 */
public class DbmsFrag extends Fragment {
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
        textView.setText(R.string.dbms);

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
    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public FragmentManager mchildFragmentmanager;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            mchildFragmentmanager = fm;
        }




        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DBMS1();

                case 1:
                    return new DBMS2();

                case 2:
                    return new DBMS3();


                case 3:
                    return new DBMS4();

                case 4:
                    return new DBMS5();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "UNIT I";

                case 1:
                    return "UNIT II";

                case 2:
                    return "UNIT III";

                case 3:
                    return "UNIT IV";

                case 4:
                    return "UNIT V";

            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //getChildFragmentManager().beginTransaction().detach(getChildFragmentManager().findFragmentById(container.getId())).commit();
            //  getChildFragmentManager().beginTransaction().remove(

            //  mchildFragmentmanager.beginTransaction().remove((Fragment) object).commit();

        }


    }



}
