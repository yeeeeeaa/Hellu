package com.example.front_end_home_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //홈에 있는 매일 인증(daily_stamp)버튼을 누르면 매일 인증 화면으로 넘어감
        Button imageButton = findViewById(R.id.daily_stamp_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), daily_stamp.class);
                startActivity(intent);
            }
        });

        //홈에 있는 이벤트 인증(event_stamp)버튼을 누르면 이벤트 인증 화면으로 넘어감
        imageButton = findViewById(R.id.event_stamp_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), event_stamp.class);
                startActivity(intent);
            }
        });

        //홈에 있는 플랜 선택(plan_choose)버튼을 누르면 플랜 선택 화면으로 넘어감
        imageButton = findViewById(R.id.plan_choose_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), plan_choose.class);
                startActivity(intent);
            }
        });

        //홈에 있는 소통(community)버튼을 누르면 커뮤니티 화면으로 넘어감
        imageButton = findViewById(R.id.community_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), community.class);
                startActivity(intent);
            }
        });
        
        //홈에 있는 인바디 체크(inbody_check)버튼을 누르면 인바디 체크 화면으로 넘어감
        imageButton = findViewById(R.id.inbody_check_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), inbody_check.class);
                startActivity(intent);
            }
        });

        //홈에 있는 랭킹(ranking)버튼을 누르면 랭킹 화면으로 넘어감
        imageButton = findViewById(R.id.ranking_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ranking.class);
                startActivity(intent);
            }
        });

        //홈에 있는 걷기 운동(walking)버튼을 누르면 걷기 운동 화면으로 넘어감
        imageButton = findViewById(R.id.walking_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), walking.class);
                startActivity(intent);
            }
        });

        //홈에 있는 역대 기록(record)버튼을 누르면 역대 기록 화면으로 넘어감
        imageButton = findViewById(R.id.record_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), record.class);
                startActivity(intent);
            }
        });
    }

}