package com.taotao.service.weixin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图文信息
 * @author wangying
 * 上午11:19:56
 * NewsMessage
 */
@XStreamAlias("xml")
public class NewsMessage  extends BaseMessage{
 
	public NewsMessage(Map<String, Object> requestMap, String articleCount, List<Article> articles) {
		super(requestMap);
		this.setMsgType("news");
		this.articleCount = articleCount;
		this.articles = articles;
	}
	public String getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@XStreamAlias("ArticleCount")
	public  String  articleCount;
    @XStreamAlias("Articles")
	public List<Article> articles = new ArrayList<>(); 
	
	
	@Override
	public String toString() {
		return "NewsMessage [articleCount=" + articleCount + ", articles=" + articles + ", getToUserName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMsgType()=" + getMsgType() + "]";
	}
}
