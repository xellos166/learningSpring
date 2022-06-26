package com.ardent.spring.boot.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.model.request.PostRequest;
import com.ardent.spring.boot.repository.PostRepository;
import com.ardent.spring.boot.service.PostService;
import com.ardent.spring.boot.util.PostUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Primary
public class PostServiceDBImpl implements PostService {
	private final PostRepository postRepository;

	@Override
	@Transactional
	public Post savePost(PostRequest post) {
		Post p = PostUtil.getPostFromPostRequest(post);
		p.setDate(new Date(System.currentTimeMillis()));
		return postRepository.save(p);
	}

	@Override
	public Post findPostById(Integer id) {
		Optional<Post> postOp = postRepository.findById(id);
		return postOp.get();
	}

	@Override
	public List<Post> findAllPost() {
		List<Post> result = new ArrayList<Post>();
		postRepository.findAll().forEach(post -> result.add(post));
		return result;
	}

	@Override
	@Transactional
	public Post deletePostById(Integer id) {
		Optional<Post> postOp = postRepository.findById(id);
		Post deletedPost = null;
		if (postOp.isPresent()) {
			deletedPost = postOp.get();
			postRepository.deleteById(id);

		}
		return deletedPost;
	}

	@Override
	@Transactional
	public Post editById(Integer id, PostRequest post) {
		Optional<Post> postOp = postRepository.findById(id);
		Post updatedPost = null;
		if (postOp.isPresent()) {
			updatedPost = postOp.get();
			if (post.getAuthor() != null && !post.getAuthor().isEmpty()) {
				updatedPost.setAuthor(post.getAuthor());
			}
			if (post.getPostText() != null && post.getPostText().isEmpty()) {
				updatedPost.setPostText(post.getPostText());
			}
			if (post.getReaction() != null && post.getReaction().isEmpty()) {
				updatedPost.setReaction(post.getReaction());
			}
		}
		return postRepository.save(updatedPost);
	}

	@Override
	public List<Post> findAllPostAuthorName(String name) {

		return postRepository.findAllByAuthor(name);
	}

}
