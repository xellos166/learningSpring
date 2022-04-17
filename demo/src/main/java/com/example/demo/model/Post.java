package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Post implements Serializable{
	
	
	//private static final long serialVersionUID = -7957072764145748648L;
	
	private String author;
	private String postText;
	private String reaction;
	private Integer id;

}
