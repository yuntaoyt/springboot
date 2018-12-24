package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(Model model) {
		List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
		Map<String, Object> map1=new HashMap<>();
		map1.put("id", "01");
		map1.put("name", "shanghai");
		Map<String, Object> map2=new HashMap<>();
		map2.put("id", "02");
		map2.put("name", "xian");
		list.add(map1);
		list.add(map2);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("name","y");
		return "index";
		
	}
}
