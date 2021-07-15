package com.example.front_end_home_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class daily_stamp extends AppCompatActivity {

    //하단 네비게이션
    private BottomNavigationView dBottomNV;

    //매일 인증.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_stamp);


        //하단 네비게이션 화면을 선택하면 실행됨
        dBottomNV = findViewById(R.id.daily_bottom_navigation);
        dBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());

                return true;
            }
        });

    }

    //BottomNavigation 화면 전환 ex) 카메라 아이콘 누르면 카메라창 열림
    private void BottomNavigate(int id) {

        if (id == R.id.daily_camera){
            Intent intent = new Intent(getApplicationContext(), daily_stamp_camera.class);
            startActivity(intent);
        } else if(id == R.id.daily_write){
            Intent intent = new Intent(getApplicationContext(), daily_stamp_write.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getApplicationContext(), daily_stamp_gallery.class);
            startActivity(intent);
        }
    }
}