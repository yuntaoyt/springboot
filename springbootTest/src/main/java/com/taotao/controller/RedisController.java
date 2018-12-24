package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.taotao.redis.RedisSeviceTest;

@Controller
public class RedisController {
    
	@Autowired
	private  RedisSeviceTest redisServiceTest;
	
	/**
	 * 使用
	 */
	@RequestMapping("/redistest")
	public void show1(){
		/**
		 * string  
		 */
		redisServiceTest.setString("yuntao","yuntao");
		String name  =redisServiceTest.getString("yuntao");
		System.out.println(name);
		/**
		 * list  
		 */
		List list  = new ArrayList();
		list.add("yy");
		list.add("ww");
		redisServiceTest.setList("list",list);
		List li  =redisServiceTest.getList("list");
		/**
		 * map
		 */
		Map map  = new HashMap();
		map.put("y", "ss");
		map.put("w", "www");
		redisServiceTest.setHashMap("yy", map);
		Map<String, String> maps = redisServiceTest.getHashMap("yy");
	    System.out.println(maps);
		
	}
}
