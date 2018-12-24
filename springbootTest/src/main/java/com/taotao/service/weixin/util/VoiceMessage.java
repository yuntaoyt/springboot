package com.taotao.service.weixin.util;

import java.util.Map;

/**
 * 语音消息
 * @author wangying
 * 下午12:01:23
 * VoiceMessage
 */
public class VoiceMessage extends BaseMessage {
	public String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public VoiceMessage(Map<String, Object> requestMap, String mediaId) {
		super(requestMap);
		this.setMsgType("voice");
		this.mediaId = mediaId;
	}
}
