package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Post;

public interface PostService {

	public String sayHello();

	public Post createpost(Post post);

	public List<Post> getAll();

}
