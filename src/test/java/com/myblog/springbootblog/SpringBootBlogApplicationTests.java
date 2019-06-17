package com.myblog.springbootblog;

import com.myblog.springbootblog.entity.Post;
import com.myblog.springbootblog.entity.User;
import com.myblog.springbootblog.service.PostService;
import com.myblog.springbootblog.service.UserService;
import com.myblog.springbootblog.web.PostController;
import com.myblog.springbootblog.web.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootBlogApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
    @Autowired
    private UserController userController;
    @Autowired
	private PostController postController;
	@Before
	public void setUp(){
//	    mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
		userService.deleteAllUsers();
		postService.deleteAllPosts();
	}
	@Test
	public void contextLoads() throws Exception {
        mvc.perform(post("/user/register/")
                .param("username","aaa")
                .param("password","aaa")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"code\":201,\"msg\":\"Created\",\"data\":null}")));
	}
//	@Test
//	public void test1(){
//		userService.create("aaa","aaa");
//		userService.create("bbb","bbb");
//		userService.create("ccc","ccc");
//		Assert.assertEquals(3, userService.getAllUsers());
//		Assert.assertEquals("aaa", userService.getUserByUsername("aaa").getPassword());
//		userService.deleteByUsername("bbb");
//		Assert.assertEquals(2, userService.getAllUsers());
//	}
//	@Test
//	public void test2(){
//		Post post1 = new Post("post1","content1");
//		Post post2 = new Post("post2", "content2");
//		Post post3  =new Post("post3","content3");
//		postService.create(post1);
//		postService.create(post2);
//		postService.create(post3);
//		Assert.assertEquals(3, postService.findAllPost());
//		Assert.assertEquals("post1",postService.findPostByPostId(post1.getPostId()).getTitle());
//		Assert.assertEquals("post2",postService.findPostByTitle("post2").getTitle());
//		Assert.assertEquals(3,postService.findPostsContains("content").size());
//		post1.setTitle("post11");
//		post1.setContent("content11");
//		postService.updatePost(post1);
//		Assert.assertEquals("post11",postService.findPostByPostId(post1.getPostId()).getTitle());
//		Assert.assertEquals("content11",postService.findPostByPostId(post1.getPostId()).getContent());
//		postService.updateContentByPostId(post2.getPostId(),"content22");
//		Assert.assertEquals("content22",postService.findPostByPostId(post2.getPostId()).getContent());
//		postService.updateTitleByPostId(post3.getPostId(),"post33");
//		Assert.assertEquals("post33",postService.findPostByPostId(post3.getPostId()).getTitle());
//		postService.deletePostByPostId(post1.getPostId());
//		Assert.assertEquals(2,postService.findAllPosts().size());
//	}
	@Test
	public void test3() throws Exception {
	    RequestBuilder request = post("/user/login/")
                .param("username","aaa")
                .param("password","aaa");
        mvc.perform(request).andExpect(status().isOk());
    }
    @Test
	public void test() throws Exception{
		RequestBuilder request = post("/")
				.param("title","title1").param("content","content1");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"code\":201,\"msg\":\"Created\",\"data\":null}")));

	}


}
