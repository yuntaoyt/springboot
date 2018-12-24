package com.taotao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;
import com.taotao.service.weixin.WeiXinService;
import com.taotao.service.weixin.util.Article;
import com.taotao.service.weixin.util.BaseMessage;
import com.taotao.service.weixin.util.NewsMessage;
import com.taotao.service.weixin.util.TextMessage;
import com.thoughtworks.xstream.XStream;

/**
 * 测试微信 公众号的使用
 * @author wangying
 * 下午9:18:03
 * WeiXinController
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinController {
	
	@Autowired
	private  WeiXinService weiXinService; 
	
	@RequestMapping("/show")
	public  String  show(HttpServletRequest  request,HttpServletResponse  response) throws NoSuchAlgorithmException, IOException{
		//设置相应格式
		response.setCharacterEncoding("utf-8");
		String signature=  request.getParameter("signature");
		String timestamp=  request.getParameter("timestamp");
		String nonce=  request.getParameter("nonce");
		String echostr=  request.getParameter("echostr"); 
		
		//start   认证连接成功没成功
		boolean  renzheng =check(timestamp,nonce,signature);
		PrintWriter out = response.getWriter();
		if(renzheng){
			//认证成功需要给返回 echostr
			out.println(echostr);
		}else{
			System.out.println("连接不成功");
		}
		
		if(request.getInputStream().available()>0){
	     //接收文本信息
	     Map<String,Object>maps =this.receiveMessage(request);
	     System.out.println(maps);
	    
	   //回复文本信息  基本的xml    
	   /*String  huixin =weiXinService.huixinx(maps);
	   out.write(huixin);*/
	  
	    //回复信息 
	   String xml = receiveMessagez(maps,response);
	   out.write(xml);
	   out.flush();
	   out.close();
	    }
	 return  null;
	}
     /**
      *  回复消息总的判断
      *return: String
      * 时间：下午9:14:48
      * 参数：@param maps
      * 参数：@return
     * @throws IOException 
      */
	 public  static String  receiveMessagez(Map<String,Object>maps,HttpServletResponse response) throws IOException{
		 String msg =(String) maps.get("MsgType");      //拿到消息类型
		 String content =(String) maps.get("Content");  //拿到内容
		 BaseMessage  ba =null;
		 String xml="";
		 switch (msg) {
		 //文本
		 case "text":
			 if(content.contains("图文")){
				 Article  article  = new Article();
				 article.setTitle("这个是一个标题");
				 article.setDescription("这个是一个标题描述");
				 article.setUrl("http://www.baidu.com");
				 article.setPicUrl("http://mp.weixin.qq.com/s?__biz=MzIxMTkwNDc4Nw==&mid=2247501225&idx=1&sn=f99c968ded9b8099f0d8b65164a448a1&chksm=974cb5d5a03b3cc384944558b9420ccd79f43e9a95da2b591a65e0ad0be7dba203c17c34bb21&scene=0&xtrack=1#rd");
				 List<Article>list  = new ArrayList<>();
				 list.add(article);
				 ba = dNewsBaseMessage(maps,"1",list);
			 }else{
				 ba =dTextBaseMessage(maps,"你好啊");
			 }
			 break;
			 //图片		 
		 case "image":
             
			 break;
			 //语音		 
		 case "voice":

			 break;
			 //视频	 
		 case "video":

			 break;
			 //音乐	 
		 case "music":   

			 break;
		
		 default:
			 break;
		 }
		 XStream xStream  = new XStream();
		 xStream.processAnnotations(TextMessage.class); //设置根目录
		 xStream.processAnnotations(NewsMessage.class); //设置根目录
		 xml  =xStream.toXML(ba);
		 //System.out.println(ba);
		 return  xml; 
	 } 
	 /**
	  * 文本回复消息 
	  *return: BaseMessage
	  * 时间：下午8:41:24
	  * 参数：@return
	  */
	 public  static BaseMessage dTextBaseMessage(Map<String,Object>requestMap,String content){
		 TextMessage  t = new TextMessage(requestMap, content);
		 return  t;
	 }
	 /**
	  * 图文回复消息 
	  *return: BaseMessage
	  * 时间：下午8:41:24
	  * 参数：@return
	  */
	 public  static BaseMessage dNewsBaseMessage(Map<String,Object>requestMap,String content,List<Article>list){
		 NewsMessage  t = new NewsMessage(requestMap, content,list);
		 return  t;
	 }
	 /**
	  * 文本接受消息
	  *return: Map<String,Object>
	  * 时间：下午8:51:53
	  * 参数：@return
	  */
	 public  Map<String,Object>receiveMessage(HttpServletRequest  request){
		 Map<String,Object>receiveMessage =weiXinService.xinx(request);
		 return receiveMessage;
	 }
	
	/**
	 * 认证信息的对错
	 *return: boolean
	 * 时间：下午10:50:03
	 * 参数：@param timestamp
	 * 参数：@param nonce
	 * 参数：@param signature
	 * 参数：@return
	 * 参数：@throws NoSuchAlgorithmException
	 */
	public  boolean  check(String  timestamp,String nonce,String  signature) throws NoSuchAlgorithmException{
		String  token ="yt";
		String[] zifu = new String[]{timestamp,nonce,token};
		/*List list  = new ArrayList(Arrays.asList(zifu));
	    Collections.sort(list);*/
		Arrays.sort(zifu);
		String zifuc = zifu[0]+zifu[1]+zifu[2];
		boolean  renzhang =true;
		if(!StringUtils.isEmpty(zifuc)){
			MessageDigest   md  =MessageDigest.getInstance("sha1");
			byte[] ter = md.digest(zifuc.getBytes());
			char[]chars ={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			System.out.println(signature);
			StringBuilder  sbu  = new StringBuilder();
			for(byte s:ter){
				sbu.append(chars[(s>>4)&15]);
				sbu.append(chars[s&15]);
			}
			if(sbu.toString().equals(signature)){
				renzhang =true;
			}else{
				renzhang=false;
			}
		}
		return  renzhang;
	}
}
