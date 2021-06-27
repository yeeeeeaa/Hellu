package com.example.front_end_home_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
/*
        //매일 인증 화면에서 하단 네비게이션의 카메라 버튼을 누르면 카메라 창으로 넘어가는 코드
        Button imageButton = findViewById(R.id.daily_camera);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), daily_stamp_camera.class);
                startActivity(intent);
            }
        });*/

        //하단 네비게이션 화면 선택하면 눌리는 함수
        dBottomNV = findViewById(R.id.daily_bottom_navigation);
        dBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());
                //activity 가져오기
                //Intent intent = new Intent(getApplicationContext(), daily_stamp_camera.class);
                //startActivity(intent);

                return true;
            }
        });
        //dBottomNV.setSelectedItemId(R.id.home);

    }
    //BottomNavigation 페이지 변경
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