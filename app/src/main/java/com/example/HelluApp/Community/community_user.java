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
import java.util.List;

//친구목록.java

public class community_user extends Fragment {

    private RecyclerView mRecyclerView;
    private community_user_recycler_adapter mRecyclerAdapter;
    private ArrayList<community_user_item> mfriendItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =   inflater.inflate(R.layout.fragment_community_user,container,false);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        /* initiate adapter */
        mRecyclerAdapter = new community_user_recycler_adapter();

        /* initiate recyclerview */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /* adapt data */
        mfriendItems = new ArrayList<>();

        // 임의로 이다영, 이예린, 이은서, 최서연, 주호은 이름 찍어주기
        mfriendItems.add(new community_user_item(R.drawable.no_image, "이다영"));
        mfriendItems.add(new community_user_item(R.drawable.no_image, "이예린"));
        mfriendItems.add(new community_user_item(R.drawable.no_image, "이은서"));
        mfriendItems.add(new community_user_item(R.drawable.no_image, "최서연"));
        mfriendItems.add(new community_user_item(R.drawable.no_image, "주호은"));

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