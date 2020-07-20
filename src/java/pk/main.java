/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import com.mysql.jdbc.PreparedStatement;
import com.sun.jndi.ldap.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class main {
   public static boolean sendmail(String id, String password, String email) {
  boolean istransmitted=false;
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session1 = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("morebhagyashree55@gmail.com","bhagya55**");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session1);  
   message.setFrom(new InternetAddress("morebhagyashree55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
   message.setSubject("User ID and Password");  
   message.setText("\n "+"User ID : "+id+"\n "+"Password : "+password); 
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
      throw new RuntimeException(e);
     
  } 
        return istransmitted;

    }


public static boolean sendconfirmationmail(String to,String from,String email) {
  boolean istransmitted=false;
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session1 = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("morebhagyashree55@gmail.com","bhagya55**");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session1);  
   message.setFrom(new InternetAddress("morebhagyashree55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
   message.setSubject("Leave Sanction");  
   message.setText("\n  Your are hereby granted Leave By Principle between the following Date : "+to+" To "+from); 
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
      throw new RuntimeException(e);
     
  } 
        return istransmitted;

    }

   public static boolean sendconfirmationmailfromHOD(String to,String from,String email) {
  boolean istransmitted=false;
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session1 = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("morebhagyashree55@gmail.com","bhagya55**");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session1);  
   message.setFrom(new InternetAddress("morebhagyashree55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
   message.setSubject("Leave Sanction From HOD");  
   message.setText("\n Your are hereby granted Leave By HOD between the following Date : "+to+" To "+from+"\n And Your Request Send To Principle....Wait For Principle Approval!!!!"); 
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
      throw new RuntimeException(e);
     
  } 
        return istransmitted;

    }

   
   
      
       public static boolean sendconfirmationmailfromHOD_Reject(String to,String from,String email) {
  boolean istransmitted=false;
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session1 = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("morebhagyashree55@gmail.com","bhagya55**");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session1);  
   message.setFrom(new InternetAddress("morebhagyashree55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
   message.setSubject("Leave Request Rejected From HOD");  
   message.setText("\n Your Leave Applicaton Reject By HOD between the following Date : "+to+" To "+from); 
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
      throw new RuntimeException(e);
     
  } 
        return istransmitted;

    }

       
         public static boolean sendconfirmationmailfromPRINCIPLE_Reject(String to,String from,String email) {
  boolean istransmitted=false;
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session1 = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("morebhagyashree55@gmail.com","bhagya55**");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session1);  
   message.setFrom(new InternetAddress("morebhagyashree55@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
   message.setSubject("Leave Request Rejected From PRINCIPLE");  
   message.setText("\n Your leave Application Rejected By PRINCIPLE between the following Date : "+to+" To "+from); 
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {
      throw new RuntimeException(e);
     
  } 
        return istransmitted;

    }

   

     public static int calran(){
         Random rand = new Random(); 
        int value = rand.nextInt(200);
        
        return value;
        
    }
    
}
