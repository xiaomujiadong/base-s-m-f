package com.cwd.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
	
	public static final String POST = "POST";
	public static final String GET = "GET";
	public static final String KEEP_ALIVE = "Keep-Alive";
	public static final int SUCCESS_CODE = 200;
	
	
	public byte[] httpReuest(String method, String url, String params){
		if(method.equalsIgnoreCase(POST)){
			httpRequestByPost(url, params, null, null, true);
			return null;
		}else if(method.equalsIgnoreCase(GET))
			return httpRequestByGet(url, null, null, null, true);
		else
			return null;
	}
	
	public byte[] httpRequestByPost(String url, String params, String userAgent, String host, boolean isKeepAlive){
		if(url == null || "".equals(url.trim()))
			return null;
		
		try{
			URL urlObject = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)urlObject.openConnection();
			connection.setRequestProperty("Accept", "*/*");
			connection.setDoOutput(true);
			if(isKeepAlive)
				connection.setRequestProperty("connection", "Keep-Alive");
			if(host != null && "".equals(host.trim()))
				connection.setRequestProperty("Host", host);
			
			connection.connect();
			
			OutputStream os = connection.getOutputStream();
			
			if(params != null && "".equals(params.trim()))
				os.write(params.getBytes());
			
			int respCode = connection.getResponseCode();
			System.out.println("http respone code is " + respCode);
			if(SUCCESS_CODE == respCode){
				InputStream is = connection.getInputStream();
				ByteArrayOutputStream osArray = new ByteArrayOutputStream();
				
				int len = 0;
				byte[] dataByte = new byte[1024];
				while((len = is.read(dataByte, 0, dataByte.length)) <= 0){
					osArray.write(dataByte, 0, len);
				}
				is.close();
				
				return osArray.toByteArray();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public byte[] httpRequestByGet(String url, String contentType, String userAgent, String host, boolean isKeepAlive){
		if(url == null || "".equals(url.trim()))
			return null;
		try {
			URL urlObject = new URL(url);
			
			//打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection)urlObject.openConnection();
			
			connection.setRequestProperty("Accept", "*/*");
			if(isKeepAlive)
				connection.setRequestProperty("connection", "Keep-Alive");
			if(host != null && "".equals(host.trim()))
				connection.setRequestProperty("Host", host);
			
			connection.connect();
			
			if(SUCCESS_CODE == connection.getResponseCode()){
				InputStream is = connection.getInputStream();
				ByteArrayOutputStream osArray = new ByteArrayOutputStream();
				
				int len = 0;
				byte[] data = new byte[1024];
				while((len = is.read(data, 0, data.length)) != -1){
					osArray.write(data, 0, len);
				}
				
				is.close();
				
				return osArray.toByteArray();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
