package ex.mcliam.antrianq;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by McLiam on 11/20/2016.
 */

public class MenuUtama extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //homeenables belum di buat


        Intent i = this.getIntent();

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
            getSupportFragmentManager().findFragmentById(R.id.fragment_nav_drawer);

        drawerFragment.setUp(R.id.fragment_nav_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), toolbar);

    }
}
