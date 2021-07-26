package com.example.HelluApp.MainFragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.HelluApp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class fragment_mypage extends Fragment {

    //firebase auth object 가져와서 선언 (필요한건진 모르겠는데 일단 써봄...)
    private FirebaseAuth firebaseAuth;

    //fragment_mypage 화면을 보여줌
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment 레이아웃에 프래그먼트 뿌리기 view 앞에 return 지움
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);
        //View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        //마이페이지에 무슨 이메일로 로그인했는지 보여줌(textviewUserEmail에 찍어줌)
        TextView textViewUserEmail = view.findViewById(R.id.textviewUserEmail);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewUserEmail.setText(user.getEmail()+"으로 로그인");

        //로그아웃 (일단 로그아웃 버튼을 연결하는 코드만 씀. 로그아웃 버튼이 눌리면, 로그아웃 기능이 실행되는거 해주면 돼 예린이 화이팅^-^!)
        Button logout_button = view.findViewById(R.id.logout_button);

        return view;
    }


    //fragment 생성할때 생긴 코드
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}