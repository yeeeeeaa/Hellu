package com.example.HelluApp.DailyStamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.HelluApp.R;

public class daily_stamp_write extends AppCompatActivity {

    //매일 인증 글쓰기.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_stamp_write);

        Button daily_save_button = findViewById(R.id.daily_write_save_button);
        daily_save_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }

}