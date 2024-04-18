package com.ksamar.library.entity;

public class ImageMsg {
    private int id;
    private String url;
    private String description;
    private String add_time;
    public ImageMsg(){}

    public ImageMsg(int id, String url, String description,String add_time) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.add_time = add_time;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
