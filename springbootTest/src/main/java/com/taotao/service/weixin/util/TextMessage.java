package com.taotao.service.weixin.util;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本消息
 * @author wangying
 * 下午8:06:28
 * TextMessage
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
	@XStreamAlias("Content")
	public String content; //消息内容
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TextMessage(Map<String,Object>requestMap,String content) {
		super(requestMap);
		this.setMsgType("text");
		this.content=content;
	} 
	@Override
	public String toString() {
		return "TextMessage [content=" + content + ", getToUserName()=" + getToUserName() + ", getFromUserName()="
				+ getFromUserName() + ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType() + "]";
	}
}
