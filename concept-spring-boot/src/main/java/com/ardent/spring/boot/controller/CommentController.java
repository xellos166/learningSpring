package com.ardent.spring.boot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ardent.spring.boot.model.Comment;
import com.ardent.spring.boot.model.dto.PostComents;
import com.ardent.spring.boot.model.response.CustomResponse;
import com.ardent.spring.boot.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

	private final CommentService commentService;

	@PostMapping("api/v1/comment")
	public ResponseEntity<CustomResponse> addPost(@RequestBody Comment comment) {

		Comment savedComment = commentService.saveComment(comment);
		return new ResponseEntity<CustomResponse>(new CustomResponse(savedComment, "Comment created sucsessfuly"),
				HttpStatus.CREATED);
	}

	@GetMapping("api/v1/comments")
	public List<Comment> getAll() {
		return commentService.findAllComment();
	}

	@GetMapping("api/v1/comments/post/{id}")
	public ResponseEntity<CustomResponse> getPostById(@PathVariable(name = "id", required = true) Integer id) {
		List<PostComents> comments = commentService.findAllCommentByPostId(id);
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(comments, "Comments for post id" + id + " fetched sucsessfuly"), HttpStatus.OK);
	}

}
