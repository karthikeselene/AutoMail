package utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AutomaticSendMail {
	
	public static void sendByGmail(String to,String subject){
		Properties prop = new Properties();
		String host = "smtp.gmail.com";
		String from = "karthike.selene@gmail.com";
		String pass = "Kavi@143";
		prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(prop);
        MimeMessage message = new MimeMessage(session);        
		try {			
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));			
			message.setSubject(subject);			
                
			Multipart multipart = new MimeMultipart();			
			//Resume
			MimeBodyPart messageBodyPart = new MimeBodyPart(); 
			String fileAttachment = "./Karthikeyan_Rajendran_5.3yrs_Automation_Test_Engineer.pdf"; 
			DataSource source = new FileDataSource(fileAttachment); 
			messageBodyPart.setDataHandler( new DataHandler(source)); 
			messageBodyPart.setFileName("Karthikeyan_Rajendran_5.3yrs_Automation_Test_Engineer.pdf");
			multipart.addBodyPart(messageBodyPart); 
			//Cover Letter
			MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
			DataSource source2 = new FileDataSource("./Karthikeyan_Rajendran_Cover_letter.pdf"); 
			messageBodyPart2.setDataHandler( new DataHandler(source2)); 
			messageBodyPart2.setFileName("Karthikeyan_Rajendran_Cover_letter.pdf");
			multipart.addBodyPart(messageBodyPart2); 
			//Html Content
			MimeBodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setContent(Content.readHtmlFile(), "text/html");
			multipart.addBodyPart(messageBodyPart3);
			message.setContent(multipart);		
			       
		    Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();		

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
