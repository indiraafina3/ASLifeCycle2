package com.codepolitan.myapplicationviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codepolitan.myapplicationviewpager.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            //inisialisasi atribut viewpager
        viewPager = findViewById(R.id.container);
            tabLayout = findViewById(R.id.tab_layout);


        final int[] ICON = new int[] {
                //android.R.drawable.ic_delete menggunakan icon yg sdh tersedia
                R.drawable.home,
                R.drawable.home,
                R.drawable.home,
        };

        //set Adapter
            viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
            tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(ICON[0]);
        tabLayout.getTabAt(1).setIcon(ICON[1]);
        tabLayout.getTabAt(2).setIcon(ICON[2]);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                break;
            case R.id.profile:
                break;
            case R.id.logout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

