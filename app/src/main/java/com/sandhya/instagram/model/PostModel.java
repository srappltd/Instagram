package com.sandhya.instagram.model;

public class PostModel {
    String id,key,name,username,post,profileImage;
    String like,dislike,share,message,save;

    public PostModel() {
    }

    public PostModel(String name, String username, String post, String profileImage) {
        this.name = name;
        this.username = username;
        this.post = post;
        this.profileImage = profileImage;
    }

    public PostModel(String id, String key, String name, String username, String post, String profileImage, String like, String dislike, String share, String message, String save) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.username = username;
        this.post = post;
        this.profileImage = profileImage;
        this.like = like;
        this.dislike = dislike;
        this.share = share;
        this.message = message;
        this.save = save;
    }

    public PostModel(String key, String name, String username, String post, String profileImage, String like) {
        this.key = key;
        this.name = name;
        this.username = username;
        this.post = post;
        this.profileImage = profileImage;
        this.like = like;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }
}
