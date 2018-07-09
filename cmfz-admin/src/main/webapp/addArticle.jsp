<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<style type="text/css">
	.articleBg{
		height: 540px;
	}

	.text {
		border: 1px solid #ccc;
		height: 400px;
		background-color: beige;

	}

</style>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/addMorePic.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create();

    $(function () {
		$("#articleName").textbox({
			required:true,
		});
		$("#articleAuthor").combobox({
			required:true,
            url:"${pageContext.request.contextPath}/article/showAllGuru.do",
            valueField : 'guruId',
            textField : 'guruName',

		});
		$("#articleStatus").switchbutton({
			onText:"上架",
			offText:"下架",
		});
		$("#btnsubmit").linkbutton({
			text:"创建文章",
			onClick:function () {
				$("#articleform").form("submit",{
                    //queryParams:{"intro":editor.txt.html()},
				    url:"${pageContext.request.contextPath}/article/add.do",
					onSubmit:function (param) {
				        param.articleIntroduction=editor.txt.html();
						return $(this).form("validate");
                    },
                    success:function (data) {
						if(data==""){
                            $.messager.show({
                                title:'我的消息',
                                msg:'创建文章失败，消息将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                        }else{
                            $.messager.show({
                                title:'我的消息',
                                msg:'创建文章成功，消息将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#articleform").form("clear");
						}
                    }
				});
            },
		});

		$("#btnreset").linkbutton({
			text:"重置内容",
			onClick:function () {
				$("#articleform").form("reset");
            }
		});
    })

</script>
<form id="articleform" method="post" class="articleBg">
	<table>
		<tr>
			<td>文章标题：</td>
			<td>
				<input id="articleName" name="articleName"/>
			</td>
		</tr>
		<tr>
			<td>文章作者：</td>
			<td>
				<input id="articleAuthor" name="guruId"/>
			</td>
		</tr>
		<tr>
			<td>文章状态：</td>
			<td>
				<input id="articleStatus" name="articleStatus">
			</td>
		</tr>
		<tr>
			<td colspan="2">文章内容：</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="editor" class="text">

				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a id="btnsubmit"></a>
				<a id="btnreset"></a>
			</td>
		</tr>
	</table>
</form>