package com.huida.util;

import javax.servlet.http.HttpServletRequest;

import com.huida.web.ServiceReturnObj;

/**
 * 用于图片校验的工具类
 * @author ThinkPad
 *
 */
public class ImgValidateCodeUtil {

	public static boolean validate(HttpServletRequest request,String code){
		String sessionValicode = (String)request.getSession().getAttribute("img_validate_code");
		request.getSession().removeAttribute("img_validate_code");
		if(!(sessionValicode!=null && sessionValicode.equals(code))){
			return false;
		}else{
			return true;
		}
	}
}
