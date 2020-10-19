package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/questionController")
public class QuestionController {

	@RequestMapping("/queOne")
	public ModelAndView queOne() throws IOException {
		
		File myObj = new File("D:\\answer.properties");
		Properties p = new Properties();
	    p.store(new FileWriter(myObj), "");
		
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("QueOne");
		return modelandView;
	}
	
	@RequestMapping("/queTwo")
	public ModelAndView queTwo() {
		ModelAndView modelandView = new ModelAndView();
	modelandView.setViewName("QueTwo");
		return modelandView;
	}
	
	@RequestMapping("/queThree")
	public ModelAndView queThree() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("QueThree");
		return modelandView;
	}
	
	@RequestMapping("/queFour")
	public ModelAndView queFour() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("QueFour");
		return modelandView;
	}
	
	@RequestMapping("/queFive")
	public ModelAndView queFive() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("QueFive");
		return modelandView;
	}
	
	@RequestMapping("/sessionOut")
	public ModelAndView sessionOut() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("sessionOut");
		return modelandView;
	}
	
	@RequestMapping("/completedTest")
	public ModelAndView completedTest() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("CompletedTest");
		return modelandView;
	}
	
	@RequestMapping("/ansOne")
	public ResponseEntity<Map<String, Object>>
	verifyUser(@RequestBody Map<String, Object> data) throws IOException {
	System.out.println("inside first question>>>");
		String answer = String.valueOf(data.get("answer"));
		
		System.out.println(answer);
		
		Properties configProperty = new Properties();
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

      File file = new File("D:\\answer.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty("Is_String_Mutable?", answer);
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut, "");
		return null;
	}
	
	@RequestMapping("/ansTwo")
	public ResponseEntity<Map<String, Object>>
	ansTwo(@RequestBody Map<String, Object> data) throws IOException {
	System.out.println("inside first question>>>");
		String answer = String.valueOf(data.get("answer"));
		
		System.out.println(answer);
		
		Properties configProperty = new Properties();
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

        File file = new File("D:\\answer.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty("Is_Hashmap_thread-safe?", answer);
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut, "");
		return null;
	}
	
	@RequestMapping("/ansThree")
	public ResponseEntity<Map<String, Object>>
	ansThree(@RequestBody Map<String, Object> data) throws IOException {
	System.out.println("inside first question>>>");
		String answer = String.valueOf(data.get("answer"));
		
		System.out.println(answer);
		
		Properties configProperty = new Properties();
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

        File file = new File("D:\\answer.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty("Can_we_override_main_method?", answer);
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut, "");
		return null;
	}
	
	@RequestMapping("/ansFour")
	public ResponseEntity<Map<String, Object>>
	ansFour(@RequestBody Map<String, Object> data) throws IOException {
	System.out.println("inside first question>>>");
		String answer = String.valueOf(data.get("answer"));
		
		System.out.println(answer);
		
		Properties configProperty = new Properties();
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

        File file = new File("D:\\answer.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty("Is_Multiple_inheritance_supported_in_java?", answer);
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut, "");
		return null;
	}
	
	@RequestMapping("/ansFive")
	public ResponseEntity<Map<String, Object>>
	ansFive(@RequestBody Map<String, Object> data) throws IOException {
	System.out.println("inside first question>>>");
		String answer = String.valueOf(data.get("answer"));
		
		System.out.println(answer);
		
		Properties configProperty = new Properties();
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

        File file = new File("D:\\answer.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty("Is_StringBuffer_thread_safe?", answer);
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut, "");
		return null;
	}
	
	@RequestMapping("/viewData")
	public ResponseEntity<Map<String, Object>> viewData() {
		System.out.println("inside viewData");
		String result="";
		Map<String, Object> responseMap = new HashMap<>();
		StringBuilder sbErrorMessages = new StringBuilder();
		
		try {
		      File myObj = new File("D:\\answer.properties");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  result = result+myReader.nextLine()+"\n";  
		    	  
		      }
		      result = result.replaceAll("_", " ");
			  System.out.println(result);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		 responseMap.put("result", result);
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}
}
