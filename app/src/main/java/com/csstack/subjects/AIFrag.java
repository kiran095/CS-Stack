package com.csstack.subjects;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
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
import com.csstack.subjects.units.AIunit1Fragment;
import com.csstack.subjects.units.Aiunit2Fragment;
import com.csstack.subjects.units.Aiunit3Fragment;
import com.csstack.subjects.units.Aiunit4Fragment;
import com.csstack.subjects.units.Aiunit5Fragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

/**
 * Created by nandhu on 5/5/16.
 */
public class AIFrag extends Fragment{
    //A view to hold unit list , each unit has 5 strings
    public View layout;



    public MaterialViewPager mViewPager;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ObservableScrollView scrollView;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


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

            }
            else{
               Log.d("COM_CSTACK","Action bar null");
            }

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

            PagerAdapter adapter = new UnitAdapter(getFragmentManager());



        mViewPager.getViewPager().setAdapter(adapter);
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getPagerTitleStrip().setBottom(0);
        TextView textView=(TextView) layout.findViewById(R.id.logo_white);
        textView.setText(R.string.ai);

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





   /** private class CustomAdapter extends PagerAdapter {
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
            Log.d("COM_CSTACK","INStantiateing item");
            weblayout=LayoutInflater.from(mContext).inflate(R.layout.smaple,container,false);
       //     ObservableScrollView scrollView=(ObservableScrollView)weblayout.findViewById(R.id.scrollView);
            MaterialViewPagerHelper.registerScrollView(getActivity(),scrollView,null);
            container.addView(weblayout);

            return weblayout;


        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                Log.d("COM_CSTACK","Introduction returned");
                return "UNIT I";

            }
            if (position==1){
                return "Machine learning";

            }
            if (position==2){
                return "Knapsack problem";

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

        */

    public class UnitAdapter extends FragmentStatePagerAdapter{
        public UnitAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new AIunit1Fragment();

                case 1:
                    return  new Aiunit2Fragment();

                case 2:
                    return  new Aiunit3Fragment();


                case 3:
                    return  new Aiunit4Fragment();

                case 4:
                    return  new Aiunit5Fragment();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "UNIT I";

                case 1:return "UNIT II";

                case 2:
                    return "UNIT III";

                case 3:return "UNIT IV";

                case  4:
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
            super.destroyItem(container, position, object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
            super.restoreState(state, loader);
        }

        @Override
        public Parcelable saveState() {
            return super.saveState();
        }
    }

}
