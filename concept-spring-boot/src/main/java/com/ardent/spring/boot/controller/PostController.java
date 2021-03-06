package com.ardent.spring.boot.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.model.request.PostRequest;
import com.ardent.spring.boot.model.response.CustomResponse;
import com.ardent.spring.boot.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class PostController {

	// Old style
	// @Autowired
	// private PostService postService;

	private final PostService postService;

	@Value("${client.name}")
	private String customValue;

	// Equivalant code of RequiredArgsConstructor
	/*
	 * public PostController(PostService p) {
	 * System.out.println("Controler is being created by spring container");
	 * this.postService = p; }
	 */

	@PostMapping(path = "api/v1/post", produces = { "application/json", "application/xml" })
	public ResponseEntity<CustomResponse> addPost(@Valid @RequestBody PostRequest post) {
		// log.trace("A TRACE Message");
		// log.debug("A DEBUG Message");
		log.info("method addPost called with " + customValue);
		// log.warn("A WARN Message");
		// log.error("An ERROR Message");
		post = null;
		Post savedPost = postService.savePost(post);
		return new ResponseEntity<CustomResponse>(new CustomResponse(savedPost, "Post created sucsessfuly", null),
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
			return new ResponseEntity<CustomResponse>(new CustomResponse(null, "No posts found", null),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomResponse>(new CustomResponse(result, "Post fetched successfully", null),
				HttpStatus.OK);
	}

	@DeleteMapping("api/v1/post")
	public Post deletePostById(@RequestParam(name = "id", required = true) Integer id) {
		return postService.deletePostById(id);
	}

	@PutMapping("api/v1/post/{id}")
	public Post getPostById(@Valid @NotNull @PathVariable(name = "id", required = true) Integer id,
			@RequestBody PostRequest post) {
		return postService.editById(id, post);
	}

	@GetMapping("api/v1/post/name/{name}")
	public ResponseEntity<CustomResponse> getPostByAuthorName(
			@PathVariable(name = "name", required = true) String name) {
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(postService.findAllPostAuthorName(name), "Post fetched successfully", null),
				HttpStatus.OK);

	}
}
