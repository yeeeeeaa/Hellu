package com.example.HelluApp.Community;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HelluApp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class community_message extends AppCompatActivity {

    private Button button;
    private EditText editText;

    private String chatRoomUid;
    private String uid;  //채팅을 요구 하는 아아디 즉 단말기에 로그인된 UID
    private String destinatonUid; // 채팅을 당하는 아이디

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char);
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();  //채팅을 요구 하는 아아디 즉 단말기에 로그인된 UID
        destinatonUid = getIntent().getStringExtra("destinationUid"); // 채팅을 당하는 아이디
        button = (Button) findViewById(R.id.send);
        editText = (EditText) findViewById(R.id.message);

        recyclerView = (RecyclerView) findViewById(R.id.msg_list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_model chatModel = new chat_model();
                chatModel.users.put(uid,true);
                chatModel.users.put(destinatonUid,true);
                if(chatRoomUid == null){
                    button.setEnabled(false);
                    FirebaseDatabase.getInstance().getReference().child("Chatting_Room").push().setValue(chatModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            checkChatRoom();
                        }
                    });
                }else {
                    chat_model.Comment comment = new chat_model.Comment();
                    chatModel.comment.put(uid, editText.getText().toString());
                    comment.uid = uid;
                    comment.message = editText.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("Chatting_Room").child(chatRoomUid).child("comments").push().setValue(chatModel.comment);
                    //FirebaseDatabase.getInstance().getReference().child("Chatting_Room").child(chatRoomUid).child("comments").push().setValue(comment.message);
                }
            }
        });
        checkChatRoom();
    }

    void checkChatRoom(){
        FirebaseDatabase.getInstance().getReference().child("Chatting_Room").orderByChild("users/"+uid).equalTo(true).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    chat_model chatModel = item.getValue(chat_model.class);
                    if(chatModel.users.containsKey(destinatonUid)){
                        chatRoomUid = item.getKey();
                        button.setEnabled(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(community_message.this));
                        recyclerView.setAdapter(new RecyclerViewAdapter());
                        Log.d("MainActivity", "ValueEventListener : " + "도착 uid 저장하기 성공");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        //List<chat_model.Comment> comments;
        List<String> comments;
        List<String> uids;
        public RecyclerViewAdapter(){
            comments = new ArrayList<>();
            FirebaseDatabase.getInstance().getReference("Chatting_room").child(chatRoomUid).addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    comments.clear();
                    Log.d("MainActivity", "ValueEventListener : " + FirebaseDatabase.getInstance().getReference("Chatting_room").child(chatRoomUid).getKey());
                    Log.d("MainActivity", "ValueEventListener : " + dataSnapshot.getChildren());
                    for (DataSnapshot item : dataSnapshot.getChildren()){
                        comments.add((String) item.getValue());
                        Log.d("MainActivity", "ValueEventListener : " + "코멘트 저장하기 성공");
                    }
                    notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
            Log.d("MainActivity", "ValueEventListener : " + "뷰에 아이템 선언하기");
            return new MessageViewHolder(view);
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position){
            ((MessageViewHolder)holder).textView_msg.setText(comments.get(position));
            Log.d("MainActivity", "ValueEventListener : " + "메시지 띄우기 성공");
        }
        @Override
        public int getItemCount(){
            return comments.size();
        }
        private class MessageViewHolder extends RecyclerView.ViewHolder {
            public TextView textView_msg;
            public MessageViewHolder(View view){
                super(view);
                textView_msg = (TextView) view.findViewById(R.id.message_item_msg);
                Log.d("MainActivity", "ValueEventListener : " + "뷰에 메시지 선언하기");
            }
        }
    }
}