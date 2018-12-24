package com.taotao.controller;

import java.io.IOException;

import org.apache.activemq.filter.function.replaceFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.weixin.util.UtilsTest;
import com.taotao.service.weixin.util.token.Token;

/**
 * 创建会员卡
 * @author wangying
 * 下午12:33:21
 * WeiXinCreateCardController
 */ 
@Controller 
@RequestMapping("card")
public class WeiXinCreateCardController {
	@RequestMapping("createCard")
    public   String   createCard() throws IOException{
		String  url ="https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
		url=url.replace("ACCESS_TOKEN",Token.getTokeny());
		String  json="";
		UtilsTest.postqjjosn(url, json);
    	return  null;
    }
}
