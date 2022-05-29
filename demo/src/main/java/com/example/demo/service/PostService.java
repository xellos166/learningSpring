package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Post;
import com.example.demo.model.response.PostCommentResponse;

public interface PostService {

	public String sayHello();

	public Post createpost(Post post);

	public List<Post> getAll();

	public Post getPostById(long id);

	public List<Post> getPostByAuthorAndReaction(String author, String reaction);

	public List<PostCommentResponse> getCommentsFoAPost(Long postId);

}
