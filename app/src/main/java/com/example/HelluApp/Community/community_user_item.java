package com.example.HelluApp.Community;

//유저 데이터에 들어갈 내용 클래스

public class community_user_item {

    String name;
    int resourceId;

    public community_user_item(int resourceId, String name) {
        this.name = name;
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}