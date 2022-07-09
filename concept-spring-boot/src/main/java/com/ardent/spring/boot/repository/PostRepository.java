package com.ardent.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ardent.spring.boot.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

	public List<Post> findAllByAuthor(String authorName);

	@Query(value = "SELECT p FROM Post p WHERE p.author = :authorName")
	public List<Post> findAllByAuthorJpql(@Param(value = "authorName") String authorName);

	@Query(value = "SELECT * FROM post_details p WHERE p.AUTHOR = :authorName", nativeQuery = true)
	public List<Post> findAllByAuthorNativeQuery(String authorName);

}
