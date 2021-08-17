package com.tutorialproject.Service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
@Service
public class EmailService2{

  
    public static void sendEmail(String otp, String subject, String email) throws Exception {

        // Create a Properties object to contain connection configuration information.
    	  // Replace sender@example.com with your "From" address.
        // This address must be verified.
         final String FROM = "devansh@codingchimp.xyz";
         final String FROMNAME = "Devansh Popli";
    	
        // Replace recipient@example.com with a "To" address. If your account 
        // is still in the sandbox, this address must be verified.
         final String TO = email;
        
        // Replace smtp_username with your Amazon SES SMTP user name.
         final String SMTP_USERNAME = "AKIAYYGYTLNX5YGNX5HG";
        
        // Replace smtp_password with your Amazon SES SMTP password.
         final String SMTP_PASSWORD = "BEatXKT+IVF9uyqITsYaDNo9wHDBBFbSfxvVYpOiT0xd";
        
        // The name of the Configuration Set to use for this message.
        // If you comment out or remove this variable, you will also need to
        // comment out or remove the header below.
       //  final String CONFIGSET = "ConfigSet";
        
        // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
        // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
        // for more information.
         final String HOST = "email-smtp.us-east-1.amazonaws.com";
     	
         
     	
         
        
        // The port you will connect to on the Amazon SES SMTP endpoint. 
         final int PORT = 587;
        
         final String SUBJECT = subject;
        
         final String BODY = String.join(
        	    System.getProperty("line.separator"),
        	    "<h1>Welcome to CoreTechTutorials</h1>",
        	    "<p>your OTP: "+otp+"</p> ", 
        	    "<p>Please Contact through Contact us if you have any questions.</p> ", 
        	    "<a href='https://linktr.ee/devanshpopli/'>click here to get in touch with us for any query</a>",
        	    "<p>Regards,</p> ", 
        	    "<p>Devansh Popli</p> "
        	);

    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
       // msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
}