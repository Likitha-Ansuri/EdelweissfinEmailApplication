package com.example.demo.MailerApplication.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.MailerApplication.service.MailService;

@Controller
public class MailController {
	static String sender;
	@Autowired
	private MailService mailservice;
	@RequestMapping("/mail")
	public String Login() {
		return "login";
	}
	String body1;
	public void checkCredentials() throws Exception {
	File file = new File("C:\\Users\\la21099\\Downloads\\MailerApplicationTaskForEdelweissfin\\MailerApplication\\src\\files\\mailBody.txt");
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  while ((body1 = br.readLine()) != null) {
		  
	  }
	}
	  
	  @RequestMapping("/home")
	public String homePage(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		if(name.equals("testing20201011@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			System.setProperty("app.smail",sender);
			return "home";
		}
		
		else if(name.equals("testing20201012@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201013@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201014@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201015@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
	  else {
			return "wrongcredentials";
		}
		
	}
	

	@RequestMapping("/sendmail")
	public String sendMail(HttpServletRequest req,HttpServletResponse res)throws Exception {
		String subject=req.getParameter("subject");
		String body= req.getParameter("body");
		  String attachment1 = req.getParameter("attachments");
		 
	
		 
		 for(int i =1;i<=5;i++) {
		
		 String str=sender.substring(0, 14);
		
		  if(sender.equals("testing20201015@yahoo.com")) {
		mailservice.sendMailMethod(str+i+"@yahoo.com", body1 , subject,sender,"D:\\attachment.txt");
		
	} else {
		System.out.println("mail has not sent");
	}
	}
		 return "successfull";
}
}
