package com.example.HelluApp.Community;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.HelluApp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//친구목록.java

public class community_user extends Fragment {
    private DatabaseReference rDatabase = FirebaseDatabase.getInstance().getReference("User");

    String Nickname;
    String Profile;
    String Email;
    String Uid;

    List<String> users_uids = new ArrayList<>();

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
        List<users_model> users_models;

        public CommunityUsersRecyclerViewAdapter(){
            users_models = new ArrayList<>();
            FirebaseDatabase.getInstance().getReference("User").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    users_models.clear();
                    for(DataSnapshot snapshot :dataSnapshot.getChildren()){

                        users_uids.add(snapshot.getKey());
                        users_model users_model_list = snapshot.getValue(users_model.class);
                        /*
                        for (int i = 0; i < users_uids.size(); i++) {
                            Email = rDatabase.child(users_uids.get(i)).child("Email").toString();
                            Nickname = rDatabase.child(users_uids.get(i)).child("Nickname").toString();
                            Profile = rDatabase.child(users_uids.get(i)).child("ProfileUrl").toString();;
                            Uid = rDatabase.child(users_uids.get(i)).child("Uid").toString();;

                            users_models.add(new users_model(Email, Nickname, Profile, Uid));
                        }

                         */
                        //Email = rDatabase.child(users_uids.get(i)).child("Email").toString();
                        users_models.add(new users_model(Email, Nickname, Profile, Uid));
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_user_item,parent,false);
            return new CustomViewHolder(view);
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
            //Picasso.get().load(users_models.get(position).userphoto).into(((CustomViewHolder)holder).imageView);
            //Picasso.get().load("https://mblogthumb-phinf.pstatic.net/20150417_264/ninevincent_14291992723052lDb3_JPEG/kakao_11.jpg?type=w2").into(((CustomViewHolder)holder).imageView);
            //Glide.with(holder.itemView.getContext()).load(users_models.get(position).userphoto).apply(new RequestOptions().circleCrop()).into(((CustomViewHolder)holder).imageView);
            Glide.with(holder.itemView.getContext())
                    .load(users_models.get(position).userphoto).apply(new RequestOptions().circleCrop()).into(((CustomViewHolder)holder).imageView);
            //((CustomViewHolder)holder).textView.setText(users_models.get(position).usernm);
            ((CustomViewHolder)holder).textView.setText(users_models.get(position).usernm);
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