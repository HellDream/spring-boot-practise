package com.myblog.springbootblog;

import com.myblog.springbootblog.entity.Post;
import com.myblog.springbootblog.service.PostService;
import com.myblog.springbootblog.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBlogApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Before
	public void setUp(){
		userService.deleteAllUsers();
		postService.deleteAllPosts();
	}
	@Test
	public void contextLoads() {

	}
	@Test
	public void test1(){
		userService.create("aaa","aaa");
		userService.create("bbb","bbb");
		userService.create("ccc","ccc");
		Assert.assertEquals(3, userService.getAllUsers());
		Assert.assertEquals("aaa", userService.getUserByUsername("aaa").getPassword());
		userService.deleteByUsername("bbb");
		Assert.assertEquals(2, userService.getAllUsers());
	}
	@Test
	public void test2(){
		Post post1 = new Post("post1","content1");
		Post post2 = new Post("post2", "content2");
		Post post3  =new Post("post3","content3");
		postService.create(post1);
		postService.create(post2);
		postService.create(post3);
		Assert.assertEquals(3, postService.findAllPost());
		Assert.assertEquals("post1",postService.findPostByPostId(post1.getPostId()).getTitle());
		Assert.assertEquals("post2",postService.findPostByTitle("post2").getTitle());
		Assert.assertEquals(3,postService.findPostsContains("content").size());
		post1.setTitle("post11");
		post1.setContent("content11");
		postService.updatePost(post1);
		Assert.assertEquals("post11",postService.findPostByPostId(post1.getPostId()).getTitle());
		Assert.assertEquals("content11",postService.findPostByPostId(post1.getPostId()).getContent());
		postService.updateContentByPostId(post2.getPostId(),"content22");
		Assert.assertEquals("content22",postService.findPostByPostId(post2.getPostId()).getContent());
		postService.updateTitleByPostId(post3.getPostId(),"post33");
		Assert.assertEquals("post33",postService.findPostByPostId(post3.getPostId()).getTitle());
		postService.deletePostByPostId(post1.getPostId());
		Assert.assertEquals(2,postService.findAllPosts().size());

	}

}
