package com.example.HelluApp.Community;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.HelluApp.R;
import com.example.HelluApp.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//친구목록.java

public class community_user extends Fragment {
    private DatabaseReference rDatabase = FirebaseDatabase.getInstance().getReference("User");
    String Nickname;
    String Email;
    String Profile;
    String Uid;
    List<String> users_uids = new ArrayList<>();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
    private String currentUid = user.getUid();

    int i = 0;
    int first;
    int current;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_community_user,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        recyclerView.setAdapter(new CommunityUsersRecyclerViewAdapter());
        return view;
    }

    class CommunityUsersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<users_model> users_models;
        //users_model users_models2;

        public CommunityUsersRecyclerViewAdapter(){
            users_models = new ArrayList<>();
            FirebaseDatabase.getInstance().getReference("User").addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    users_models.clear();
                    for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                        users_uids.add(snapshot.getKey());
                        users_models.add(snapshot.child(users_uids.get(i)).getValue(users_model.class));

                        i++;
                    }
                    notifyDataSetChanged();
                    for(int k = 0;k < users_uids.size(); k++){
                        if(users_uids.get(k).equals(currentUid)) {
                            users_uids.remove(currentUid);
                            users_uids.add(0, currentUid);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_user_item,parent,false);
            return new CustomViewHolder(view);
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position){
            first = 1;
            current = 0;
            FirebaseDatabase.getInstance().getReference("User").addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Nickname = dataSnapshot.child(users_uids.get(position)).child("Nickname").getValue(String.class);
                    Email = dataSnapshot.child(users_uids.get(position)).child("Email").getValue(String.class);
                    Profile = dataSnapshot.child(users_uids.get(position)).child("ProfileUrl").getValue(String.class);
                    Uid = dataSnapshot.child(users_uids.get(position)).child("Uid").getValue(String.class);
                    first = 0;
                    Glide.with(holder.itemView.getContext())
                            .load(Profile).apply(new RequestOptions().circleCrop()).into(((CustomViewHolder) holder).imageView);
                    //((CustomViewHolder)holder).textView.setText(users_models.get(position).usernm);
                    ((CustomViewHolder) holder).textView.setText(Nickname);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            //Picasso.get().load(users_models.get(position).userphoto).into(((CustomViewHolder)holder).imageView);
            //Picasso.get().load("https://mblogthumb-phinf.pstatic.net/20150417_264/ninevincent_14291992723052lDb3_JPEG/kakao_11.jpg?type=w2").into(((CustomViewHolder)holder).imageView);
            //Glide.with(holder.itemView.getContext()).load(users_models.get(position).userphoto).apply(new RequestOptions().circleCrop()).into(((CustomViewHolder)holder).imageView);
        }
        @Override
        public int getItemCount(){
            return users_models.size();
        }
        private class CustomViewHolder extends RecyclerView.ViewHolder{
            public ImageView imageView;
            public TextView textView;

            public CustomViewHolder(View view){
                super(view);

                imageView = (ImageView) view.findViewById(R.id.profile);
                textView = (TextView) view.findViewById(R.id.name);
            }
        }
    }

}