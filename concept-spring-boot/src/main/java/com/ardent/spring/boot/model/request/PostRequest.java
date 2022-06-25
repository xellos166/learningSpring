package com.ardent.spring.boot.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequest implements Serializable {

	private static final long serialVersionUID = 2797216234950232838L;
	private String postText;
	private String author;
	private String reaction;
}
