package com.viethcn.shopbanhang;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import com.google.android.material.navigation.NavigationView;
import com.viethcn.shopbanhang.fragment.AboutFragment;
import com.viethcn.shopbanhang.fragment.ProductFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // anh xa
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navigationView);

        //setup toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        // set fragment mac dinh khi chay len
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.linearlayout , new ProductFragment())
                .commit();


        // nhan item navagative
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                if (menuItem.getItemId() == R.id.mQLSP){
                    fragment = new ProductFragment();
                } else if (menuItem.getItemId() == R.id.mGioiThieu) {
                    fragment = new AboutFragment();
                } else {
                    fragment = new ProductFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.linerLayout,fragment)
                        .commit();

                getSupportActionBar().setTitle(menuItem.getTitle());

                // nhan vo tat cai menu
                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });

    }
    // nhay menu ra
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}