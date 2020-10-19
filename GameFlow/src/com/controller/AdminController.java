package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bo.User;

@Controller
@SessionAttributes("alfsession")
@RequestMapping("/adminController")
public class AdminController {
	@RequestMapping("/showPage")
	public ModelAndView showPage() {
		System.out.println("inside admin controller");
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("RegisterUser");
		return modelandView;
	}

	@RequestMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, Object> data) throws IOException {
		System.out.println("inside register controller");
		String username = String.valueOf(data.get("username"));
		String password = String.valueOf(data.get("password"));
		System.out.println("u==" + username);
		System.out.println("p===" + password);
		
	File myObj = new File("D:\\dt.properties");
	Properties p = new Properties();
	p.setProperty(username, password);
    p.store(new FileWriter(myObj), "");
	
		return null;
	}

	@RequestMapping("/success")
	public ModelAndView success() {
		System.out.println("inside admin controller");
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("Success");
		return modelandView;
	}
	
	@RequestMapping("/startTest")
	public ModelAndView startTest() {
		System.out.println("inside admin controller");
		ModelAndView modelandView = new ModelAndView();
	      	modelandView.setViewName("StartTest");
		return modelandView;
	}
	
	@RequestMapping("/verifyUser")
	public ResponseEntity<Map<String, Object>> verifyUser(@RequestBody Map<String, Object> data) throws IOException {
		
		Map<String, Object> responseMap = new HashMap<>();
		StringBuilder sbErrorMessages = new StringBuilder();
		User userName=new User();
		ModelAndView modelandView=new ModelAndView();
		
		String user = String.valueOf(data.get("user"));
		String pwd = String.valueOf(data.get("pwd"));
		System.out.println("user==" + user);
		System.out.println("pwd===" + pwd);
		
		String filePath = "D:\\dt.properties"; 
		 InputStream input = null;
		 Properties prop = new Properties();
		 input = new FileInputStream(new File(filePath));
		  prop.load(input); 
		  System.out.println("value==="+prop.getProperty(user));
		  
		  String value=prop.getProperty(user);
		  if(value.equals(pwd)) {
			  sbErrorMessages.append("success");
			  System.out.println("valid>>>");
			  userName.setName(user);
			  modelandView.addObject("alfsession", userName);
			  System.out.println("get user"+userName.getName());
		  }else {
			  sbErrorMessages.append("failed");
			  System.out.println("invalid>>>");
		  }
		  System.out.println(sbErrorMessages.toString());
		  responseMap.put("sbErrorMessages", sbErrorMessages.toString());
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}
}
