package com.tutorialproject.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorialproject.model.otp;
@Repository
public interface otpRepository extends JpaRepository<otp, Integer> {

	otp findByEmail(String email);
	@Modifying
    @Query(value="update otp u set u.otp=?1, u.otp_requested_time=?2 where u.email = ?3",nativeQuery = true)
	public void updateByEmail(String otp,Date date,String email);
}
