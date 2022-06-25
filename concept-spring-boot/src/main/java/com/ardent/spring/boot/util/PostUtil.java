package com.ardent.spring.boot.util;

import com.ardent.spring.boot.model.Post;
import com.ardent.spring.boot.model.request.PostRequest;

public class PostUtil {

	public static Post getPostFromPostRequest(PostRequest postRequest) {
		return new Post(null, postRequest.getPostText(), postRequest.getAuthor(), postRequest.getReaction(), null);
		// Post.builder().author(postRequest.getAuthor()).postText(postRequest.getPostText())
		// .reaction(postRequest.getReaction()).build();
	}

}
