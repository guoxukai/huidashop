package com.huida.shop.user.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huida.shop.user.service.ShopUserService;
import com.huida.web.ServiceReturnObj;
/**
 * 前台商城用户访问用户相关业务
 * @author wangzhen
 *
 */
public class ShopUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ShopUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter(arg0)
//		request.getAttribute("key")
//		request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		//目标是：根据uri分析出要调用的service方法名然后动态调用
		//1.获得到方法名
		String contextPath = request.getContextPath();
		String urlParten = "/shopqt/user/";
		String prefix = contextPath+urlParten;
		//截取uri
		String mehtodName = uri.substring(prefix.length());
		//2.创建一个Service的实例
		ShopUserService shopUserService = new ShopUserService();
		Map<String,String[]> params = request.getParameterMap();
		Set<Entry<String, String[]>> entryset =  params.entrySet();
		Map<String,String> paramReal = new HashMap<String,String>();
		//开始转化参数map集合
		for(Entry<String,String[]> entry : entryset){
			String key = entry.getKey();
			String[] value = entry.getValue();
			String valueStr = "";
			for(String str : value){
				valueStr += str+",";
			}
			String valueNew = valueStr.substring(0,valueStr.length()-1);
			paramReal.put(key, valueNew);
			//将所有的参数放到request域当中用于给表单初始化
			request.setAttribute(key, valueNew);
		}
		
		shopUserService.setParam(paramReal);
		shopUserService.setRequest(request);
		//3.根据方法名来动态调用service的方法
		//3.1 先获取到方法对象
		try {
			Method mehtodObj = ShopUserService.class.getDeclaredMethod(mehtodName);
			//3.2 invoke 执行方法
			ServiceReturnObj obj =  (ServiceReturnObj)mehtodObj.invoke(shopUserService);
			String page = obj.getPage();
			Map<String,Object> properties = obj.getProperties();
			for(Entry<String,Object> entry : properties.entrySet()){
				request.setAttribute(entry.getKey(), entry.getValue());
			}
			///login.jsp
			String[] arr = page.split(":");
			if(arr.length==1){
				request.getRequestDispatcher(page).forward(request, response);
			}else{
				String linkType = arr[0];
				String linkAddr = arr[1];
				if(linkType.equals("redirect")){
					//重定向
					response.sendRedirect(contextPath+linkAddr);
				}else{
					//还是转发
					request.getRequestDispatcher(linkAddr).forward(request, response);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("uri:" + uri);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[] args){
		/*String uri = "/shop/shopqt/user/register";
		String contextPath = "/shop";
		String urlParten = "/shopqt/user/";
		String prefix = contextPath+urlParten;
		//截取uri
		String mehtodName = uri.substring(prefix.length());
		System.out.println("方法名："+mehtodName);*/
		
		System.out.println("sfdsf,sdfsfd,".substring(0,"sfdsf,sdfsfd,".length()-1));
		
	}

}
