package com.example.HelluApp.Community;

import org.w3c.dom.Comment;

import java.util.HashMap;
import java.util.Map;

public class chat_model {
    public Map<String, Boolean> users = new HashMap<>();
    public Map<String, Comment> comments = new HashMap<>();
    public Map<String, String> comment = new HashMap<>();
    public static class Comment{
        String uid;
        String message;
    }
}
