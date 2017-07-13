package com.huida.shop.user.vo;
/**
 * 封装消费者用户信息
 * @author wangzhen
 *
 */
public class ShopUser {
	//主键
	private String id;
	//登录账号
	private String usercode;
	//密码
	private String password;
	//电话
	private String phonenum;
	//真实姓名
	private String realname;
	//邮箱
	private String mail;
	//邮箱是否激活
	private String mailactiveflag;
	//邮箱激活码
	private String mailactivecode;
	//用户的地址
	private String useraddr;
	//头像
	private String headphoto;
	//昵称
	private String nickname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMailactiveflag() {
		return mailactiveflag;
	}
	public void setMailactiveflag(String mailactiveflag) {
		this.mailactiveflag = mailactiveflag;
	}
	public String getMailactivecode() {
		return mailactivecode;
	}
	public void setMailactivecode(String mailactivecode) {
		this.mailactivecode = mailactivecode;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getHeadphoto() {
		return headphoto;
	}
	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
