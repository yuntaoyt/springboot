package com.taotao.service.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class UtilsTest {
	
	/**
	 * post  请求   map 参数
	 *return: String
	 * 时间：下午10:13:51
	 * 参数：@param url
	 * 参数：@param map
	 * 参数：@return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String postqjmap(String url,Map<String,Object> map) throws ClientProtocolException, IOException{
		HttpClient httpclient = new DefaultHttpClient(); 
		HttpPost  httpPost = new HttpPost(url);
		String tesr="";
	     if(map.isEmpty()){
	    	   //参数列表
	    	  List<NameValuePair> params = new ArrayList<NameValuePair>();
	          for (Map.Entry<String, Object> entry : map.entrySet()) { 
	        	  //遍历map 把参数放在参数列表中
	              params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
	          }
	           //设置参数 并且设置编码格式
	           UrlEncodedFormEntity cs = new UrlEncodedFormEntity(params,  
	                    "utf-8");  
	           //请求加入参数 
	           httpPost.setEntity(cs); 
	           //执行方法
	           HttpResponse ter = httpclient.execute(httpPost);
	           //返回参数
	           tesr = EntityUtils.toString(ter.getEntity());
	           
	     } 
	     return  tesr;
	}
	
	/**
	 *   post 请求  参数是json
	 *return: String
	 * 时间：下午12:53:13
	 * 参数：@param url
	 * 参数：@param map
	 * 参数：@return
	 * 参数：@throws ClientProtocolException
	 * 参数：@throws IOException
	 */
	public static String postqjjosn(String url,String  json) throws ClientProtocolException, IOException{
		HttpClient httpclient = new DefaultHttpClient(); 
		HttpPost  httpPost = new HttpPost(url);
		String tesr="";
	     if(json!=null ||!json.equals("")){
	    	   //参数列表
	    	 /*List<NameValuePair> params = new ArrayList<NameValuePair>();
	           params.add(new BasicNameValuePair("json", json));
	           //设置参数 并且设置编码格式
	           UrlEncodedFormEntity cs = new UrlEncodedFormEntity(params,  
	                    "utf-8"); */ 
	           //请求加入参数 
	    	   StringEntity cs = new StringEntity(json,"utf-8");
	           httpPost.setEntity(cs); 
	           //执行方法
	           HttpResponse ter = httpclient.execute(httpPost);
	           //返回参数
	           tesr = EntityUtils.toString(ter.getEntity());
	     } 
	     return  tesr;
	}
	/**
	 * get  请求
	 *return: String
	 * 时间：下午10:23:18
	 * 参数：@param url
	 * 参数：@param map
	 * 参数：@return
	 */
	 public  static String getjson(String  url) throws IOException{
	       URL  u = new URL(url);
	       URLConnection returnurl = u.openConnection();
	       InputStream returntoken = returnurl.getInputStream();
	       byte[]b  = new byte[1024];
	       int i;
	       String tets ="";
	       while ((i=returntoken.read(b))!=-1) {
			  tets+=new String(b,0,i);
		    }
		    return  tets;
	   }
	
}
