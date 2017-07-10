package ex.mcliam.materialtab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ex.mcliam.materialtab.fragment.Tab1Fragment;
import ex.mcliam.materialtab.fragment.Tab2Fragment;

/**
 * Created by McLiam on 2/19/2017.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    //nama tab
    String[] tittle = new String[]{
            "Tab 1", "Tab 2"
    };

    public TabFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    //method untuk mengatur tampilan tabnya
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = new Tab1Fragment()
                break;
            case 1 :
                fragment = new Tab2Fragment();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    public CharSequence getPageTittle(int position){
        return tittle[position];
    }

    public int getCount(){
        return tittle.length;
    }
}
