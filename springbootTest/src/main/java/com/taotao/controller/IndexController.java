package com.taotao.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		
	
		JSONArray li = JSONArray.fromObject(list);    //把array数组对象转换成 json
	    System.out.println(li.toString());
		
		 List ters =(List)JSONArray.toCollection(li); //jsonarray 转 对象
		 
		 MorphDynaBean tts=(MorphDynaBean)ters.get(0);
		 String name = (String) tts.get("name");
		 System.out.println(name);
		
		
		JSONObject ter  =JSONObject.fromObject(map1);   //把对象转换成  json
	    System.out.println("json的使用"+ter.toString());
	    
	    Map map  =(Map)JSONObject.toBean(ter,Map.class);//把json转成对象 
	    System.out.println(map);
	    
	    
	    Map  maps = new HashMap<>();
	    maps.put("list", list);
	    
	    JSONObject tes = JSONObject.fromObject(maps);    //对象换成json
	    System.out.println(tes.toString());
	    
		
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("name","y");
		return "index";
		
	}
}
