package edu.skku.map.pa1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class AddpostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    Button create_post_btn;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        Intent getIntent=getIntent();

        checkBox=findViewById(R.id.box);
        checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.gillsans));
        Toolbar tb=(Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView navigationView=(NavigationView)findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout, tb,R.string.app_name, R.string.app_name);
        drawerToggle.syncState();

        create_post_btn=(Button)findViewById(R.id.create_post_btn);
        create_post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddpostActivity.this,MainpageActivity.class);
                startActivity(intent);
            }
        });


    }
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
