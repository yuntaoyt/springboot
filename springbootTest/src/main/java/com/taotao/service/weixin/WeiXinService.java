package com.taotao.service.weixin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.taotao.service.weixin.util.BaseMessage;


/**
 * 接受 回复消息
 * @author wangying
 * 下午6:11:17
 * WeiXinService
 */
public interface WeiXinService {
   //接受用户发来的信息
   Map xinx(HttpServletRequest request);
   //回复用户信息  xml拼接最基本的使用
   String huixinx(Map map);   
   
}
