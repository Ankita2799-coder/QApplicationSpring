package com.tutorialproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class BlogsModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String blogid;
	String heading;
	@Column(name = "content",length =1337)
	String content;
	@Lob 
	@Column(name = "detailBlog",length =1337)
	String detailBlog;
	@OneToMany(mappedBy = "post")
	List<BlogComment> comments;
	public BlogsModel(int id, String blogid, String heading, String content, String detailBlog) {
		super();
		this.id = id;
		this.blogid = blogid;
		this.heading = heading;
		this.content = content;
		this.detailBlog = detailBlog;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getDetailBlog() {
		return detailBlog;
	}
	public void setDetailBlog(String detailBlog) {
		this.detailBlog = detailBlog;
	}
	public String getBlog_id() {
		return blogid;
	}
	public void setBlog_id(String blog_id) {
		this.blogid = blog_id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public BlogsModel() {
		super();
	}

}
