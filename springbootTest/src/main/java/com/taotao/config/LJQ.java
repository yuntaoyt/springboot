package com.taotao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration    //这个是一个配置文件  类  
public class LJQ implements  WebMvcConfigurer{  //WebMvcConfigurer  这个接口是spingmvc 配置文件都可以在里面实现
    
	// 重写 spring 拦截器方法      
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		 // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
       // registry.addInterceptor(new com.taotao.ljq.LJQ()).addPathPatterns("/**");   //  所有的都拦截
        WebMvcConfigurer.super.addInterceptors(registry);  //往下执行拦截	
	}
}
