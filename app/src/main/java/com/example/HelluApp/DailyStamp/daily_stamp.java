package com.example.HelluApp.DailyStamp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.HelluApp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class daily_stamp extends AppCompatActivity {

    //하단 네비게이션
    private BottomNavigationView dBottomNV;

    //매일 인증.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_stamp);

        RecyclerView recyclerView = findViewById(R.id.daily_recyclerview); //리사이클러뷰 연결
        /*recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //레이아웃 매니저와 리사이클러뷰 연결

        daily_stamp_write_noteAdapter adapter = new daily_stamp_write_noteAdapter(this, createItemList(),R.layout.daily_stamp_write_item);
        recyclerView.setAdapter(adapter); //어댑터와 연결*/



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
    /*private List<String> createItemList() {
        List<String> items = new ArrayList<>();
        for(int i=0; i<20; i++){
            items.add("아이템"+i); //아이템 19개만큼 추가
        }
        return items;
    } //위에서 쓴 createItemList()라는 메서드를 정의*/

}