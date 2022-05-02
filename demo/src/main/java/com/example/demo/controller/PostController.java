package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.service.PostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
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

	/*
	 * @author Sourav
	 * 
	 * @apiNote: it is a pathvariable exmp and it will return a string
	 * 
	 */
	@GetMapping("/helloallbypathvariable/{name}")
	public String sayHello(@PathVariable(name = "name") String name) {
		return "hello " + name;
	}

	/*
	 * @author Sourav
	 * 
	 * @apiNote: it is a pathvariable exmp and it will return a string
	 * 
	 */
	@GetMapping("/helloall/{name}")
	public ResponseEntity<Object> sayHelloNew(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Object>("hello " + name, HttpStatus.OK);
	}

	/*
	 * IT IS PATHVARIABLE WHATEVER WE ARE PASS AS PATH IT WILL LOAD ON name AND
	 * FOR @PathVariable AUTOMETICLY INISIALZE IN String name VARIABLE AND
	 * ApiResponse IS A CLASS WHICH IS USE FOR RETURN API RESPONSEAND AFTER BINDING
	 * ALL DATA WE ARE PASS BY ResponseEntity TO THE CLIENT HERE WE ARE USE IN
	 * ApiResponse CLASS @Builder SO NO NEED TO CREATE OBJECT JUST CALL builder()
	 * AND build(), AND AUTOMETICLY OBJECT WILL BE CREATED
	 */

	@GetMapping("/helloallwithcustomresponse/{name}")
	public ResponseEntity<ApiResponse> sayHelloWithCustomResponse(@PathVariable(name = "name") String name) {
		ApiResponse result = ApiResponse.builder().success(true).error(null).data("hello " + name).msg("OK").build();
		return new ResponseEntity<ApiResponse>(result, HttpStatus.OK);
	}

	/**
	 * @author DIBANGSHU
	 * @apiNote :
	 * @param post
	 * @return
	 */

	@PostMapping(path = "/post")
	public Post craetePost(@RequestBody Post post) {
		return postserice.createpost(post);
	}

	/*
	 * @GetMapping("/post/{id}") public Post getPostById(@PathVariable(name =
	 * "id")int id) { return postserice.getPostById(id); }
	 */

	/*
	 * IT IS PATHVARIABLE WHATEVER WE ARE PASS AS PATH IT WILL LOAD ON name AND
	 * FOR @PathVariable AUTOMETICLY INISIALZE IN String name VARIABLE AND
	 * ApiResponse IS A CLASS WHICH IS USE FOR RETURN API RESPONSEAND AFTER BINDING
	 * ALL DATA WE ARE PASS BY ResponseEntity TO THE CLIENT
	 */
	@GetMapping("/post/{id}")
	public ResponseEntity<ApiResponse> getPostById(@PathVariable(name = "id") long id) {
		ApiResponse result = new ApiResponse("OK", true, postserice.getPostById(id), null);
		/*
		 * ApiResponse.builder().success(true).error(null).data(postserice.getPostById(
		 * id)) .msg("POST FETCH SUCCESSFULLY").build();
		 */
		return new ResponseEntity<ApiResponse>(result, HttpStatus.OK);
	}

	/*
	 * WE ARE GETTING ALL DATA BY PASSING PATH
	 */

	@GetMapping("/posts")
	public List<Post> getPosts() {
		return postserice.getAll();
	}

	/*
	 * HERE WE ARE WORKING FOR CALL API USING KEYVALUE PAIRED HERE IN @RequestParam
	 * NAME IS KEY(id) required true MEAN PARAMETTER VALUE IS NEEDED defaultValue
	 * MEAN IF USER NOT PASS ANY VALUE THE ITS IS A DEFAULT VALUE (1)
	 */
	@GetMapping("/postwithqueryprm")
	public Post getPostByIdByQuery(@RequestParam(name = "id", required = true, defaultValue = "1") int id) {
		return postserice.getPostById(id);
	}

	/*
	 * HERE WE ARE PASSING TWO KEY VALUE PAIRED DATAS
	 */

	@GetMapping("/postwithquerymulprm")
	public List<Post> getPostByIdByMulQuery(
			@RequestParam(name = "author", required = true, defaultValue = "Sourav") String author,
			@RequestParam(name = "reaction", required = true, defaultValue = "haha") String reaction) {
		return postserice.getPostByAuthorAndReaction(author, reaction);
	}

	/*
	 * IT IS SAME AS @RequestParam BY PASSING KEY VALUE PAIRED BUT THIS API WILL
	 * CALL BY POST METHOD
	 */

	@PostMapping("/post_data_using_key")
	public ResponseEntity<ApiResponse> getPostByKey(
			@RequestParam(name = "id", required = true, defaultValue = "0") int id) {
		ApiResponse response = ApiResponse.builder().success(true).error(null).data(postserice.getPostById(id))
				.msg("SUCCESS").build();
		log.debug("getPostByKey called with id: {0}", id);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/postcomments/{postId}")
	public ResponseEntity<ApiResponse> getComment(@PathVariable(name = "postId") Long postId) {
		log.debug("get comment callled with {0}", postId);
		ApiResponse response = ApiResponse.builder().success(true).error(null)
				.data(postserice.getCommentsFoAPost(postId)).msg("SUCCESS").build();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}
