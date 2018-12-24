package com.taotao.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueTest {
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("queuetest");   //这个是某地地
	}
}
