package com.tutorialproject.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialproject.model.BlogsModel;
import com.tutorialproject.repository.BlogsRepo;
@RestController
@CrossOrigin(origins = "*")
public class BlogsController
{
	@Autowired
	BlogsRepo blogrepo;
	
	@GetMapping("blogs")
	public List<BlogsModel> getBlogs()
	{
		List<BlogsModel> list=blogrepo.findAll();
		return list;
	}
	
	@GetMapping("blogs/{id}")
	public BlogsModel getBlogPost(@PathVariable("id") String id)
	{
		return blogrepo.findByBlogid(id);
		
	}
	@Transactional
	@DeleteMapping("blog/delete/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable("id") String blogid)
	{
		System.out.println(blogid);
			blogrepo.deleteByBlogid(blogid);
			return new ResponseEntity(202,HttpStatus.OK);
	}
	@PostMapping("insert")
	public ResponseEntity postBlog(@RequestBody BlogsModel bmodel)
	{
		 blogrepo.save(bmodel);
		 return new ResponseEntity(200,HttpStatus.OK);
	}
	
	@Transactional
	@PutMapping("edit/blog/{id}")
	public ResponseEntity<?> editBlog(@RequestBody BlogsModel bm)
	{
		blogrepo.updateBlog(bm.getHeading(), bm.getContent(), bm.getDetailBlog(), bm.getBlog_id());
		return new ResponseEntity(200,HttpStatus.OK);
	}
}
