package com.tutorialproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorialproject.model.UserModel;
@Repository
public interface UserRepo extends JpaRepository<UserModel, String> {
	UserModel findByEmailAndPassword(String email, String password);
	UserModel findByEmail(String email);
	UserModel findByUsername(String username);
	@Modifying
//	@Query(value="update user_model um set um.name=?1 and um.phone=?2 and um.email=?3 where um.username=?4",nativeQuery = true)
	@Query("update UserModel um set um.name=?1, um.phone=?2 , um.email=?3 where um.username=?4")
	void update(String name,String phone,String email,String username);
	
	@Modifying
	@Query(value="update user_model umodel set umodel.password=?1,umodel.cpassword=?1 where umodel.username=?2",nativeQuery = true)
	void updatePassword(String password,String username);

}
