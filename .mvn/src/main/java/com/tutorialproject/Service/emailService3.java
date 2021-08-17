package com.tutorialproject.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
@Service
public class emailService3 {
   public static void sendEmail() {
	   System.out.println("started email sending");
      //Declare recipient's & sender's e-mail id.
      String destmailid = "dvpopli@gmail.com";
      String sendrmailid = "devansh@codingchimp.xyz";	  
     //Mention user name and password as per your configuration
      final String uname = "devansh";
      final String pwd = "ankita27Verma";
      //We are using relay.jangosmtp.net for sending emails
      String smtphost = "codingchimp.xyz";
     //Set properties and their values
      Properties propvls = new Properties();
      propvls.put("mail.smtp.auth", "true");
      propvls.put("mail.smtp.starttls.enable", "true");
      propvls.put("mail.smtp.host", smtphost);
      propvls.put("mail.smtp.port", "25");
      //Create a Session object & authenticate uid and pwd
      Session sessionobj = Session.getInstance(propvls,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(uname, pwd);
	   }
         });

      try {
	   //Create MimeMessage object & set values
	   Message messageobj = new MimeMessage(sessionobj);
	   messageobj.setFrom(new InternetAddress(sendrmailid));
	   messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destmailid));
	   messageobj.setSubject("This is test Subject");
	   messageobj.setText("Checking sending emails by using JavaMail APIs");
	  //Now send the message
	   Transport.send(messageobj);
	   System.out.println("Your email sent successfully....");
      } catch (MessagingException exp) {
    	  System.out.println("here1"+exp.getMessage()+"cause"+exp.getCause());
         throw new RuntimeException(exp);
      }
      catch (Exception exp) {
    	  System.out.println("here2");
          throw new RuntimeException(exp);
       }
   }
}