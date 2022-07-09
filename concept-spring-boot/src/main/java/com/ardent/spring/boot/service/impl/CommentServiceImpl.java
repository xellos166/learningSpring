package com.ardent.spring.boot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ardent.spring.boot.model.Comment;
import com.ardent.spring.boot.model.dto.PostComents;
import com.ardent.spring.boot.repository.CommentRepository;
import com.ardent.spring.boot.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment findCommentById(Integer id) {
		Comment result = null;
		Optional<Comment> commentOpt = commentRepository.findById(id);
		if (commentOpt.isPresent()) {
			result = commentOpt.get();
		}
		return result;
	}

	@Override
	public List<Comment> findAllComment() {
		List<Comment> result = new ArrayList<Comment>();
		commentRepository.findAll().forEach(comment -> result.add(comment));
		return result;
	}

	@Override
	public List<PostComents> findAllCommentByPostId(Integer postId) {

		return commentRepository.getCommentsByPostId(postId);
	}

}
