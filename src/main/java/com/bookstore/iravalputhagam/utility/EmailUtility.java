package com.bookstore.iravalputhagam.utility;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {

	@Autowired
	private JavaMailSender sender;

	public void sendEmail(String recipient, String subject, String mailText) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(recipient);
		helper.setText(mailText,true);
		helper.setSubject(subject);
		sender.send(message);
	}
}
