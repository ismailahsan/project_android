package ex.mcliam.bni_qs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ex.mcliam.bni_qs.fragment.Fragment_antrian;
import ex.mcliam.bni_qs.fragment.Fragment_info;

/**
 * Created by McLiam on 2/19/2017.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    //nama tab
    String[] tittle = new String[]{
            "Antrian", "Info Layanan"
    };

    public TabFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    //method untuk mengatur tampilan tabnya
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = new Fragment_antrian();
                break;
            case 1 :
                fragment = new Fragment_info();
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
