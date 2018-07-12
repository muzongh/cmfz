<%@ page import="java.net.URLDecoder" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/script/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	
		$(function(){
		    var enCodeBoolean=false;
		    $("#enCode").blur(function () {
		        $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/manager/checkImage.do",
                    data:"encode="+$(this).val(),
                    success : function(message){
                        if(message=="OK"){
                            enCodeBoolean=true;
                            $("#sp").html("<img src='./img/label3.gif' style='width:10px;heigth:10px'/>验证码输入正确").css("color","green");
                        }else{
                            $("#sp").html("<img src='./img/wrong.gif' style='width:10px;heigth:10px'/>验证码输入错误").css("color","red");
                        }
                    }
                });
            });
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$(this).prop("src","${pageContext.request.contextPath}/manager/image.do?flag="+Math.random());
			});

            $("#sub").click(function(){
                if(enCodeBoolean){
                    document.forms[0].submit();
                }
            });

			/*var n=("");

			$("#name").val(n);*/

		});
	</script>
<%
	String name = "";
	javax.servlet.http.Cookie cs[] = request.getCookies();
	for(javax.servlet.http.Cookie c:cs){
		if(c.getName().equals("name")){
			name = c.getValue();
			name = java.net.URLDecoder.decode(name,"utf-8");
		}
	}
%>

</head>
<body>
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/manager/login.do" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="name" name="name" class="text" maxlength="20" value="<%=name %>"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>

						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                                <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/manager/image.do" title="点击更换验证码"/>
							</td>
						</tr>
                        <tr>
                            <td></td>
                            <th></th>
                            <td>
                                <span id="sp"></span>
                            </td>
                        </tr>
                        <tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" value="true" name="rememberMe"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="button" class="loginButton" value="登录" id="sub">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2018.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>