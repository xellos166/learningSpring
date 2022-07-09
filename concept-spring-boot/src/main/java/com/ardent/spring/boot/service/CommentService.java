package com.ardent.spring.boot.service;

import java.util.List;

import com.ardent.spring.boot.model.Comment;
import com.ardent.spring.boot.model.dto.PostComents;

public interface CommentService {

	/**
	 * @apiNote :This methods will save a post
	 * @author DIBANGSHU
	 * @param post
	 * @return
	 */
	public Comment saveComment(Comment comment);

	public Comment findCommentById(Integer id);

	public List<Comment> findAllComment();

	public List<PostComents> findAllCommentByPostId(Integer postId);
}
