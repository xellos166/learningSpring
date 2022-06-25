package com.ardent.spring.boot.model;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POST_DETAILS")
@Builder
public class Post implements Serializable {

	private static final long serialVersionUID = 6663058415906897718L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "POST_TEXT")
	private String postText;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "REACTION")
	private String reaction;

	@Column(name = "CREATED_DATE")
	private Date date;

}
