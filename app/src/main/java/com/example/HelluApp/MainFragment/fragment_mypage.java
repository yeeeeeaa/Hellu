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
import com.example.HelluApp.login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class fragment_mypage extends Fragment {

    //로그아웃 (일단 로그아웃 버튼을 연결하는 코드만 씀. 로그아웃 버튼이 눌리면, 로그아웃 기능이 실행되는거 해주면 돼 예린이 화이팅^-^!)
    Button logout_button;

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

        //로그아웃 버튼
        logout_button = (Button) view.findViewById(R.id.logout_button);

        //유저가 로그인 하지 않은 상태라면 null 상태이고 이 액티비티를 종료하고 로그인 액티비티를 연다.
        //유저가 있다면, null이 아니면 계속 진행
        if(firebaseAuth.getCurrentUser() == null) {
            getActivity().finish();
            Intent intent = new Intent(view.getContext(), login.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            view.getContext().startActivity(intent);
        }

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (view == logout_button) {
                    firebaseAuth.signOut();
                    getActivity().finish();
                    Intent intent = new Intent(view.getContext(), login.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);
                }
            }
        });

        return view;
    }

    //fragment 생성할때 생긴 코드
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}