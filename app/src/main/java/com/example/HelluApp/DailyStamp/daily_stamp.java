package com.example.HelluApp.DailyStamp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.HelluApp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class daily_stamp extends AppCompatActivity {

    //하단 네비게이션
    private BottomNavigationView dBottomNV;

    //매일 인증.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_stamp);

        //리사이클러뷰 연결
        RecyclerView recyclerView = findViewById(R.id.daily_recyclerview);
        List items;
        items = new ArrayList();
        //임의로 글들을 매일 인증 글들을 띄워주는 반복문
        for(int i = 0; i <30; i++){
            daily_stamp_write_note note = new daily_stamp_write_note(i, "제목"+i,"내용"+i, "", "2021_07_0"+i);

            items.add(note);
        }

        //잘 모르지만 리사이클러뷰와 어뎁터를 연결시켜주나봅니다.
        recyclerView.setAdapter(new daily_stamp_write_noteAdapter(items));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



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
            // 네비게이션 바에서 갤러리를 누르면 바로 갤러리로 연동하는걸로 코드 수정함.
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 1);
            /*
            Intent intent = new Intent(getApplicationContext(), daily_stamp_gallery.class);
            startActivity(intent);
             */
        }
    }
}