package com.example.HelluApp.Community;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        /* initiate adapter */
        mRecyclerAdapter = new community_user_recycler_adapter();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        /* adapt data */
        mfriendItems = new ArrayList<>();

        for(int i=1;i<10;i++){
            if(i%2==0)
                mfriendItems.add(new community_user_item(R.mipmap.ic_launcher,i+"번째 사람",i+"번째 상태메시지"));
            else
                mfriendItems.add(new community_user_item(R.mipmap.ic_launcher,i+"번째 사람",i+"번째 상태메시지"));

        }
        mRecyclerAdapter.setFriendList(mfriendItems);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community_user, container, false);
    }

    //얜 fragment 만들 때 생긴 코드
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}