package com.example.front_end_home_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pchoose_QnA_plan extends AppCompatActivity {

    //플랜추천 화면에서 'ai로 선별해주는 플랜' 버튼을 누르면 나오는 QnA 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pchoose__qn_a_plan);


        Button imageButton = findViewById(R.id.pch_qn_a_result_button);
        imageButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), pchoose_QnA_plan_result.class);
                    startActivity(intent);
            }
        });
    }

}