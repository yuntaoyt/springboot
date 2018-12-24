package com.taotao.service.weixin.util;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 消息基本属性公共的    （回复信息）
 * @author wangying
 * 下午8:01:51
 * BaseMessage
 */
public class BaseMessage {
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@XStreamAlias("ToUserName")
	public  String toUserName;  //发送者
	@XStreamAlias("FromUserName")
	public String fromUserName; //接受者
	@XStreamAlias("CreateTime")
	public String createTime;   //创建时间   
	@XStreamAlias("MsgType")
	public  String msgType;     //消息类型
   public BaseMessage(Map<String,Object>requestMap){
	   this.toUserName =(String) requestMap.get("FromUserName");     
	   this.fromUserName =(String) requestMap.get("ToUserName");     
	   this.createTime=System.currentTimeMillis()/1000+"";  // 时间秒          long转成 string
  }
}
