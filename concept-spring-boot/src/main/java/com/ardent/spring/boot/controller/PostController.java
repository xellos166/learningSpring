package com.ardent.spring.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	// Old style
	// @Autowired
	// private PostService postService;

	private final PostService postService;

	// Equivalant code of RequiredArgsConstructor
	/*
	 * public PostController(PostService p) {
	 * System.out.println("Controler is being created by spring container");
	 * this.postService = p; }
	 */

	@PostMapping("api/v1/post")
	public Post addPost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	@GetMapping("api/v1/posts")
	public List<Post> getAll() {
		return postService.findAllPost();
	}

	@GetMapping("api/v1/post/{id}")
	public Post getPostById(@PathVariable(name = "id", required = true) Integer id) {
		return postService.findPostById(id);
	}

	@DeleteMapping("api/v1/post")
	public Post deletePostById(@RequestParam(name = "id", required = true) Integer id) {
		return postService.deletePostById(id);
	}
}
