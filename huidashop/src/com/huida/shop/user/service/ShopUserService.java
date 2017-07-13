package com.huida.shop.user.service;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.huida.shop.user.dao.ShopUserDao;
import com.huida.shop.user.vo.ShopUser;
import com.huida.util.Guid;
import com.huida.util.ImgValidateCodeUtil;
import com.huida.util.MD5;
import com.huida.web.ServiceReturnObj;

/**
 * 负责与用户相关的业务逻辑操作
 * @author wangzhen
 *
 */
public class ShopUserService {

	private HttpServletRequest request;
	
	private Map<String,String> param;
	//负责数据库相关的动作
	private ShopUserDao shopUserDao = new ShopUserDao();
	
	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	/**
	 * 注册方法
	 * @return
	 */
	public ServiceReturnObj register(){
		//1.接到所有的注册输入的参数
		String usercode = param.get("usercode");
		String password = param.get("password");
		String realname = param.get("realname");
		String nickname = param.get("nickname");
		String phonenum = param.get("phonenum");
		String mail = param.get("mail");
		String checkCode = param.get("checkCode");
		if(!ImgValidateCodeUtil.validate(request, checkCode)){
			return ServiceReturnObj.newServiceReturn("/register.jsp", "图片验证码错误");
		}
		//2.判断用户账号是否在系统里已经有了-去数据库里楼一遍
		try {
			long count = shopUserDao.selectCountUserByUserCode(usercode);
			//3.如果存在提示用户，如果不存在开始注册
			if(count>0){
				return ServiceReturnObj.newServiceReturn("/register.jsp", "账号已经存在");
				
			}else{
				//系统内没有这个账号
				//4.持久化到数据库中
				ShopUser shopUser = new ShopUser();
				//全球唯一的字符串
			
				shopUser.setId(Guid.guid());
				shopUser.setUsercode(usercode);
				//密码 加盐				
				shopUser.setPassword(MD5.encode(MD5.encode(password)+shopUser.getId()));
				shopUser.setRealname(realname);
				shopUser.setNickname(nickname);
				shopUser.setPhonenum(phonenum);
				shopUser.setMail(mail);
				shopUser.setMailactivecode(Guid.guid());
				//0是没激活，1是激活
				shopUser.setMailactiveflag("0");
				int rows = shopUserDao.insert(shopUser);
				if(rows>0){
					//TODO:注册成功，应该跳转到登录界面
					return ServiceReturnObj.newServiceReturn("redirect:/login.jsp",null);
				}else{
					return ServiceReturnObj.newServiceReturn("/register.jsp", "注册失败!");
				}
				
			}		
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 处理用户登录逻辑
	 * @return
	 */
	public ServiceReturnObj login(){
		//1.接受用户输入的登录信息
		String usercode = param.get("usercode");
		String password = param.get("password");
		String checkCode = param.get("checkCode");
		if(!ImgValidateCodeUtil.validate(request, checkCode)){
			return ServiceReturnObj.newServiceReturn("/login.jsp", "图片验证码错误");
		}
		//2.去库里面查有没有这个用户
		try {
			ShopUser user = shopUserDao.selectUserByUsercode(usercode);
			//3.如果用户存在那么开始校验密码，如果不存在那么提示用户
			if(user!=null){
				String encodeUserINputPwd = MD5.encode(MD5.encode(password)+user.getId());
				String dbpwd = user.getPassword();
				if(encodeUserINputPwd.equals(dbpwd)){
					//4.我们把登录成功后的用户信息存入到session域对象当中
					HttpSession session = request.getSession();
					session.setAttribute("current_login_user", user);
					return ServiceReturnObj.newServiceReturn("redirect:/index.jsp", null);
				}else{
					//密码错误
					return ServiceReturnObj.newServiceReturn("/login.jsp", "密码错误！");
				}
				
			}else{
				return ServiceReturnObj.newServiceReturn("/login.jsp", "帐号不存在！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	/**
	 * 处理用户退出注销逻辑
	 * @return
	 */
	public ServiceReturnObj logout(){
		//1.将用户的在session里面的数据移除
		HttpSession session = request.getSession();
		//直接把session干掉
		session.invalidate();
		
		return ServiceReturnObj.newServiceReturn("redirect:/login.jsp", "");
	}
	

	
}
