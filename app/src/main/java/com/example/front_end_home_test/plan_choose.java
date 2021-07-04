package com.example.front_end_home_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class plan_choose extends AppCompatActivity {

    //플랜추천.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_choose);

        //플랜추천에 있는 'ai로 선별해주는 플랜'버튼을 누르면 pchoose_QnA_plan창으로 넘어감
        Button imageButton = findViewById(R.id.pch_button_plan);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pchoose_QnA_plan.class);
                startActivity(intent);
            }
        });

        //플랜추천에 있는 'ai의 정확한 인바디 분석'버튼을 누르면 pchoose_inbody창으로 넘어감
        imageButton = findViewById(R.id.pch_button_inbody);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pchoose_inbody_plan.class);
                startActivity(intent);
            }
        });

        //플랜추천에 있는 'ai의 정확한 인바디 분석'버튼을 누르면 pchoose_weight창으로 넘어감
        imageButton = findViewById(R.id.pch_button_weight);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pchoose_weight_plan.class);
                startActivity(intent);
            }
        });
    }

}