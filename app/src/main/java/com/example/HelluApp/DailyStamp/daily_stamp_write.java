package com.example.HelluApp.DailyStamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.HelluApp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class daily_stamp_write extends AppCompatActivity {

    //매일 인증 글쓰기.java

    Button save_button;         //매일인증 저장하기 버튼
    Button gallery;             //갤러리 열기 버튼

    //이 두 줄은 예린이의 plan_choose.java에서 가져왔습니다. 아마 파이어베이스에서 뭘 가져오나봐요.
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);        //이것도 plan_choose.java에 있어서 가져왔습니다.
        setContentView(R.layout.activity_daily_stamp_write);

        gallery = findViewById(R.id.daily_write_image_button);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        save_button = findViewById(R.id.daily_write_save_button);
        save_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }

}