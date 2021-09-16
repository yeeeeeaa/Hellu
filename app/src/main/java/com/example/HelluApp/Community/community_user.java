package com.example.HelluApp.Community;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.HelluApp.Metaverse.metaverse_note;
import com.example.HelluApp.R;
import com.example.HelluApp.User;
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
import androidx.fragment.app.Fragment;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

//친구목록.java

public class community_user extends Fragment {

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
            FirebaseDatabase.getInstance().getReference().child("User").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    users_models.clear();
                    for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                        users_models.add(snapshot.getValue(users_model.class));
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
            Glide.with(holder.itemView.getContext()).load(users_models.get(position).userphoto).apply(new RequestOptions().circleCrop()).into(((CustomViewHolder)holder).imageView);
            ((CustomViewHolder)holder).textView.setText(users_models.get(position).usernm);
        }
        @Override
        public int getItemCount(){
            return users_models.size();
        }
        private class CustomViewHolder extends RecyclerView.ViewHolder{
            public CircleImageView imageView;
            public TextView textView;

            public CustomViewHolder(View view){
                super(view);

                imageView = (CircleImageView) view.findViewById(R.id.profile);
                textView = (TextView) view.findViewById(R.id.name);
            }
        }
    }

}