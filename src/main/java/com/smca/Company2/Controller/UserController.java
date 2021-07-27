package com.smca.Company2.Controller;


import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.smca.Company2.Models.User1;
import com.smca.Company2.Repository.UserRepository;


@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/signup",method=RequestMethod.POST)
	public String Stringreactuserapi(@RequestHeader User1 user) throws AddressException, MessagingException {	
		
		User1 usrsaved = userRepository.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "UserController");
		headers.add("Access-Control-Allow-Origin", "*");
		sendemail(user.getId()) ;
		
		return user.toString();
	}
	
	public void sendemail(Long userid) throws AddressException, MessagingException {

	      	User1 user = userRepository.getById(userid);	

			final String username = "socgentraining@gmail.com";
			final String password = "suckgensucks";

			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("socgentraining@gmail.com"));
				message.setRecipients(
						Message.RecipientType.TO,
						InternetAddress.parse(user.getEmail())
						);
				message.setSubject("User confirmation email");
				//     message.setText("Dear Mail Crawler,"
				//           + "\n\n Please do not spam my email!");
				message.setContent(
						"<h1><a href =\"http://127.0.0.1:8080/confirmuser/"+userid+"/\"> Click to confirm </a></h1>",
						"text/html");
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	
	@RequestMapping(value="/confirmuser/{userid}", method=RequestMethod.GET)
	public String welcomepage(@PathVariable Long userid) {
		Optional<User1> userlist =   userRepository.findById(userid);
		//do a null check for home work
		User1 usr = new User1();
		usr = userRepository.getById(userid);
		usr.setConfirmed(true);
		userRepository.save(usr);
		return "User confirmed" +usr.getUsername();
	}
	


}
