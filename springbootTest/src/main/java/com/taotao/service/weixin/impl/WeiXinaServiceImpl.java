package com.taotao.service.weixin.impl;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.taotao.service.weixin.WeiXinService;
import com.taotao.service.weixin.util.token.Token;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@Service
public class WeiXinaServiceImpl implements WeiXinService {
    /**
     * 接收信息
     */
	@Override
	public Map xinx(HttpServletRequest request){
		try {
			ServletInputStream input = request.getInputStream();
			SAXReader   sreader  = new SAXReader();
			Document doc = sreader.read(input,"UTF-8");
			Element el = doc.getRootElement();
			List <Element>list = el.elements();
			Map<String,Object>map  = new HashMap<>();
			for(Element els:list){
			    map.put(els.getName(), els.getStringValue());
			}		
			return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return  null;
	}
     /**
      * 回复信息
      */
	@Override
	public String huixinx(Map  map) {
         String xml ="<xml><ToUserName><![CDATA["+map.get("FromUserName")+"]]></ToUserName><FromUserName><![CDATA["+map.get("ToUserName")+"]]></FromUserName><CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[why?]]></Content></xml>";	     
		 return xml;
   }
}
