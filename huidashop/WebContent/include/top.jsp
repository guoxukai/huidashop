<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.huida.shop.user.vo.ShopUser" %>
<!-- 登录 注册 购物车... -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="<%=request.getContextPath() %>/img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="<%=request.getContextPath() %>/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<%
							ShopUser userObj = (ShopUser)request.getSession().getAttribute("current_login_user");
							if(userObj==null){
								%>
								<li><a href="login.jsp">登录</a></li>
								<li><a href="register.jsp">注册</a></li>
								<%
								
							}else{
								%>
								<li style="color:black;">欢迎您,${current_login_user.nickname}</li>
								<li><a href="<%=request.getContextPath() %>/shopqt/user/logout">退出</a></li>
								<%
							}
						%>
						<li><a href="#">购物车</a></li>
						<li><a href="#">我的订单</a></li>
					</ol>
				</div>
			</div>