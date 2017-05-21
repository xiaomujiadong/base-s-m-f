package com.cwd.test;

import java.io.UnsupportedEncodingException;

import com.cwd.http.HttpHelper;

public class Test {
	public static void main(String[] args){
		HttpHelper httpHelper = new HttpHelper();
		
		byte[] dataByte = httpHelper.httpReuest("POST", "http://www.baidu.com", null);
		if(dataByte != null && dataByte.length>0){
			String dataStr;
			try {
				dataStr = new String(dataByte, "UTF-8");
				System.out.println(dataStr);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
