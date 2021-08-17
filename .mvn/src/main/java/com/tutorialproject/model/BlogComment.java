package com.tutorialproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BlogComment implements java.io.Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonManagedReference
	private Integer sno;
	@Lob
	@Column(name = "comment",length =1337)
	private String comment;
	@ManyToOne(cascade = CascadeType.ALL)
	private UserModel user;
	@ManyToOne(cascade = CascadeType.ALL)
	private BlogsModel post;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="parent_Id")
	@JsonBackReference
	private BlogComment parentComment;
	@OneToMany(mappedBy = "parentComment")
	private List<BlogComment> subComments=new ArrayList<>();
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date created_at;
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public BlogsModel getPost() {
		return post;
	}
	public void setPost(BlogsModel post) {
		this.post = post;
	}
	public BlogComment getParentComment() {
		return parentComment;
	}
	public void setParentComment(BlogComment parentComment) {
		this.parentComment = parentComment;
	}
	public List<BlogComment> getSubComments() {
		return subComments;
	}
	public void setSubComments(List<BlogComment> subComments) {
		this.subComments = subComments;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public BlogComment(Integer sno, String comment, UserModel user, BlogsModel post, BlogComment parentComment,
			List<BlogComment> subComments, Date created_at) {
		super();
		this.sno = sno;
		this.comment = comment;
		this.user = user;
		this.post = post;
		this.parentComment = parentComment;
		this.subComments = subComments;
		this.created_at = created_at;
	}
	public BlogComment() {
		super();
	}
	

}
