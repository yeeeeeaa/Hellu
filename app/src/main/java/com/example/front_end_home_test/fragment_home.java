package com.example.front_end_home_test;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* 미안해요 은서의 버튼 능력을 상실했어요....정말 미안해요....
        //홈에 있는 매일 인증(daily_stamp)버튼을 누르면 매일 인증 화면으로 넘어감
        Button imageButton = findViewById(R.id.daily_stamp_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), daily_stamp.class);
                startActivity(intent);
            }
        });

        //홈에 있는 이벤트 인증(event_stamp)버튼을 누르면 이벤트 인증 화면으로 넘어감
        imageButton = findViewById(R.id.event_stamp_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), event_stamp.class);
                startActivity(intent);
            }
        });

        //홈에 있는 플랜 선택(plan_choose)버튼을 누르면 플랜 선택 화면으로 넘어감
        imageButton = findViewById(R.id.plan_choose_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), plan_choose.class);
                startActivity(intent);
            }
        });

        //홈에 있는 소통(community)버튼을 누르면 커뮤니티 화면으로 넘어감
        imageButton = findViewById(R.id.community_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), community.class);
                startActivity(intent);
            }
        });

        //홈에 있는 인바디 체크(inbody_check)버튼을 누르면 인바디 체크 화면으로 넘어감
        imageButton = findViewById(R.id.inbody_check_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), inbody_check.class);
                startActivity(intent);
            }
        });

        //홈에 있는 랭킹(ranking)버튼을 누르면 랭킹 화면으로 넘어감
        imageButton = findViewById(R.id.ranking_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ranking.class);
                startActivity(intent);
            }
        });

        //홈에 있는 걷기 운동(walking)버튼을 누르면 걷기 운동 화면으로 넘어감
        imageButton = findViewById(R.id.walking_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), walking.class);
                startActivity(intent);
            }
        });

        //홈에 있는 역대 기록(record)버튼을 누르면 역대 기록 화면으로 넘어감
        imageButton = findViewById(R.id.record_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), record.class);
                startActivity(intent);
            }
        });
         */
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}
