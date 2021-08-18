package com.example.HelluApp.Community;

//유저 데이터에 들어갈 내용 클래스

public class community_user_item {

    String name;
    String message;
    int resourceId;

    public community_user_item(int resourceId, String name, String message) {
        this.name = name;
        this.message= message;
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}