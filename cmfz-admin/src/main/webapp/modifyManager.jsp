<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {
	    $("#oldPwd").validatebox({
			required:true,
            invalidMessage:"旧密码输入错误",
            onValidate:function () {
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/manager/findPwd.do",
                    data:"pwd="+$(this).val(),
                    success : function(message){
                        if(message==""){
                            $("#cpwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>旧密码输入错误").css("color","red");
                            return false;
                        }else{
                            $("#cpwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>旧密码输入正确").css("color","green");
                            return true;
                        }
                    }
                });
            }
		});
	    
		/*$("#oldPwd").blur(function () {
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/manager/findPwd.do",
                data:"pwd="+$(this).val(),
                success : function(message){
                    if(message==""){
                        oldPwdBoolean=false;
                        $("#cpwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>旧密码输入错误").css("color","red");
                    }else{
                        $("#cpwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>旧密码输入正确").css("color","green");
					}
                }
            });
        });*/


        $("#newPwd").validatebox({
            required:true,
            onValidate:function () {
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/manager/findPwd.do",
                    data:"pwd="+$(this).val(),
                    success : function(message){
                        if(message=="OK"){
                            $("#npwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>新旧密码不能相同").css("color","red");
                            return false;
                        }else{
                            $("#npwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>新密码可用").css("color","green");
                            return true;
                        }
                    }
                });
            }
        });
        /*$("#newPwd").blur(function () {
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/manager/findPwd.do",
                data:"pwd="+$(this).val(),
                success : function(message){
                    if(message=="OK"){
                        $("#npwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>新旧密码不能相同").css("color","red");
                    }else{
                        $("#npwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>新密码可用").css("color","green");
                    }
                }
            });
        });*/

        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    if(value == $(param[0]).val()){
                        $("#rnpwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>两次密码输入一致").css("color","green");
					}else{
                        $("#rnpwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>两次密码输入不一致").css("color","red");
					}
                    return value == $(param[0]).val();
                },
            }
        });

        $("#reNewPwd").validatebox({
            required:true,
			validType:"equals['#newPwd']"
        });

		/*$("#reNewPwd").blur(function () {
			if($(this).val()==$("#newPwd").val()){
                $("#rnpwd").html("<img src='${pageContext.request.contextPath}/img/label3.gif' style='width:10px;heigth:10px'/>两次密码输入一致").css("color","green");
			}else{
                $("#rnpwd").html("<img src='${pageContext.request.contextPath}/img/wrong.gif' style='width:10px;heigth:10px'/>两次密码输入不一致").css("color","red");
			}
        });*/

    });
</script>

<form id="form1" action="${pageContext.request.contextPath}/manager/modify.do" method="post">
	<table>
		<tr>
			<td>请输入旧密码：</td>
			<td>
				<input id="oldPwd" type="password"/><br/>
				<div id="cpwd"></div>
			</td>
		</tr>

		<tr>
			<td>请输入新密码：</td>
			<td>
				<input type="password" id="newPwd" name="pwd"/><br/>
				<div id="npwd"></div>
			</td>
		</tr>
		<tr>
			<td>请再次输入新密码：</td>
			<td>
				<input type="password" id="reNewPwd" /><br/>
				<div id="rnpwd"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="确认">
			</td>
		</tr>
	</table>
</form>

