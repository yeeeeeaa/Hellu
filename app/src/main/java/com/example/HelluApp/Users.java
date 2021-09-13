package com.example.HelluApp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class Users {
    public String Nickname;
    public String Email;
    public String Uid;
    public String ProfileUrl;

    public List<String> user_uid = Arrays.asList(new String[]{"AVexH4Ad5fSKvRkn3K05LeDn7412",
            "B6Z4jri4ylWsZ9IWx3qY6NHeXZh1", "PVSRpvhdTLQjpo6cdXW13n2yYYe2", "hQEqfo4FlUcVjiyVuor1leKR3V72",
            "iHXYPuIxy0bqNliP8tvdkaIUrKI2"
    });

    private DatabaseReference rDatabase = FirebaseDatabase.getInstance().getReference("User");
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public static List<String> user_name = new ArrayList<String>();
    public static List<String> user_profile = new ArrayList<String>();

    public Users(){

        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid();

        for(int i = 0; i < user_uid.size(); i++){
            if (user_uid.get(i) != Uid){
                rDatabase.child(user_uid.get(i)).addValueEventListener(new ValueEventListener() {
                    @Override
                    //리스너는 이벤트 발생 시점에 데이터베이스에서 지정된 위치에 있던 데이터를 포함하는 DataSnapshot을 수신한다.
                    //스냅샷에 대해 getValue()를 호출하면 데이터의 자바 객체 표현이 반환된다.
                    //해당 위치에 데이터가 없는 경우 getValue()를 호출하면 null이 반환된다.
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Users user1 = dataSnapshot.getValue(Users.class);

                        user_name.add(user1.Nickname);
                        user_profile.add(user1.ProfileUrl);
                        //값 받아오기
                        //텍스트뷰에 받아온 문자열 대입하기
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        Log.w("FireBaseData", "loadPost:onCancelled", databaseError.toException());
                    }});
            }
        }
        // Default constructor required for calls to DataSnapshot.getValue(user.class)
    }
    public Users(String Nickname, String Email, String Uid, String ProfileUrl){
        this.Nickname = Nickname;
        this.Email = Email;
        this.Uid = Uid;
        this.ProfileUrl = ProfileUrl;
    }

}
