package com.example.demo.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Step 3
@Entity
@Table(name = "POST_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "POST_TEXT")
	private String postText;

	@Column(name = "REACTION")
	private String reaction;

	@Column(name = "CREATED_DATE")
	private Date createdDate;
}
