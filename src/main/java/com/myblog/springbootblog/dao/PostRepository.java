package com.myblog.springbootblog.dao;

import com.myblog.springbootblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findPostByContentContains(String content);
    Post findByTitle(String title);
    Post findByPostId(int postId);
    void deletePostByPostId(int postId);
    @Modifying
    @Query("update from Post set title=:title where postId=:postId")
    void updateTitle(@Param("postId") int postId,@Param("title") String title);
    @Modifying
    @Query("update from Post set content=:content where postId=:postId")
    void updateContent(@Param("postId") int postId,@Param("content") String content);
    @Modifying
    @Query("update from Post set title=:title, content=:content where postId=:postId")
    void updatePost(@Param("postId") int postId
            ,@Param("title") String title
            ,@Param("content") String content);


}
