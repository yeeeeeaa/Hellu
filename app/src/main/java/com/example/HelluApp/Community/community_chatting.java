package com.example.HelluApp.Community;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.HelluApp.DailyStamp.daily_stamp_write;
import com.example.HelluApp.R;

import java.util.ArrayList;
import java.util.List;

public class community_chatting extends Fragment {

    //채팅.java
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community_chatting, container, false);
        // Inflate the layout for this fragment
        //Intent intent = new Intent(getActivity(), ExChat.class);
        //startActivity(intent);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        return view;
    }

    class  ChatRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        public List<chat_model> chatModels = new ArrayList<>();
        public ChatRecyclerViewAdapter(){

        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            return null;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){

        }
        @Override
        public int getItemCount(){
            return 0;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}