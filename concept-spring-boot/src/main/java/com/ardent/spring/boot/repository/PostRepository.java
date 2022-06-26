package com.ardent.spring.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ardent.spring.boot.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

	public List<Post> findAllByAuthor(String authorName);

}