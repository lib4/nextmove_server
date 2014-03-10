/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



/**
 *
 * @author aabuback
 */
public class SendMail {
    
    
    public static void SendMail(){
        
        
        
        final String username = "anaschaky@gmail.com";
		final String password = "wonderful_shari";
 
		

        
        // Recipient's email ID needs to be mentioned.
      String to = "anaschaky@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "web@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";

      
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
      

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
      
      

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Send the actual HTML message, as big as you like
         message.setContent("<h1>This is actual message</h1>",
                            "text/html" );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }

    }
}
