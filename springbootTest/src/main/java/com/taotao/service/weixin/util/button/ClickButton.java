package com.taotao.service.weixin.util.button;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ClickButton  extends  Abutton{

	public String  type;
	public String key;
	public String  url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
