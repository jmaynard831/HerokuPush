package com.jwtTestTwo.jwtTestTwo.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	private EmailCfg emailcfg;

	public SendEmail(EmailCfg emailcfg) {
		super();
		this.emailcfg = emailcfg;
	}

	public void SendEmailToUser(String username) {
		System.out.println("Sending Email to " + username);
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailcfg.getHost());
		mailSender.setPort(this.emailcfg.getPort());
		mailSender.setUsername(this.emailcfg.getUsername());
		mailSender.setPassword(this.emailcfg.getPassword());

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("JakesApp@java.com");
		mailMessage.setTo(username + "@youremail.com");
		mailMessage.setSubject("Welcome to the App, " + username);
		mailMessage.setText("Hey, welcome to the Todo app! You are now registered as a User. Add some items today!");

		mailSender.send(mailMessage);
	}

}
