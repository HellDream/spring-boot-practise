package com.myblog.springbootblog.entity;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private int postId;
    @Column(nullable = false, length = 512)
    private String title;
    @Column(length = 16777215)
    private String content;

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
