package com.taotao.service.weixin.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图文信息里面的元素
 * @author wangying
 * 上午11:20:12
 * Article
 */
@XStreamAlias("item")
public class Article {
	@XStreamAlias("Title")
	public  String title;
	@XStreamAlias("Description")
	public String description;
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
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@XStreamAlias("PicUrl")
	public String  picUrl;
	@XStreamAlias("Url")
	public String url;
}
