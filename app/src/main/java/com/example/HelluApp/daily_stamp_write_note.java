package com.example.HelluApp;

public class daily_stamp_write_note {
    int _id;
    String contents;
    int picture;
    String createDateStr;

    public daily_stamp_write_note(int _id, String contents, int  picture, String createDateStr) {
        this._id = _id;
        this.contents = contents;
        this.picture = picture;
        this.createDateStr = createDateStr;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }
}
