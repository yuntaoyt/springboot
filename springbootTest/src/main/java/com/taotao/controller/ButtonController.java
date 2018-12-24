package com.taotao.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.weixin.util.UtilsTest;
import com.taotao.service.weixin.util.button.Button;
import com.taotao.service.weixin.util.button.ClickButton;
import com.taotao.service.weixin.util.button.SubButton;
import com.taotao.service.weixin.util.token.Token;

import net.sf.json.JSONObject;

/**
 * 按钮的使用
 * @author wangying
 * 下午5:27:14
 * ButtonController
 */
@Controller
@RequestMapping("button")
public class ButtonController {
	
	/**
	 * 创建按钮   这个直接调用可以
	 *return: String
	 * 时间：下午5:29:01
	 * 参数：@return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@RequestMapping("createbutton")
	@ResponseBody
	public   String  createbutton() throws ClientProtocolException, IOException{
		String  url ="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url=url.replace("ACCESS_TOKEN", Token.getTokeny());
		ClickButton  ck  = new ClickButton();
		ck.setName("一级菜单");
		ck.setType("click");
		ck.setKey("ttt");
		ck.setUrl("http://ytytyt.free.idcfengye.com/button/selectbuttonshijian");
		Button bu  = new Button();
		bu.getButton().add(ck);
		
		//二级菜单
		SubButton  sb = new SubButton();
		sb.setName("一级菜单二");
		ClickButton  ck1  = new ClickButton();
		ck1.setName("二级菜单1");
		ck1.setType("click");
		ck1.setKey("ttt");
		ck1.setUrl("http://ytytyt.free.idcfengye.com/button/selectbuttonshijian");
		ClickButton  ck2  = new ClickButton();
		ck2.setName("二级菜单2");
		ck2.setType("click");
		ck2.setKey("ttt");
		ck2.setUrl("http://ytytyt.free.idcfengye.com/button/selectbuttonshijian");
		sb.getSub_button().add(ck1);
		sb.getSub_button().add(ck2);
		bu.getButton().add(sb);
		//二级菜单
		SubButton  sb1 = new SubButton();
		sb1.setName("一级菜单三");
		ClickButton  ck3  = new ClickButton();
		ck3.setName("二级菜单1");
		ck3.setType("view");
		ck3.setKey("ttt");
		ck3.setUrl("http://ytytyt.free.idcfengye.com/button/selectbuttonshijian");
		ClickButton  ck4  = new ClickButton();
		ck4.setName("二级菜单2");
		ck4.setType("view");
		ck4.setKey("ttt");
		ck4.setUrl("https://www.baidu.com");
		sb1.getSub_button().add(ck3);
		sb1.getSub_button().add(ck4);
		bu.getButton().add(sb1);
		
		
		
		JSONObject  jsonObject = JSONObject.fromObject(bu);
		jsonObject.toString();
		String  s  =UtilsTest.postqjjosn(url, jsonObject.toString());
		return   s;
	}
	/**
	 * 查询按钮
	 *return: String
	 * 时间：下午9:09:53
	 * 参数：@return
	 * @throws IOException 
	 */
	@RequestMapping("selectbutton")
	@ResponseBody
	public  String  selectbutton() throws IOException{
		String url  ="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
		url =url.replace("ACCESS_TOKEN", Token.getTokeny());
		String ter =UtilsTest.getjson(url);
		return  ter;
	}
	
	
	/**
	 * 查询点击事件
	 *return: String
	 * 时间：下午7:54:52
	 * 参数：@return
	 */
	@RequestMapping("selectbuttonshijian")
	public   String  selectbuttonshijian(){
		System.out.println("yuntao");
		return  null;
	}
	
}
