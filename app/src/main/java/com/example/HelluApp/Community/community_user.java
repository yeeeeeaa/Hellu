package com.example.HelluApp.Community;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.HelluApp.Metaverse.metaverse_note;
import com.example.HelluApp.R;
import com.example.HelluApp.User;
import com.example.HelluApp.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//친구목록.java

public class community_user extends Fragment {

    private RecyclerView mRecyclerView;
    private community_user_recycler_adapter mRecyclerAdapter;
    private ArrayList<community_user_item> mfriendItems;

    private DatabaseReference rDatabase = FirebaseDatabase.getInstance().getReference("User");
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private static List<String> user_name = new ArrayList<String>();
    private static List<String> user_profile = new ArrayList<String>();
    //private static List<String> user_uid = new ArrayList<String>();
    private final List<String> user_uid = Arrays.asList(new String[]{"AVexH4Ad5fSKvRkn3K05LeDn7412",
            "B6Z4jri4ylWsZ9IWx3qY6NHeXZh1", "PVSRpvhdTLQjpo6cdXW13n2yYYe2", "hQEqfo4FlUcVjiyVuor1leKR3V72",
            "iHXYPuIxy0bqNliP8tvdkaIUrKI2"
    });
    private static String test = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //파이어베이스에서 데이타를 읽어올 경로
        rDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String firemessage = snapshot.getValue().toString();    //문자열로 받기
                    test = firemessage;
                    //user_uid.add(firemessage);  //리스트에 추가
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        });
/*
        user_uid.add("AVexH4Ad5fSKvRkn3K05LeDn7412"); //키, 값
        user_uid.add("B6Z4jri4ylWsZ9IWx3qY6NHeXZh1"); //키, 값
        user_uid.add("PVSRpvhdTLQjpo6cdXW13n2yYYe2"); //키, 값
        user_uid.add("hQEqfo4FlUcVjiyVuor1leKR3V72"); //키, 값
        user_uid.add("iHXYPuIxy0bqNliP8tvdkaIUrKI2"); //키, 값
 */

        View view =   inflater.inflate(R.layout.fragment_community_user,container,false);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        /* initiate adapter */
        mRecyclerAdapter = new community_user_recycler_adapter();

        /* initiate recyclerview */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /* adapt data */
        mfriendItems = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid();
/*
        rDatabase.child(Uid).addValueEventListener(new ValueEventListener() {
            @Override
            //리스너는 이벤트 발생 시점에 데이터베이스에서 지정된 위치에 있던 데이터를 포함하는 DataSnapshot을 수신한다.
            //스냅샷에 대해 getValue()를 호출하면 데이터의 자바 객체 표현이 반환된다.
            //해당 위치에 데이터가 없는 경우 getValue()를 호출하면 null이 반환된다.
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user1 = dataSnapshot.getValue(User.class);

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


        for(int i = 0; i < user_uid.size(); i++){
            if (user_uid.get(i) != Uid){
                int finalI = i;
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


        rDatabase.addChildEventListener(new ChildEventListener() {
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                //User user1 = dataSnapshot.getValue(User.class);
                //mfriendItems.add(new community_user_item(user1.ProfileUrl, user1.Nickname));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });//addValueEventListener

 */

        for(int i = 0; i < Users.user_name.size(); i++) {
            mfriendItems.add(new community_user_item( Users.user_profile.get(i),  Users.user_name.get(i)));
        }


        // 임의로 이다영, 이예린, 이은서, 최서연, 주호은 이름 찍어주기


        mfriendItems.add(new community_user_item("https://mblogthumb-phinf.pstatic.net/20150417_264/ninevincent_14291992723052lDb3_JPEG/kakao_11.jpg?type=w2", test));
        mfriendItems.add(new community_user_item("https://mblogthumb-phinf.pstatic.net/20150417_264/ninevincent_14291992723052lDb3_JPEG/kakao_11.jpg?type=w2", "이은서"));

        /*
        mfriendItems.add(new community_user_item(R.drawable.no_image, "최서연"));
        mfriendItems.add(new community_user_item(R.drawable.no_image, "주호은"));

         */

        mRecyclerAdapter.setFriendList(mfriendItems);
        mRecyclerView.setAdapter(mRecyclerAdapter);


        // Inflate the layout for this fragment
        return view;
    }

    //fragment는 액티비티랑 다르게 view설정을 해줘야해서 너무 짜증나
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}