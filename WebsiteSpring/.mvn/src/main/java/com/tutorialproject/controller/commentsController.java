package com.tutorialproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialproject.Service.CommentsService;
import com.tutorialproject.model.BlogComment;
import com.tutorialproject.model.CommentVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comments")
public class commentsController {
	@Autowired
	CommentsService commentsService;
    @PostMapping("/postComment")
	public ResponseEntity<?> postcomment(@RequestBody CommentVO comment)
	{
    	System.out.println("save comment process started"+comment.getComments());
    	try {
    	BlogComment blogComment=commentsService.saveComment(comment.getEmail(),comment.getComments(),comment.getBlogId(),comment.getParentCommentId());
    	return new ResponseEntity(blogComment,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    	}

	}
    @PostMapping("/getComments")
	public ResponseEntity<?> getComment(@RequestBody CommentVO post)
	{
    	System.out.println("get comment process started"+post.getBlogId());
    	try {
    	List<BlogComment> blogComment=commentsService.getCommentByPost(post.getBlogId());
    	return new ResponseEntity(blogComment,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    	}

	}
    @PostMapping("/getReplies")
   	public ResponseEntity<?> getReplies(@RequestBody CommentVO post)
   	{
       	System.out.println("get replies process started"+post.getBlogId());
       	try {
       	List<BlogComment> blogComment=commentsService.getCommentByParent(post.getBlogId());
       	return new ResponseEntity(blogComment,HttpStatus.OK);
       	}
       	catch(Exception e)
       	{
       		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       	}
   	}

}
