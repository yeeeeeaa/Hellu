package com.example.HelluApp;

import java.util.HashMap;
import java.util.Map;

public class Post {

    public String uid;
    public String author;
    public String title;
    public String content;
    private String profile;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String content) {
        this.uid = uid; // uid
        this.author = author; //글 저자
        this.title = title; //글 제목
        this.content = content; //글 내용
    }

    public Map<String, Object> posttomap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("content", content);

        return result;
    }
}
