package enixlin.jrrc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.omg.CORBA.NameValuePair;
import org.omg.CORBA.Request;


public class http_request {

	private ArrayList<NameValuePair> args;  //请求参数
	private String Method;  							//请求的方法get /post
	private String url;										//请求的网址
	
	
	
	//	建立get方式的请求
	public http_request(String method, String url) {
		super();
		Method = method;
		this.url = url;
	}
	//	建立Post方式的请求
	public http_request(ArrayList<NameValuePair> args, String method, String url) {
		super();
		this.args = args;
		Method = method;
		this.url = url;
	}
	
	//
	//提交请求
	public void sendRequest(){

		HttpGet get=new HttpGet(this.url);
		HttpPost post=new HttpPost();
		ArrayList<NameValuePair>arg=this.args;
		
		HttpClient client=(HttpClient) HttpClientBuilder.create();
				if(this.Method=="post" || this.Method=="POST"){
					try {
					HttpResponse response=	client.execute(post);
					HttpEntity entity=response.getEntity();
					InputStream is=entity.getContent();
					InputStreamReader inputStreamReader=new InputStreamReader(is);
					
					UrlEncodedFormEntity urlEncodedFormEntity=(UrlEncodedFormEntity) response.getEntity();

			
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
	}
		
	public ArrayList<NameValuePair> getArgs() {
		return args;
	}
	public void setArgs(ArrayList<NameValuePair> args) {
		this.args = args;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
