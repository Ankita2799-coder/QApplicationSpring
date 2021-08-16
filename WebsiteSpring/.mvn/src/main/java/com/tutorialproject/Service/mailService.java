package com.tutorialproject.Service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class mailService {

	@Autowired
	JavaMailSender mailSender;
	Random random=new Random();
//	public boolean sendEmail(String username, String password, String subject, String to){
//		boolean flag=false;
//		MimeMessage m1 = mailSender.createMimeMessage();
//		MimeMessageHelper m = new MimeMessageHelper(m1);
//		try {
//			m.setFrom("dvpopli@gmail.com");
//			m.setTo(to);
//			m.setSubject(subject);
//			String mailcontent="<p>Hi"+username+"</p>";
//			mailcontent+="<br>Your Otp: "+password;
//			mailcontent+="<br><br>Please Contact through Contact us if you have any questions.<br>";
//			mailcontent+="<br><br>Thankyou,<br>";
//			mailcontent+="CodersHeaven Team";
//			m.setText(mailcontent,true);
//			mailSender.send(m1);
//		    flag=true;
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		return flag;
//	}

	public boolean sendEmailsignup(String password, String subject, String to) throws Exception{
		System.out.println("inside send email function");
		boolean flag=false;
		MimeMessage m1 = mailSender.createMimeMessage();
		MimeMessageHelper m = new MimeMessageHelper(m1);
		try {
			m.setFrom("dvpopli@gmail.com");
			m.setTo(to);
			m.setSubject(subject);
			String mailcontent="<br>Your Otp: "+password;
			mailcontent+="<br><br>Please Contact through Contact us if you have any questions.<br>";
			mailcontent+="<br><br>Thankyou,<br>";
			mailcontent+="Regards,<br>Devansh Popli<br>CoretechTutorials Team";
			m.setText(mailcontent,true);
			System.out.println("sending email....");
			mailSender.send(m1);
			System.out.println("email sent");
		    flag=true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("messaging exception"+e.getMessage());
			throw new MessagingException();
		}
		catch(Exception e)
		{
			System.out.println("Internal server error"+e.getMessage()+e);
			throw new Exception();
		}
	
		return flag;
	}

	public int[] generateOTP() {
	
	int[] newpass=new int[6];
		for(int i=0;i<6;i++)
		{
			newpass[i]=random.nextInt(9);
		}
		return newpass;
	}


}
