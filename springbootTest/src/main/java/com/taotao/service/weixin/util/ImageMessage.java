package com.taotao.service.weixin.util;

import java.util.Map;

/**
 * 图片上传
 * @author wangying
 * 上午11:48:12
 * ImageMessage
 */
public class ImageMessage  extends  BaseMessage{

	public  String mediaId;  //通过素材管理中的接口上传多媒体文件，得到的id。
 
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public ImageMessage(Map<String, Object> requestMap, String mediaId) {
		super(requestMap);
		this.setMsgType("image");
		this.mediaId = mediaId;
	}
}
