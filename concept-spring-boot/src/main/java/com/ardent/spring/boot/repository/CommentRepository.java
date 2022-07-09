package com.ardent.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ardent.spring.boot.model.Comment;
import com.ardent.spring.boot.model.dto.PostComents;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query(value = "select cd.ID as commentId,pd.AUTHOR as author ,pd.POST_TEXT as post,cd.COMMENT_TEXT as comment from "
			+ "post_details pd inner join comment_details cd ON pd.ID =cd.POST_ID where cd.POST_ID = :postId", nativeQuery = true)
	public List<PostComents> getCommentsByPostId(@Param(value = "postId") Integer postId);
}
