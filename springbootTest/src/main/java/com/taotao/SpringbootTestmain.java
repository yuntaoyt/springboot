package com.taotao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableScheduling    //开启定时任务
public class SpringbootTestmain {
	public static void main(String[] args) {
		System.out.println("ssss");
         SpringApplication.run(SpringbootTestmain.class, args);
	}
}

