package com.example.front_end_home_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    public static Activity firstActivity;

    @Override
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

        firstActivity = login.this;

    }
}