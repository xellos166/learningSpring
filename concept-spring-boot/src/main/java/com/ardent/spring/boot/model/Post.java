package com.ardent.spring.boot.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

	private static final long serialVersionUID = 6663058415906897718L;

	private Integer id;
	private String postText;
	private String author;
	private Date date;

}
