package com.ardent.spring.boot.service;

import java.util.List;

import com.ardent.spring.boot.model.Post;

public interface PostService {

	/**
	 * @apiNote :This methods will save a post
	 * @author DIBANGSHU
	 * @param post
	 * @return
	 */
	public Post savePost(Post post);

	public Post findPostById(Integer id);

	public List<Post> findAllPost();

	public Post deletePostById(Integer id);
}
