package com.tutorialproject.model;

public class CommentVO {

	private Integer parentCommentId;
	private String comment;
	private String blogId;
	private String email;
	public Integer getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public String getComments() {
		return comment;
	}
	public void setComments(String comment) {
		this.comment = comment;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CommentVO(Integer parentCommentId, String comment, String blogId, String email) {
		super();
		this.parentCommentId = parentCommentId;
		this.comment= comment;
		this.blogId = blogId;
		this.email = email;
	}
	
}
