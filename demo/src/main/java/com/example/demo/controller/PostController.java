package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postserice;
	
	/**
	 * @author DIBANGSHU
	 * @apiNote :Will Say Hello !!!+date
	 * @return
	 */
	
	@GetMapping("/hello")
	public String sayHello() {
		return postserice.sayHello();
	}
	
	/**
	 * @author DIBANGSHU
	 * @apiNote :
	 * @param post
	 * @return
	 */
	
	@PostMapping("/post")
	public Post craetePost(@RequestBody Post post) {
		return postserice.createpost(post);
	}

}
