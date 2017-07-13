package com.huida.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装service方法的返回信息
 * @author ThinkPad
 */
public class ServiceReturnObj {
	//存放即将要去往界面
	private String page;
	//存放属性
	private Map<String,Object> properties = new HashMap<String,Object>();
	
	
	public static ServiceReturnObj newServiceReturn(String page,String errMsg){
		ServiceReturnObj obj = new ServiceReturnObj();
		obj.setPage(page);
		if(errMsg!=null){
			obj.setAttribute("errMsg", errMsg);
		}
		return obj;
	}
	
	/**
	 * 往map里面放置值
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key,Object value){
		properties.put(key, value);
	}
	
	public Object getAttribute(String key){
		return properties.get(key);
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Map<String, Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	

}
