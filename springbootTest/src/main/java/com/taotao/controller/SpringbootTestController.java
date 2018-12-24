package com.taotao.controller;


import java.io.File;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.dao.Book;
import com.taotao.service.showservice;

@Controller
public class SpringbootTestController {
	
	
    private Logger  logger = LoggerFactory.getLogger(this.getClass());
	@Autowired   // 和 resource  等效
	public    showservice  showservice;
	
	//取属性值
	@Value(value="${book.name}")
	private String bookname ;
	
	@Autowired
	public Book  book;
	
	@RequestMapping("/show")
	public  String show(HttpServletRequest request, HttpServletResponse  response,@RequestParam(value = "filename", required = false)MultipartFile file) throws IllegalStateException, IOException{
		String name  =request.getParameter("sname");
		String ter="";
		if(file!=null&&!file.equals("")){
		 ter  =file.getOriginalFilename();
		 File files  = new File("D:/filesc/"+ter);
			file.transferTo(files);
		}
		
		Map maps  = new HashMap();
		System.out.println("sss");
		maps.put("1","y");
		maps.put("2","ww");
		maps.put("3","y");
		
		
		System.out.println("yuntao");
		System.out.println(bookname);
		System.out.println(book.getName()+"-----------");
		List<Map<String,Object>>list  =showservice.show();
	    for (Map<String, Object> map : list) {
			String yuntao =map.get("yuntao").toString();
			System.out.println(yuntao);
		}
		System.out.println("yuntyao");
		logger.info("yuntao"+"---------------");
		return  "Test";
	}
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping("jmstest")
	public  void send(){
		System.out.println("yuntao");
		jmsTemplate.send("queuetest",new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage test = session.createTextMessage("yuntao");
				System.out.println("sss");
				return test;
			}
		});
		
	}
	@RequestMapping("/shows")
	public void show2(){
		System.out.println("sss");
	}
}
