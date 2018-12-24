package com.taotao.ds;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  // 同service 等一样   只不过分开了能够分青
public class DingShi {
	 
	 @Scheduled(cron="*/6 * * * * ?")
	public  void  show(){
		System.out.println("定时任务---------------------------");
	}
}
