ackage enixlin.jrrc.net;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

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
	
	
	//提交请求
	public void sendRequest(){
		URL url=new URL(this.url);
		URLConnection urlConnection=url.openConnection();
		urlConnection.
		
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
