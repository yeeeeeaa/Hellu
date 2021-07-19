package com.example.front_end_home_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pchoose_QnA_plan extends AppCompatActivity {

    //플랜추천 화면에서 'ai로 선별해주는 플랜' 버튼을 누르면 나오는 QnA 화면
    String numberOfWeekOfExercise = "";
    String exerciseIntensity = "";
    String normalActivity = "";
    String amountOfExercise = "";
    List<String> mealTime = new ArrayList<>();
    String purposeOfExercise = "";

    Button btn;

    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_pchoose__qn_a_plan);

        btn = findViewById(R.id.pch_qn_a_result_button);

        btn.setOnClickListener(v -> {
            Checked();

            //바뀐 코드
            HashMap<String, Object> Plan_result = new HashMap<>();
            Plan_result.put("운동 주 횟수", numberOfWeekOfExercise);
            Plan_result.put("하루 목표 운동량", amountOfExercise);
            Plan_result.put("운동 강도", exerciseIntensity);
            Plan_result.put("평소 활동량", normalActivity);
            Plan_result.put("식사 시간", mealTime);
            Plan_result.put("운동 목적", purposeOfExercise);

            databaseReference.child("User_Plan").push().setValue(Plan_result);

            Intent intent = new Intent(getApplicationContext(), pchoose_QnA_plan_result.class);
            startActivity(intent);
        });
    }

    public void Checked() {
        // 1. 운동 주 횟수(단일 선택)
        RadioButton option11 = findViewById(R.id.q1_radio_Button1);
        RadioButton option12 = findViewById(R.id.q1_radio_Button2);
        RadioButton option13 = findViewById(R.id.q1_radio_Button3);
        RadioButton option14 = findViewById(R.id.q1_radio_Button4);
        RadioButton option15 = findViewById(R.id.q1_radio_Button5);
        RadioButton option16 = findViewById(R.id.q1_radio_Button6);

        // 2. 하루 목표 운동량(단일 선택)
        RadioButton option21 = findViewById(R.id.q2_radio_Button1);
        RadioButton option22 = findViewById(R.id.q2_radio_Button2);
        RadioButton option23 = findViewById(R.id.q2_radio_Button3);
        RadioButton option24 = findViewById(R.id.q2_radio_Button4);

        // 3. 운동 강도(단일 선택)
        RadioButton option31 = findViewById(R.id.q3_radio_Button1);
        RadioButton option32 = findViewById(R.id.q3_radio_Button2);
        RadioButton option33 = findViewById(R.id.q3_radio_Button3);
        RadioButton option34 = findViewById(R.id.q3_radio_Button4);
        RadioButton option35 = findViewById(R.id.q3_radio_Button5);

        // 4. 평소 활동량(단일 선택)
        RadioButton option41 = findViewById(R.id.q4_radio_Button1);
        RadioButton option42 = findViewById(R.id.q4_radio_Button2);
        RadioButton option43 = findViewById(R.id.q4_radio_Button3);
        RadioButton option44 = findViewById(R.id.q4_radio_Button4);
        RadioButton option45 = findViewById(R.id.q4_radio_Button5);

        // 5. 식사 시간(다중 선택)
        CheckBox option51 = findViewById(R.id.q5_radio_Button1);
        CheckBox option52 = findViewById(R.id.q5_radio_Button2);
        CheckBox option53 = findViewById(R.id.q5_radio_Button3);
        CheckBox option54 = findViewById(R.id.q5_radio_Button4);
        CheckBox option55 = findViewById(R.id.q5_radio_Button5);
        CheckBox option56 = findViewById(R.id.q5_radio_Button6);

        // 6. 운동 목적(단일 선택)
        RadioButton option61 = findViewById(R.id.q6_radio_Button1);
        RadioButton option62 = findViewById(R.id.q6_radio_Button2);
        RadioButton option63 = findViewById(R.id.q6_radio_Button3);
        RadioButton option64 = findViewById(R.id.q6_radio_Button4);
        RadioButton option65 = findViewById(R.id.q6_radio_Button5);

        // 1. 운동 주 횟수
        if (option11.isChecked()) {
            numberOfWeekOfExercise = "1~2일";
        } else if (option12.isChecked()) {
            numberOfWeekOfExercise = "2~3일";
        } else if (option13.isChecked()) {
            numberOfWeekOfExercise = "3~4일";
        } else if (option14.isChecked()) {
            numberOfWeekOfExercise = "4~5일";
        } else if (option15.isChecked()) {
            numberOfWeekOfExercise = "5~6일";
        } else if (option16.isChecked()) {
            numberOfWeekOfExercise = "6~7일";
        }

        // 2. 하루 목표 운동량(단일 선택)
        if (option21.isChecked()) {
            amountOfExercise = "30분 미만";
        } else if (option22.isChecked()) {
            amountOfExercise = "30분~1시간";
        } else if (option23.isChecked()) {
            amountOfExercise = "1시간~2시간";
        } else if (option24.isChecked()) {
            amountOfExercise = "2시간 이상";
        }

        // 3. 운동 강도
        if (option31.isChecked()) {
            exerciseIntensity = "아주 가볍게";
        } else if (option32.isChecked()) {
            exerciseIntensity = "조금 가볍게";
        } else if (option33.isChecked()) {
            exerciseIntensity = "보통";
        } else if (option34.isChecked()) {
            exerciseIntensity = "조금 강하게";
        } else if (option35.isChecked()) {
            exerciseIntensity = "아주 강하게";
        }

        // 4. 평소 활동량
        if (option41.isChecked()) {
            normalActivity = "운동을 하지 않는다.";
        } else if (option42.isChecked()) {
            normalActivity = "30분";
        } else if (option43.isChecked()) {
            normalActivity = "1시간";
        } else if (option44.isChecked()) {
            normalActivity = "2시간";
        } else if (option45.isChecked()) {
            normalActivity = "3시간 이상";
        }

        // 5. 식사 시간
        if (option51.isChecked()) {
            mealTime.add("아침");
        }
        if (option52.isChecked()) {
            mealTime.add("늦은 아침");
        }
        if (option53.isChecked()) {
            mealTime.add("점심");
        }
        if (option54.isChecked()) {
            mealTime.add("늦은 점심");
        }
        if (option55.isChecked()) {
            mealTime.add("저녁");
        }
        if (option56.isChecked()) {
            mealTime.add("늦은 저녁");
        }

        // 6. 운동 목적
        if (option61.isChecked()) {
            purposeOfExercise = "건강";
        } else if (option62.isChecked()) {
            purposeOfExercise = "다이어트";
        } else if (option63.isChecked()) {
            purposeOfExercise = "균형";
        } else if (option64.isChecked()) {
            purposeOfExercise = "스트레스 해소";
        } else if (option65.isChecked()) {
            purposeOfExercise = "체력 단련";
        }
    }

}