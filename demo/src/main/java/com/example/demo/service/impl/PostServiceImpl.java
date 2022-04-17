package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	private static List<Post> postStore;
	private static int id=0;
	static {
		postStore=new ArrayList<Post>();
	}

	@Override
	public String sayHello() {
		
		return "Hello !!! "+new Date();
	}

	@Override
	public Post createpost(Post post) {
		post.setId(++id);
		postStore.add(post);
		return post;
	}

}
