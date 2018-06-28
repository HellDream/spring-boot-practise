package com.myblog.springbootblog.service;

import com.myblog.springbootblog.dao.PostRepository;
import com.myblog.springbootblog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    @Override
    public void create(Post post) {
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePostByPostId(int postId) {
        postRepository.deletePostByPostId(postId);
    }

    @Override
    public int findAllPost() {
        return postRepository.findAll().size();
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        postRepository.updatePost(post.getPostId(),post.getTitle(),post.getContent());
    }

    @Override
    @Transactional
    public void updateTitleByPostId(int postId, String title) {
        postRepository.updateTitle(postId,title);
    }

    @Override
    @Transactional
    public void updateContentByPostId(int postId, String content) {
        postRepository.updateContent(postId,content);
    }

    @Override
    public Post findPostByPostId(int postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    public List<Post> findPostsContains(String content) {
        return postRepository.findPostByContentContains(content);
    }

    @Override
    public Post findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
