package com.example.HelluApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signup extends AppCompatActivity {

    private Button signup_button;

    @Override

    //activity_signup 화면을 보여줌
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_button = (Button) findViewById(R.id.signup_button);
    }

}