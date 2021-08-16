package com.tutorialproject.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="otp",uniqueConstraints = @UniqueConstraint(columnNames={"email"}))
public class otp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="otp_id")
private int otp_id;
@Column(name="email",unique = true)
private String email;
@Column(name="otp")
private String otp;
@Column(name="otpRequestedTime")
private Date otpRequestedTime;

public otp(int otp_id, String email, String otp, Date otpRequestedTime) {
	super();
	this.otp_id = otp_id;
	this.email = email;
	this.otp = otp;
	this.otpRequestedTime = otpRequestedTime;
   
}
public Date getOtpRequestedTime() {
	return otpRequestedTime;
}
public void setOtpRequestedTime(Date date) {
	this.otpRequestedTime = date;
}
public int getOtp_id() {
	return otp_id;
}
public void setOtp_id(int otp_id) {
	this.otp_id = otp_id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public otp(int otp_id, String email, String otp) {
	super();
	this.otp_id = otp_id;
	this.email = email;
	this.otp = otp;
}
public otp() {
	super();
}

}
