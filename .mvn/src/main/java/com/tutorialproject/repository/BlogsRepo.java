package com.tutorialproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorialproject.model.BlogsModel;
@Repository
public interface BlogsRepo extends JpaRepository<BlogsModel, Integer>{

	BlogsModel findByBlogid(String id);

	@Modifying
	@Query(value="delete from BlogsModel bm where bm.blogid =?1")
	void deleteByBlogid(String blogid);
	
	@Modifying
	@Query(value="update blogs_model bm set bm.heading=?1 and bm.content=?2 and bm.detail_blog=?3 where bm.blogid=?4",nativeQuery = true)
	void updateBlog(String heading,String content,String detailBlog,String blogid);

}
