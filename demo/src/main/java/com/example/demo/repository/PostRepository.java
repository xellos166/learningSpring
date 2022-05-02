package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.PostEntity;

//IN GENERIK CLASS FIRST IS WHICH CLASS WILL BE INSEART AND SECOND IS ID TYPES
@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
	// WRITE FIRST find THEN IF IT WILL RETURN MULTIPLE VALUES THEN WRITE
	// AllBy IF IT WILL RETURN ONLY ONE RECORD THEN WRITE By
	// FINALLY findAllBy OR findBy
	// IF MY QUERY IS CONTAIN AND OR CONDITION THEN WRITE And, Or.
	// FINALLY SYNTAX IS findByEntityFild1AndEntity2(Values)
	List<PostEntity> findAllByAuthorAndReaction(String author, String reaction);
}
