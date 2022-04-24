package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	private static List<Post> postStore;
	private static int id = 0;
	static {
		postStore = new ArrayList<Post>();
	}

	@Override
	public String sayHello() {

		return "Hello !!! " + new Date();
	}

	@Override
	public Post createpost(Post post) {
		post.setId(++id);
		postStore.add(post);
		return post;
	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return postStore;
	}

	@Override
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		for (Post p : postStore) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
		// return postStore.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	@Override
	public List<Post> getPostByAuthorAndReaction(String author, String reaction) {
		List<Post> l = new ArrayList<Post>();
		for (Post p : postStore) {
			if (p.getAuthor().equalsIgnoreCase(author) && p.getReaction().equalsIgnoreCase(reaction)) {
				l.add(p);
			}
		}
		return l;

		/*
		 * return postStore.stream() .filter(p -> p.getAuthor().equalsIgnoreCase(author)
		 * && p.getReaction().equalsIgnoreCase(reaction)) .collect(Collectors.toList());
		 */
	}

}
