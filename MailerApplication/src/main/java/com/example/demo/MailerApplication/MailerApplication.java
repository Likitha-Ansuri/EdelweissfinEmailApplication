package com.example.demo.MailerApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailerApplication {
	public static void main(String[] args) {
		
		SpringApplication.run(MailerApplication.class, args);
		
	}

}
