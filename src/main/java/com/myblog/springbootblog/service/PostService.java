package com.myblog.springbootblog.service;

import com.myblog.springbootblog.entity.Post;

import java.util.List;

public interface PostService {
    void create(Post post);
    void deletePostByPostId(int postId);
    int findAllPost();
    List<Post> findAllPosts();
    void updatePost(Post post);
    void updateTitleByPostId(int postId, String title);
    void updateContentByPostId(int postId, String content);
    Post findPostByPostId(int postId);
    List<Post> findPostsContains(String content);
    Post findPostByTitle(String title);
    void deleteAllPosts();
}
