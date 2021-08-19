package com.example.HelluApp.DailyStamp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyPostsFragment extends daily_stamp_allpost_frag {

    public MyPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("User_Write")
                .child(getUid());
    }
}
