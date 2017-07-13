<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>会员注册</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/validationEngine.jquery.css" type="text/css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.min.js" type="text/javascript"></script>
	<!-- 引入表单校验jquery插件 -->
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function(){
			$("#register_form").validationEngine("attach",{
			    promptPosition:"centerRight", 
			    validationEventTriggers:"blur",
			    scroll:false
			}); 
		}); 
		function changeValicode(ele){
			var jqObj = $(ele);
			jqObj.attr("src"
			,"<%=request.getContextPath() %>/imgvalidatecode?stmp=" + new Date().getTime());
		}
		
		function submitRegister(){
			//1.校验表是否输入正确（使用validateEngine框架）
			var flag = $("#register_form").validationEngine("validate");
			if(flag){
				//提交表单
				$("#register_form").submit();
			}
			//2.如果校验成功提交表,如果失败什么都不干
		}
	</script>

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error{
	color:red
}
</style>

</head>
<body>
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
					<li><a href="<%=request.getContextPath() %>/login.jsp">登录</a></li>
					<!-- <li style="color:red">欢迎您，上帝</li>
					<li><a href="#">退出</a></li> -->
				<li><a href="#">购物车</a></li>
				<li><a href="#">我的订单</a></li>
			</ol>
		</div>
	</div>

	<%@ include file="/include/nav.jsp" %>

	<div class="container"
		style="width: 100%; background: url('<%=request.getContextPath() %>/img/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font><font style="color:red;">${errMsg}</font>
				<form id="register_form" class="form-horizontal"  method="post" action="<%=request.getContextPath() %>/shopqt/user/register" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control validate[required,custom[usercode]]" id="usercode" name="usercode" value="${usercode}"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control  validate[required,custom[usercode]]"" id="password" name="password" value="${password}"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control validate[required,equals[password]]"" id="confirmpwd" name="repassword"  value="${repassword}"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">真实姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control  validate[required]"" id="realname" name="realname" value="${realname}"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">昵称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control validate[required]" id="nickname" name="nickname"  value="${nickname}"
								placeholder="请输入昵称">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">手机号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control validate[required,custom[phone]]" id="phonenum" name="phonenum"   value="${phonenum}"
								placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-6">
							<input type="email" class="form-control validate[required,custom[email]]" id="mail" name="mail"  value="${mail}"
								placeholder="请输入邮箱">
						</div>
					</div>
					
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" id="checkCode" class="form-control  validate[required]" name="checkCode"   value="${checkCode}">

						</div>
						<div class="col-sm-2">
							<img src="<%=request.getContextPath() %>/imgvalidatecode" onclick="changeValicode(this)" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<span onclick="submitRegister()" style="cursor:pointer;padding:10px 30px;background: url('<%=request.getContextPath() %>/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">注册
							</span>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<%@ include file="/include/bottom.jsp" %>

</body>
</html>   