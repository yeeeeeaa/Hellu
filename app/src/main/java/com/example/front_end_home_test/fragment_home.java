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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //홈에 있는 매일 인증(daily_stamp)버튼을 누르면 매일 인증 화면으로 넘어감
        Button imageButton = view.findViewById(R.id.daily_stamp_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), daily_stamp.class);
                startActivity(intent);
            }
        });


        //홈에 있는 플랜 선택(plan_choose)버튼을 누르면 플랜 선택 화면으로 넘어감
        imageButton = view.findViewById(R.id.plan_choose_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), plan_choose.class);
                startActivity(intent);
            }
        });

        //홈에 있는 소통(community)버튼을 누르면 커뮤니티 화면으로 넘어감
        imageButton = view.findViewById(R.id.community_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), community.class);
                startActivity(intent);
            }
        });

        //홈에 있는 인바디 체크(inbody_check)버튼을 누르면 인바디 체크 화면으로 넘어감
        imageButton = view.findViewById(R.id.inbody_check_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), inbody_check.class);
                startActivity(intent);
            }
        });


        //홈에 있는 걷기 운동(walking)버튼을 누르면 걷기 운동 화면으로 넘어감
        imageButton = view.findViewById(R.id.walking_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), walking.class);
                startActivity(intent);
            }
        });

        //홈에 있는 역대 기록(record)버튼을 누르면 역대 기록 화면으로 넘어감
        imageButton = view.findViewById(R.id.record_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), record.class);
                startActivity(intent);
            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}
