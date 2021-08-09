package com.example.HelluApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HelluApp.MainFragment.fragment_mypage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MypageChange extends AppCompatActivity {

    Button change_button;
    EditText nickname_text;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference rDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_change);

        nickname_text = (EditText)findViewById(R.id.et_name);
        change_button = (Button) findViewById(R.id.change_button) ;

        change_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( nickname_text.getText().toString().length() == 0 ) {
                    Toast.makeText(MypageChange.this, "변경할 닉네임을 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    String change_nickname = nickname_text.getText().toString();

                    firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                    String Uid = user.getUid();

                    rDatabase = FirebaseDatabase.getInstance().getReference("User");

                    DatabaseReference usersRef = rDatabase.child(Uid);
                    Map<String, Object> nickUpdates = new HashMap<>();
                    nickUpdates.put("Nickname", change_nickname);
                    usersRef.updateChildren(nickUpdates);
                }
            }
        });


    }
}