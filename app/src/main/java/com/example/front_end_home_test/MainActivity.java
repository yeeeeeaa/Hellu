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
    }

}