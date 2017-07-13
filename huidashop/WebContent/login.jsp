<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>会员登录</title>
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
			$("#login_form").validationEngine("attach",{
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
		
		function sumitLogin(){
			//1.校验表是否输入正确（使用validateEngine框架）
			var flag = $("#login_form").validationEngine("validate");
			if(flag){
				//提交表单
				$("#login_form").submit();
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

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
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
					<li><a href="<%=request.getContextPath() %>/register.jsp">注册</a></li>
					<!-- <li style="color:red">欢迎您，上帝</li>
					<li><a href="#">退出</a></li> -->
				<li><a href="#">购物车</a></li>
				<li><a href="#">我的订单</a></li>
			</ol>
		</div>
	</div>

	<%@ include file="/include/nav.jsp" %>


	<div class="container"
		style="width: 100%; height: 460px; background: #FF2C4C url('<%=request.getContextPath() %>/img/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="<%=request.getContextPath() %>/img/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font><font style="color:red;">${errMsg }</font>
					<div>&nbsp;</div>
					<form id="login_form" class="form-horizontal" method="post" action="<%=request.getContextPath() %>/shopqt/user/login">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control validate[required,custom[usercode]]" value="${usercode}"  id="usercode" name="usercode"
									placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label  ">密码</label>
							<div class="col-sm-6"> 
								<input type="password" class="form-control validate[required,custom[usercode]]"  value="${password}" id="inputPassword3" name="password"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control validate[required]"  value="${checkCode}" id="checkCode" name="checkCode"
									placeholder="请输入验证码">
							</div>
							<div class="col-sm-3">
								<img src="<%=request.getContextPath() %>/imgvalidatecode" onclick="changeValicode(this)"  />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox"> 记住密码
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
			 					<span onclick="sumitLogin()" style="padding:10px 30px;background: url('<%=request.getContextPath() %>/img/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">登录</span>
								
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/include/bottom.jsp" %>

</body>
</html>