package com.example.HelluApp.DailyStamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HelluApp.R;
import com.example.HelluApp.plan_choose;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class daily_stamp_write extends AppCompatActivity {

    //매일 인증 글쓰기.java

    String ID;                  //글 번호-이건 파이어베이스에 필요한지는 모르겠어요
    String Title;               //글 제목
    String Content;             //글 내용
    String Picture;             //글 사진 경로
    String DateWrite;           //글에 대한 날짜

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

        //버튼을 누르면 갤러리로 넘어가는 코드 by 예린
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
        save_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //모르지만 예린이 코드 훔쳐오기
                //Input_daily();
                /*
                HashMap<String, Object> Daily_write = new HashMap<>();
                Daily_write.put("글 번호", ID);
                Daily_write.put("제목", Title);
                Daily_write.put("내용", Content);
                Daily_write.put("사진", Picture);
                Daily_write.put("날짜", DateWrite);

                databaseReference.child("User_Write").push().setValue(Daily_write);
                */
            }
        });
    }

    public void Input_daily() {

        /*
        //제목 입력
        EditText optionTitle = findViewById(R.id.daily_write_title);

        //내용 입력
        EditText optionContent = findViewById(R.id.daily_write_content);

        //날짜
        String optionDate;

        //제목
        if (optionTitle != null) {
            Title = optionTitle.getText().toString().trim();
        } else {
            Toast.makeText(this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        //내용
        if (optionContent != null) {
            Content = optionContent.getText().toString().trim();
        } else {
            Toast.makeText(this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        //날짜
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        optionDate = simpleDateFormat.format(new Date().getTime());
        */
    }

}