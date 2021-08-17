package com.tutorialproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutorialproject.model.BlogComment;
import com.tutorialproject.model.BlogsModel;

public interface CommentsRepo extends JpaRepository<BlogComment,Integer> {

//	@Query("SELECT u FROM BlogComment u WHERE u.post=?1 and u.parentComment is null")
	@Query(value = "SELECT * FROM blog_comment u WHERE u.post_id =?1 and u.parent_id is NULL", nativeQuery = true)
	List<BlogComment> findAllByParentAndPostt(BlogsModel post);
//	@Query(value = "SELECT * FROM blog_comment u WHERE u.post_id =?1 and u.parent_id is NULL", nativeQuery = true)
	@Query("SELECT u FROM BlogComment u WHERE u.post=?1 and u.parentComment is not null")
	List<BlogComment> findByPostAndParent(BlogsModel post);

}
