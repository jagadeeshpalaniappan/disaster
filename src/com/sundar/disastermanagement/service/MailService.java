package com.sundar.disastermanagement.service;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

import com.sundar.disastermanagement.vo.IncidentVO;  

public class MailService {
    public void send(IncidentVO incidentVO){  
        //Get properties object
    	String mailID="sundarbtechict@gmail.com";
    	String sub="Flood";
    	String msg="Reported by "+incidentVO.getName()+"\t"+incidentVO.getMobile()+
    			"\n"+incidentVO.getDescription();
    	
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("aptitudeqnictas@gmail.com","ict@s1718");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);
     	System.out.println(mailID);
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailID));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);
         System.out.println("email sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  
}  
    

