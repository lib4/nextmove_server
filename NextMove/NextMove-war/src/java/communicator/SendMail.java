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
    
    
    public static String MOVE_MAIL_TEMPLATE_HEAD    =   "<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "<style>table,th,td{border:1px solid black;border-collapse:collapse;}</style>"+
"    </head>\n" +
"    <body>\n" +
"        <h3 style=\"color:#40B3DF;\">Dear Vendor</h3>\n" +
"        <P>You have new quote request and here is the Move details:- </P>\n"+
            "<table style=\"width:300px\">\n";

   

    
    
    
       public static String MOVE_MAIL_TEMPLATE_END   =   " </table>\n</body>\n</html>\n" ;
    public static void SendMail(){
        
        
        
        final String username = "anaschaky@gmail.com";
		final String password = "wonderful_shari";
 
		

        
        // Recipient's email ID needs to be mentioned.
      String to = "anaschaky@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "anaschaky@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";

      
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
      

     String table;
         
          
              table =   "<tr><td>Small Box</td><td>10</td></tr>"+
                     "<tr><td>Medium Box</td><td>10</td></tr>"+
                     "<tr><td>Large Box</td><td>10</td></tr>"+
                      "<tr><td>Item Wont Fit In Box</td><td>10</td></tr>"+
                     "<tr><td>Item Wont Fit In Elevator</td><td>10</td></tr>"+
                     "<tr><td>Item Requires Disassembly</td><td>10</td></tr>"+
                     
                     "<tr><td>From Address</td><td>Bangalore Karnataka, India.</td></tr>"+
                     "<tr><td>To Address</td><td>Salem Tamil Nadu, India.</td></tr>";
                     
    
    
        System.out.println("Mail Content "+MOVE_MAIL_TEMPLATE_HEAD+table+MOVE_MAIL_TEMPLATE_END);
    
    
    
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
         int i=0;
          
             
             
             
        
          // Send the actual HTML message, as big as you like
         message.setContent(MOVE_MAIL_TEMPLATE_HEAD+table+MOVE_MAIL_TEMPLATE_END,
                            "text/html" );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }

    }
}
