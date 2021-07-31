package com.example.HelluApp.DailyStamp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.HelluApp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class daily_stamp_write<daily_recyclerview> extends AppCompatActivity {

    //매일 인증 글쓰기.java

    String ID;                  //글 번호-이건 파이어베이스에 필요한지는 모르겠어요
    String Title;               //글 제목
    String Content;             //글 내용
    String Picture;             //글 사진 경로
    String DateWrite;           //글에 대한 날짜

    Button save_button;         //매일인증 저장하기 버튼
    Button gallery;             //갤러리 열기 버튼

    ImageView daily_recyclerview;

    private static final String TAG = "daily_stamp_write";
    private Uri filePath;

    //이 두 줄은 예린이의 plan_choose.java에서 가져왔습니다. 아마 파이어베이스에서 뭘 가져오나봐요.
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public daily_stamp_write() {
    }

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

                mAuth = FirebaseAuth.getInstance();
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference();

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);

                //이미지 업로드 부분
                picture_upload();
            }
        });

        save_button = findViewById(R.id.daily_write_save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //모르지만 예린이 코드 훔쳐오기
                Input_daily();
                HashMap<String, Object> Daily_write = new HashMap<>();
                Daily_write.put("글 번호", ID);
                Daily_write.put("제목", Title);
                Daily_write.put("내용", Content);
                Daily_write.put("사진", Picture);
                Daily_write.put("날짜", DateWrite);

                databaseReference.child("User_Write").push().setValue(Daily_write);

            }
        });

    }

    //결과 처리
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //request코드가 0이고 OK를 선택했고 data에 뭔가가 들어 있다면
        if(requestCode == 0 && resultCode == RESULT_OK){
            filePath = data.getData();
            Log.d(TAG, "uri:" + String.valueOf(filePath));
            try {
                //Uri 파일을 Bitmap으로 만들어서 ImageView에 집어 넣는다.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                daily_recyclerview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //upload the file
    private void picture_upload() {
        //업로드할 파일이 있으면 수행
        if (filePath != null) {
            //업로드 진행 Dialog 보이기
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("업로드중...");
            progressDialog.show();

            //storage
            FirebaseStorage storage = FirebaseStorage.getInstance();

            //Unique한 파일명을 만들자.
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMHH_mmss");
            Date now = new Date();
            String filename = formatter.format(now) + ".png";
            //storage 주소와 폴더 파일명을 지정해 준다.
            StorageReference storageRef = storage.getReferenceFromUrl("gs://yourStorage.appspot.com").child("images/" + filename);
            //올라가거라...
            storageRef.putFile(filePath)
                    //성공시
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss(); //업로드 진행 Dialog 상자 닫기
                            Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //실패시
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //진행중
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            @SuppressWarnings("VisibleForTests") //이걸 넣어 줘야 아랫줄에 에러가 사라진다. 넌 누구냐?
                            double progress = (100 * taskSnapshot.getBytesTransferred()) /  taskSnapshot.getTotalByteCount();
                            //dialog에 진행률을 퍼센트로 출력해 준다
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "% ...");
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "파일을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
        }
    }

    public void Input_daily() {

        //제목 입력
        EditText optionTitle = findViewById(R.id.daily_write_title);

        //내용 입력
        EditText optionContent = findViewById(R.id.daily_write_content);

        //날짜는 입력을 받지 않아서 따로 변수를 만들지 않았습니다.

        //제목
        if (optionTitle != null) {
            Title = optionTitle.getText().toString().trim();
        } else {
            Toast.makeText(this, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        //내용
        if (optionContent != null) {
            Content = optionContent.getText().toString().trim();
        } else {
            Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        //날짜
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //DateWrite= simpleDateFormat.format(new Date().getTime());

    }

}