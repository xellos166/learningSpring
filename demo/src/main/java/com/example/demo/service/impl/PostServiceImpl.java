package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.model.dto.PostCommentDTO;
import com.example.demo.model.entity.PostEntity;
import com.example.demo.model.response.PostCommentResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepo;

	private static List<Post> postStore;
	private static int id = 0;
	static {
		postStore = new ArrayList<Post>();
	}

	@Override
	public String sayHello() {

		return "Hello !!! " + new Date();
	}

	@Override
	public Post createpost(Post post) {
		/*
		 * post.setId(++id); postStore.add(post);
		 */

		// DTO to entity conversion
		PostEntity postEntity = PostEntity.builder().author(post.getAuthor()).postText(post.getPostText())
				.reaction(post.getReaction()).createdDate(new java.sql.Date(System.currentTimeMillis())).build();
		postEntity = postRepository.save(postEntity);

		post.setId(postEntity.getId());
		return post;
	}

	private Post getPost(PostEntity entity) {
		return Post.builder().author(entity.getAuthor()).postText(entity.getPostText()).reaction(entity.getReaction())
				.id(entity.getId()).build();
	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		// return postStore;
		List<Post> result = new ArrayList<Post>();
		postRepository.findAll().forEach(x -> result.add(getPost(x)));
		return result;
	}

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		/*
		 * for (Post p : postStore) { if (p.getId() == id) { return p; } }
		 */
		Optional<PostEntity> pe = postRepository.findById(id);
		return getPost(pe.get());
		// return postStore.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	@Override
	public List<Post> getPostByAuthorAndReaction(String author, String reaction) {
		/*
		 * List<Post> l = new ArrayList<Post>(); for (Post p : postStore) { if
		 * (p.getAuthor().equalsIgnoreCase(author) &&
		 * p.getReaction().equalsIgnoreCase(reaction)) { l.add(p); } } return l;
		 */

		List<PostEntity> postEntityList = postRepository.findAllByAuthorAndReaction(author, reaction);
		List<Post> listOfPost = new ArrayList<>();
		for (PostEntity p : postEntityList) {
			listOfPost.add(getPost(p));
		}
		return listOfPost;
		/*
		 * return postStore.stream() .filter(p -> p.getAuthor().equalsIgnoreCase(author)
		 * && p.getReaction().equalsIgnoreCase(reaction)) .collect(Collectors.toList());
		 */
	}

	private PostCommentResponse getPostResponse(PostCommentDTO pdto) {
		return PostCommentResponse.builder().author(pdto.getPostAuthor()).postId(pdto.getPostId())
				.commentId(pdto.getCommentId()).commentText(pdto.getComment()).reaction(pdto.getPostReaction()).build();
	}

	@Override
	public List<PostCommentResponse> getCommentsFoAPost(Long postId) {
		List<PostCommentResponse> postCommentResponse = new ArrayList<>();
		List<PostCommentDTO> dto = commentRepo.getCommentForAPost(postId);
		for (PostCommentDTO p : dto) {
			postCommentResponse.add(getPostResponse(p));
		}
		return postCommentResponse;
	}

}
