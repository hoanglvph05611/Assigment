package com.example.lvhco.assigment;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ManHinhChinh extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private FloatingActionButton fob;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        fob = findViewById(R.id.floating);
        fob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Toast.makeText(ManHinhChinh.this, "Thêm", Toast.LENGTH_SHORT).show();
            }
        });


        Toolbar toolbar = findViewById(R.id.toolBar1);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        //ToolBar
        toolbar=findViewById(R.id.toolBar1);
        setSupportActionBar(toolbar);
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable1);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitle("Khoan Thu");
//    }




        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                    new KhoanThuFragment()).commit();
            navigationView.setCheckedItem(R.id.itemKhoanThu);
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container, new KhoanThuFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.navigation_khoanthu:
                            selectedFragment = new KhoanThuFragment();
                            break;
                        case R.id.navigation_khoanchi:
                            selectedFragment = new KhoanChiFragment();
                            break;
                        case R.id.navigation_thongke:
                            selectedFragment = new ThongKeFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                drawerLayout.openDrawer(Gravity.START);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.itemKhoanThu:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                        new KhoanThuFragment()).commit();
                break;
            case R.id.itemKhoanChi:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                        new KhoanChiFragment()).commit();
                break;
            case R.id.itemThongKe:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                        new ThongKeFragment()).commit();
                break;
            case R.id.itemGioiThieu:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
//                        new KhoanThuFragment()).commit();
                Toast.makeText(this, "giới thiệu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemThoat:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Bạn có muốn thoát không");
                builder.setIcon(R.drawable.iconthoat);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_con,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.KhoaUngDung:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}