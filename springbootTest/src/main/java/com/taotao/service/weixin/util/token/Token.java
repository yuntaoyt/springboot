package com.taotao.service.weixin.util.token;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class Token {
	public  static  final  String  APPID="wx6f7d3eea2f3882df";
	public  static final  String   APPSECRET="10df2896fba9b141e9da31377bead93e";
	public static String  at;
	public static String time;
	/**
	 * 拿到token
	 *return: void
	 * 时间：下午7:27:25
	 * 参数：@throws IOException
	 */
	public  static  void getTokenn() throws IOException{
		String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		url =url.replace("APPID",APPID).replace("APPSECRET", APPSECRET);
		String  tokens  =Token.get(url);
		JSONObject  js  = JSONObject.fromObject(tokens);
		String token =(String) js.get("access_token");
		at=token;
	}
	/**
	 * token 调用使用
	 *return: String
	 * 时间：下午9:57:21
	 * 参数：@return
	 * 参数：@throws IOException
	 */
	public static String getTokeny() throws IOException{
		if(at==null){
			getTokenn();
		}
		return at;
	}
   /**
    * 使用get  请求得到token
    *return: String
    * 时间：下午6:46:41
    * 参数：@param url
    * 参数：@return
    * 参数：@throws IOException
    */
   public  static String get(String  url) throws IOException{
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
