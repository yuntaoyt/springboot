package com.taotao.config;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class topicTest2 {
	
	@Bean
	public Topic queue(){
		return new ActiveMQTopic("topictest");   //这个是某地地
	}
}
