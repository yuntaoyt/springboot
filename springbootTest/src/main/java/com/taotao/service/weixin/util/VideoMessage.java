package com.taotao.service.weixin.util;

import java.util.Map;

/**
 * 视频消息
 * @author wangying
 * 下午12:13:14
 * VideoMessage
 */
public class VideoMessage  extends BaseMessage{
	public  String mediaId;
	public String  title;	
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String description;
	public VideoMessage(Map<String, Object> requestMap, String mediaId, String title, String description) {
		super(requestMap);
		this.setMsgType("video");
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}
}
