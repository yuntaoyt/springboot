package com.taotao.jmsTest;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueL {
	 @JmsListener(destination="queuetest")
	 public  void  show(String me){
		System.out.println(me+"sssssssssss=============");
	}

}
