package com.huida.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huida.util.ChineseValidateImgUtil;
import com.huida.util.Guid;

/**
 * 生成图片验证码servlet
 * @author wangzhen
 *
 */
public class ImgValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImgValidateCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//画图片返回前台		
		OutputStream os = response.getOutputStream();
		ChineseValidateImgUtil.genImgStream(os, session);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		FileInputStream fis = new FileInputStream("D:\\5632c2eeNbc918af0.jpg");
	}

}
