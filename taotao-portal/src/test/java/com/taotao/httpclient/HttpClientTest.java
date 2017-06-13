package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	@Test
	public void doGet() throws Exception {
		//创建一个httpclient对象
		//可以关闭的   是抽象类，不能直接new            工具类     
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet get = new HttpGet("http://www.sogou.com");//响应看不到文本面，只能看到文本
		//执行请求得到响应
		CloseableHttpResponse response = httpClient.execute(get);
		//取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();//响应的状态码
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();//响应的内容
		String string = EntityUtils.toString(entity, "utf-8");//解决乱码 charset=utf-8
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	//执行get请求带参数
	@Test                                       
	public void doGetWithParam() throws Exception{
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个uri对象
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");//基础
		uriBuilder.addParameter("query", "花千骨");//添加value  参数
		HttpGet get = new HttpGet(uriBuilder.build());
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPost() throws Exception {
		//创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个post对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");//做的事html请求
		//执行post请求   ------没有表单，只有一个空的请求 
		CloseableHttpResponse response = httpClient.execute(post);
		String string = EntityUtils.toString(response.getEntity());
		System.out.println(string);
		response.close();
		httpClient.close();
	}
	
//带参数的 post
	@Test
	public void doPostWithParam() throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//创建一个post对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
		//创建一个Entity。模拟一个表单       因为有多个所以相当于一个list
		List<NameValuePair> kvList = new ArrayList<>();
		//因为是接口，所以先找一个实现类
		kvList.add(new BasicNameValuePair("username", "zhangsan"));
		kvList.add(new BasicNameValuePair("password", "123"));
		
		//包装成一个Entity对象  实体    
		StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
		//设置请求的内容   提交时就会将参数带过去
		post.setEntity(entity);
		
		//执行post请求
		CloseableHttpResponse response = httpClient.execute(post);
		String string = EntityUtils.toString(response.getEntity());
		System.out.println(string);
		response.close();
		httpClient.close();
	}
}
