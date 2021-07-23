package com.example.HelluApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    public static Activity loginActivity;

    @Override

    //activity_login 화면을 보여줌
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //로그인 버튼을 누르면 홈화면으로 이동 (로그인 기능 들어오면 해야할것: 로그인이 되어야 홈화면으로 가게 조건걸기)
        Button imageButton = findViewById(R.id.login_button);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //sign up 글씨를 누르면 회원가입 화면으로 이동
        TextView TextView = findViewById(R.id.to_sign_up);
        TextView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
            }
        });

        loginActivity = login.this;

    }
}