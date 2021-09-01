package com.example.HelluApp.Community;

//유저 데이터에 들어갈 내용 클래스

import android.net.Uri;

public class community_user_item {

    String name;
    String resourceId;

    public community_user_item(String resourceId, String name) {
        this.name = name;
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return resourceId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}