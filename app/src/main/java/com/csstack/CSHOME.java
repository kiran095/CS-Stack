package com.csstack;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.csstack.subjects.AIFrag;
import com.csstack.subjects.CGFrag;
import com.csstack.subjects.CNFrag;
import com.csstack.subjects.ComputerarchFragment;
import com.csstack.subjects.CplusFragment;
import com.csstack.subjects.DaaFrag;
import com.csstack.subjects.DatastructresFrag;
import com.csstack.subjects.DbmsFrag;
import com.csstack.subjects.FlatFrag;
import com.csstack.subjects.JavaFrag;
import com.csstack.subjects.MPFrag;
import com.csstack.subjects.MobileFrag;
import com.csstack.subjects.OSFrag;
import com.csstack.subjects.OoadFrag;
import com.csstack.subjects.PCDFrag;
import com.csstack.subjects.POMFrag;
import com.csstack.subjects.PPFrag;
import com.csstack.subjects.Parallel;
import com.csstack.subjects.SEFrag;
import com.csstack.subjects.SSFrag;
import com.csstack.subjects.SecurityFrag;
import com.csstack.subjects.computingtechniqueFragment;
import com.csstack.subjects.prinicplesofCEFragment;

public class CSHOME extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {


    NavigationView left_side;
    ActionBarDrawerToggle toggle;
    NavigationView right_side;
    boolean left_click = false;
    boolean right_click = false;
    public Toolbar toolbar;
    DrawerLayout mDrawer;
    android.support.v4.app.Fragment subjectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cshome);
        subjectFragment = null;
        setTitle("");


        //toolbar = mViewPager.getToolbar();
        /**mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

         if (toolbar != null) {
         setSupportActionBar(toolbar);

         final ActionBar actionBar = getSupportActionBar();
         if (actionBar != null) {
         actionBar.setDisplayHomeAsUpEnabled(true);
         actionBar.setDisplayShowHomeEnabled(true);
         actionBar.setDisplayShowTitleEnabled(true);
         actionBar.setDisplayUseLogoEnabled(false);
         actionBar.setHomeButtonEnabled(true);
         }
         }

         toggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
         mDrawer.setDrawerListener(toggle);
         */


        left_side = (NavigationView) findViewById(R.id.left_drawer);
        right_side = (NavigationView) findViewById(R.id.right_drawer);
        right_side.setNavigationItemSelectedListener(this);
        left_side.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //  toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cshome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()){


        case R.id.first:
            // Handle the camera action
            left_click = true;
            right_side.getMenu().clear();
            right_side.inflateMenu(R.menu.first_year);
        break;


        case R.id.second:
            left_click = true;
            right_side.getMenu().clear();
            right_side.inflateMenu(R.menu.second_year);
            break;
            case  R.id.third:
            left_click = true;
            right_side.getMenu().clear();
            right_side.inflateMenu(R.menu.third_year);
                break;
            case  R.id.fourth:
            left_click = true;
            right_side.getMenu().clear();
            right_side.inflateMenu(R.menu.fourth_year);
                break;
            case R.id.nav_share:
            left_click = true;
                break;

            case  R.id.nav_send:
            left_click = true;
                break;


        //Right side click events

            case R.id.cp:
            right_click = true;
            Log.d("COM_CSTACK", "CP CLICKED");
            subjectFragment = new computingtechniqueFragment();
                break;

            case  R.id.pcp:
            right_click = true;
            subjectFragment = new prinicplesofCEFragment();
                break;
            case  R.id.cplus:
            right_click = true;
            subjectFragment = new CplusFragment();
                break;
            case R.id.ca:
            right_click = true;
            subjectFragment = new ComputerarchFragment();
                break;
            case  R.id.ds:
            right_click = true;
            subjectFragment = new DatastructresFrag();
                break;
            case R.id.dbms:
            right_click = true;
            subjectFragment = new DbmsFrag();
                break;
            case R.id.daa:
            right_click = true;
            subjectFragment = new DaaFrag();
            case R.id.jip:
            right_click = true;
            subjectFragment = new JavaFrag();
                break;
            case  R.id.os:
            right_click = true;
            subjectFragment = new OSFrag();
                break;
            case R.id.se:
            right_click = true;
            subjectFragment = new SEFrag();
                break;
            case R.id.cn:
            right_click = true;
            subjectFragment = new CNFrag();
                break;
            case  R.id.mp:
            right_click = true;
            subjectFragment = new MPFrag();
                break;
            case  R.id.ss:
            right_click = true;
            subjectFragment = new SSFrag();
                break;
            case R.id.flat:
            right_click = true;
            subjectFragment = new FlatFrag();
                break;
            case  R.id.ooad:
            right_click = true;
            subjectFragment = new OoadFrag();
                break;
            case R.id.ai:
            right_click = true;
            subjectFragment = new AIFrag();break;
            case R.id.pcd:
            right_click = true;

            subjectFragment = new PCDFrag();
                break;
            case  R.id.cg:
            right_click = true;
            subjectFragment = new CGFrag();
                break;
            case  R.id.paradigms:
            right_click = true;
            subjectFragment = new PPFrag();
          break;
            case  R.id.pom:
            right_click = true;
            subjectFragment = new POMFrag();
                break;
            case  R.id.mobile:
                right_click = true;
                subjectFragment = new MobileFrag();
                break;

        case R.id.parallel:
                right_click = true;
                subjectFragment = new Parallel();
            break;
            case R.id.security:
                right_click = true;
                subjectFragment = new SecurityFrag();
                break;
            default:
                return true;
            }


            if (right_click) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                Log.d("COM_CSTACK", "inside if");
                drawer.closeDrawer(GravityCompat.END);
             //       subjectFragment=new TestFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_holder, subjectFragment)
                        .commit();
               right_click=false;

            }


            if (left_click) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                drawer.openDrawer(GravityCompat.END);
                left_click = false;
            }


            return true;
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("COM_CSTACK","Save instance state");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("COM_CSTACK","Restore Instance state");
    }
}

