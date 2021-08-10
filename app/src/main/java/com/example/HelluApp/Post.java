package com.example.HelluApp;

import java.util.HashMap;
import java.util.Map;

public class Post {

    public String Uid;
    public String Author;
    public String Title;
    public String Content;
    public int StarCount = 0;
    public Map<String, Boolean> Stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String Uid, String Author, String Title, String Content) {
        this.Uid = Uid; // uid
        this.Author = Author; //글 저자
        this.Title = Title; //글 제목
        this.Content = Content; //글 내용
    }

    public Map<String, Object> posttomap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", Uid);
        result.put("author", Author);
        result.put("title", Title);
        result.put("content", Content);
        result.put("starCount", StarCount); //좋아요 수
        result.put("stars", Stars); //좋아요

        return result;
    }

}
