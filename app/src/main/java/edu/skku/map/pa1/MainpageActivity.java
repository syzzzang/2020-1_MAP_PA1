package edu.skku.map.pa1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainpageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ImageButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent getintent=getIntent();

        Toolbar tb=(Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView navigationView=(NavigationView)findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout, tb,R.string.app_name, R.string.app_name);
        drawerToggle.syncState();


        tabLayout=(TabLayout)findViewById(R.id.layout_tab);

        viewPager2=findViewById(R.id.view_pager);
        viewPager2.setAdapter(new ViewPagerAdapter(this));

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position){
                    case 0:{
                       tab.setText("PERSONAL");

                       break;
                    }
                    case 1:{
                        tab.setText("PUBLIC");
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();


        addbtn=findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent=new Intent(MainpageActivity.this, AddpostActivity.class);
                startActivity(sendIntent);
            }
        });


    }

//    @Override
//    public void onBackPressed() {
//        drawerLayout.closeDrawer(GravityCompat.START);
//    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.item_fullname:{
                Toast.makeText(this, "fullname 선택함", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item_birthday:{
                Toast.makeText(this,  "birthday 선택함", Toast.LENGTH_SHORT).show();
            }
            case R.id.item_email:{
                Toast.makeText(this, "email 선택함!!", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }


}
