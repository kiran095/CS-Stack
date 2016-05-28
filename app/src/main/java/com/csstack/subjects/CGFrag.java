
package com.csstack. subjects;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csstack.R;
import com.csstack.subjects.units.CGunits.CG1;
import com.csstack.subjects.units.CGunits.CG2;
import com.csstack.subjects.units.CGunits.CG3;
import com.csstack.subjects.units.CGunits.CG4;
import com.csstack.subjects.units.CGunits.CG5;
import com.csstack.subjects.units.pointsAdapter;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;


/**
 * Created by nandhu on 5/5/16.
 */
public class CGFrag extends Fragment {

    //A view to hold unit list , each unit has 5 strings
    public MaterialViewPager mViewPager;

    ArrayList<String> sub_titles;
    public View layout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("COM_CSTACK","Comptuer Graphcics");
        layout = (View) inflater.inflate(R.layout.subject_layout, container, false);


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

       // FragmentPagerAdapter adapter = new UnitAdapter(getChildFragmentManager());



        mViewPager.getViewPager().setAdapter(new CustomAdapter(getActivity()));
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getPagerTitleStrip().setBottom(0);
        TextView textView=(TextView) layout.findViewById(R.id.logo_white);
        textView.setText(R.string.cg);

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
   public class CustomAdapter extends PagerAdapter {
        private  int NUM_OF_PAGES=5;

        private  Context mContext;
        public View weblayout;
       public RecyclerView.Adapter mAdapter;
       public RecyclerView mRecyclerView;
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
        public Object instantiateItem(final ViewGroup container, int position) {
             weblayout=LayoutInflater.from(mContext).inflate(R.layout.smaple,container,false);
           mRecyclerView=(RecyclerView)weblayout.findViewById(R.id.rv);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            ArrayList<String> su=new ArrayList<>(5);
            su.add("hello");
            su.add("hi");
            su.add("what the fuck ");
            su.add("hello fuck");
            su.add("lofe is beautifl");
            su.add("its how you see it");su.add("i m the greatest");



            mRecyclerView.setAdapter(mAdapter);

            container.addView(weblayout);
          //  MaterialViewPagerHelper.registerRecyclerView(getActivity(),mRecyclerView,null);
            return weblayout;




        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                return "UNIT I";

            }
            if (position==1){
                return "UNIT II";

            }
            if (position==2){
                return "UNIT III";

            }
            if (position==3){
                return "UNIT IV";

            }
            if (position==4){
                return "UNIT V";

            }
            return  "    " ;

        }

        public CustomAdapter(Context mContext) {
            this.mContext = mContext;
        }
    }

  /** public class UnitAdapter extends FragmentPagerAdapter{
       public FragmentManager fragmentManager;
       public UnitAdapter(FragmentManager fm) {
           super(fm);
           fragmentManager=fm;
       }

       @Override
       public long getItemId(int position) {
           return UnitAdapter.POSITION_NONE;
       }

       @Override
       public Fragment getItem(int position) {
           switch (position){
               case 0:
                   return new CG1();

               case 1:
                   return  new CG2();

               case 2:
                   return  new CG3();


               case 3:
                   return  new CG4();

               case 4:
                   return  new CG5();

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
           //getChildFragmentManager().beginTransaction().detach(getChildFragmentManager().findFragmentById(container.getId())).commit();
           //  getChildFragmentManager().beginTransaction().remove()
        super.destroyItem(container,position,object);
           fragmentManager.beginTransaction().remove((Fragment)object).commit();
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
       */


}



