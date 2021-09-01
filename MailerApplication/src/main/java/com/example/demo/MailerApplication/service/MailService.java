package com.example.demo.MailerApplication.service;

import java.io.File;
import java.io.FileWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	 private JavaMailSender mailSender;
	    private SimpleMailMessage simpleMailMessage;
	    
	    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
	        this.simpleMailMessage = simpleMailMessage;
	    }

	    public void setMailSender(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }
	    
	public void sendMailMethod(String toEmail, String body, String subject,String from,String attachments)
			throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessagehelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessagehelper.setFrom(from);
		mimeMessagehelper.setTo(toEmail);
		mimeMessagehelper.setText(body);
		mimeMessagehelper.setSubject(subject);
		FileSystemResource filesystem = new FileSystemResource(new File(attachments));
		//DataSource source = new FileDataSource(attachments);
		mimeMessagehelper.addAttachment(filesystem.getFilename(), filesystem);
		mailSender.send(mimeMessage);
		System.out.println("successfully sent");
		
	}
}

