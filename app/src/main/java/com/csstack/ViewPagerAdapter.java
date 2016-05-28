package com.csstack;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.csstack.subjects.units.AIunits.AIunit1Fragment;
import com.csstack.subjects.units.AIunits.Aiunit2Fragment;
import com.csstack.subjects.units.AIunits.Aiunit3Fragment;
import com.csstack.subjects.units.AIunits.Aiunit4Fragment;
import com.csstack.subjects.units.AIunits.Aiunit5Fragment;

/**
 * Created by nandhu on 27/5/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public static FragmentManager mchildFragmentmanager;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mchildFragmentmanager = fm;
    }




    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AIunit1Fragment();

            case 1:
                return new Aiunit2Fragment();

            case 2:
                return new Aiunit3Fragment();


            case 3:
                return new Aiunit4Fragment();

            case 4:
                return new Aiunit5Fragment();

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
