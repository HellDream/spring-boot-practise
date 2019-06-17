package com.myblog.springbootblog.web;

import com.myblog.springbootblog.entity.Post;
import com.myblog.springbootblog.entity.Result;
import com.myblog.springbootblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/")
public class PostController {
    private PostService postService;
    @Autowired

    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    @RequestMapping("/")
    public Result getAllPosts(){
        List<Post> posts = postService.findAllPosts();
        Result result = new Result(200,"OK");
        result.setData(posts);
        return result;
    }
    @RequestMapping("/post/{postId}")
    public Result getPostDetail(@PathVariable int postId){
        Post post = postService.findPostByPostId(postId);
        if(post!=null){
           Result result = new Result(200,"OK");
           result.setData(post);
           return result;
        }
        return new Result(400,"Not Found");
    }
    @RequestMapping("/")
    public Result createPost(@ModelAttribute Post post){
        if(post!=null){
            postService.create(post);
            Result result = new Result(201, "Created");
            result.setData(post);
        }
        return new Result(400, "Bad request");
    }
}
