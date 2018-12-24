package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import org.springframework.stereotype.Service;

import com.taotao.service.showservice;

@Service  // 这个是service 层得  一般都用  service 和  repository（dao）   controller（controller） ，component（分不清得层） 等效
public class SpringbootTestService implements showservice {
	public  List<Map<String,Object>>   show(){
		List<Map<String,Object>>  list  = new ArrayList<Map<String,Object>>();
		Map<String,Object>map  = new HashMap<String,Object>();
		map.put("yuntao","云涛");
		map.put("wangying", "王莹");
		list.add(map);
		return  list;
	}
}
