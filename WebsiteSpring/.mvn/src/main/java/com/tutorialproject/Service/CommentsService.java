package com.tutorialproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorialproject.model.BlogComment;
import com.tutorialproject.model.BlogsModel;
import com.tutorialproject.model.UserModel;
import com.tutorialproject.repository.BlogsRepo;
import com.tutorialproject.repository.CommentsRepo;
import com.tutorialproject.repository.UserRepo;

@Service
public class CommentsService {
    @Autowired
	BlogsRepo blogsRepo;
    @Autowired
  	UserRepo userRepo;
    @Autowired
  	CommentsRepo commentsRepo;
    
	public BlogComment saveComment(String username, String comment, String postId, Integer parentCommentId) throws Exception {
		try {
		BlogComment blogComment=new BlogComment();
		if(comment!=null)
		blogComment.setComment(comment);
		if(parentCommentId!=null && !parentCommentId.equals(""))
		{
			BlogComment parentComment=commentsRepo.getById(parentCommentId);
		blogComment.setParentComment(parentComment);
		}
		BlogsModel post=blogsRepo.findByBlogid(postId);
		if(post!=null)
		blogComment.setPost(post);
		UserModel user= userRepo.findByEmail(username);
		if(user!=null)
		blogComment.setUser(user);
		if(blogComment!=null)
		{
		commentsRepo.save(blogComment);	
		System.out.println("data Saved Successfully");
		}
		return blogComment;
		}
		catch(Exception e)
		{
			System.out.println(e);
		throw new Exception("Error While Saveing Comment");
		}
		}

	public List<BlogComment> getCommentByPost(String postId) {
	BlogsModel post=blogsRepo.findByBlogid(postId);
	try {
	List<BlogComment> blogComments=commentsRepo.findAllByParentAndPostt(post);
	return blogComments;
	}
	catch(Exception e){
		System.out.println(e+"error while getting comments");
	}

	return null;
	}

	public List<BlogComment> getCommentByParent(String postId) {
		BlogsModel post=blogsRepo.findByBlogid(postId);
		//BlogComment parent=commentsRepo.getById(parentId);
		try {
		List<BlogComment> blogComments=commentsRepo.findByPostAndParent(post);
		return blogComments;
		}
		catch(Exception e) {
			System.out.println(e+"error while getting replies");	
		}
	return null;
	}

}
