package com.example.HelluApp.Community;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HelluApp.R;

import java.util.ArrayList;

//fragment_community_user.xml과 community_user_item.xml을 이어주는 어댑터 클래스

public class community_user_recycler_adapter extends RecyclerView.Adapter<community_user_recycler_adapter.ViewHolder> {

    private ArrayList<community_user_item> UserList;

    @NonNull
    @Override
    //onCreateViewHolder(): RecyclerView는 ViewHolder를 새로 만들어야 할 때마다 이 메서드를 호출합니다.
    public community_user_recycler_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_user_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    //onBindViewHolder(): RecyclerView는 ViewHolder를 데이터와 연결할 때 이 메서드를 호출합니다.
    public void onBindViewHolder(@NonNull community_user_recycler_adapter.ViewHolder holder, int position) {
        holder.onBind(UserList.get(position));
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFriendList(ArrayList<community_user_item> list) {
        this.UserList = list;
        notifyDataSetChanged();
    }

    @Override
    //getItemCount(): RecyclerView는 데이터 세트 크기를 가져올 때 이 메서드를 호출합니다.
    public int getItemCount() {
        return UserList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile);
            name = itemView.findViewById(R.id.name);
        }

        void onBind(community_user_item item) {
            profile.setImageResource(item.getResourceId());
            name.setText(item.getName());
        }
    }
}