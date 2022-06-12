package com.ardent.spring.boot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.model.response.CustomResponse;
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
	public ResponseEntity<CustomResponse> addPost(@RequestBody Post post) {
		Post savedPost = postService.savePost(post);
		return new ResponseEntity<CustomResponse>(new CustomResponse(savedPost, "Post created sucsessfuly"),
				HttpStatus.CREATED);
	}

	@GetMapping("api/v1/posts")
	public List<Post> getAll() {
		return postService.findAllPost();
	}

	@GetMapping("api/v1/post/{id}")
	public ResponseEntity<CustomResponse> getPostById(@PathVariable(name = "id", required = true) Integer id) {
		Post result = postService.findPostById(id);

		if (result == null) {
			return new ResponseEntity<CustomResponse>(new CustomResponse(null, "No posts found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomResponse>(new CustomResponse(result, "Post fetched successfully"),
				HttpStatus.OK);
	}

	@DeleteMapping("api/v1/post")
	public Post deletePostById(@RequestParam(name = "id", required = true) Integer id) {
		return postService.deletePostById(id);
	}

	@PutMapping("api/v1/post/{id}")
	public Post getPostById(@PathVariable(name = "id", required = true) Integer id, @RequestBody Post post) {
		return postService.editById(id, post);
	}
}
