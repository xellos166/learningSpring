package com.ardent.spring.boot.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.model.request.PostRequest;
import com.ardent.spring.boot.service.PostService;
import com.ardent.spring.boot.util.PostUtil;

@Service
public class PostServiceCollectionImpl implements PostService {

	static List<Post> postStorage;
	static int i = 0;
	static {
		postStorage = new ArrayList<Post>();
	}

	@Override
	public Post savePost(PostRequest postRequest) {
		Post post = PostUtil.getPostFromPostRequest(postRequest);
		post.setId(++i);
		post.setDate(new Date(System.currentTimeMillis()));
		postStorage.add(post);
		return post;
	}

	@Override
	public Post findPostById(Integer id) {

		Post result = null;
		// using stream and lambda expression
		Optional<Post> resultOpt = postStorage.stream().filter(post -> post.getId().equals(id)).findFirst();
		if (resultOpt.isPresent()) {
			result = resultOpt.get();
		}
		// Using for loop
		/*
		 * for (Post post : postStorage) { if (post.getId().equals(id)) { result = post;
		 * break; } }
		 */

		return result;
	}

	@Override
	public List<Post> findAllPost() {
		return postStorage;
	}

	@Override
	public Post deletePostById(Integer id) {
		Post result = null;
		// using stream and lambda expression
		Optional<Post> resultOpt = postStorage.stream().filter(post -> post.getId().equals(id)).findFirst();
		if (resultOpt.isPresent()) {
			result = resultOpt.get();
		}
		// remove the object from the post storage list
		postStorage.remove(result);

		// return the deleted objcet
		return result;
	}

	@Override
	public Post editById(Integer id, PostRequest post) {
		Post result = null;
		// using stream and lambda expression
		Optional<Post> resultOpt = postStorage.stream().filter(p -> p.getId().equals(id)).findFirst();
		if (resultOpt.isPresent()) {
			result = resultOpt.get();
		}
		result.setPostText(post.getPostText());
		return result;
	}

}
