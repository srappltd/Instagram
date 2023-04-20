package com.sandhya.instagram.model;

public class HistoryAccountModel {
    String id,key,title,image,history;

    public HistoryAccountModel() {
    }

    public HistoryAccountModel(String id, String key, String title, String image, String history) {
        this.id = id;
        this.key = key;
        this.title = title;
        this.image = image;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
