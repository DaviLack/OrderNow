package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ordernow.Adapters.ViewPagerAdapter;
import com.example.ordernow.Fragments.FragmentCall;
import com.example.ordernow.Fragments.FragmentContact;
import com.example.ordernow.Fragments.FragmentFav;
import com.example.ordernow.R;
import com.google.android.material.tabs.TabLayout;

public class Teste extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Adicionar Fragmentos aqui

        adapter.AddFragment(new FragmentCall(), "");
        adapter.AddFragment(new FragmentContact(), "");
        adapter.AddFragment(new FragmentFav(), "");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.food_iconbest);
        tabLayout.getTabAt(1).setIcon(R.drawable.drink_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.sobremesa_icon);




    }
}
