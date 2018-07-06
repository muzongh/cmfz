<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
	$(function () {

        $.ajax({
            url:"${pageContext.request.contextPath}/manager/main.do",
            dataType:"json",
            success : function(parents){
                $.each(parents,function (index,obj) {
                    var content="";
                    $.each(obj.menus,function (index1,obj1) {
                        content+="<a class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'"+obj1.menuIcon+"'\" style=\"width: 100%\" onclick=\"addTab(this,'"+obj1.menuUrl+"')\">"+obj1.menuName+"</a><br />";
                    });
                    $("#aa").accordion("add",{
                        title:obj.menuName,
                        icon:obj.menuIcon,
                        content:content,
                    });
                });
            }
        });

		$("#update").linkbutton({
			onClick:function () {
				$("#dd").dialog({
					title:"修改管理员密码",
                    width:320,
                    height:251,
                    minimizable:true,
                	maximizable:true,
                    href:"${pageContext.request.contextPath}/modifyManager.jsp",
				});
            },
		});
    });

    function editShu(a){
        alert(a);
    };

	function addTab(message,path) {
	    var b=$("#tt").tabs("exists",message.text);
	    if(b){
	        $("#tt").tabs("select",message.text);
		}else{
            $("#tt").tabs("add",{
                title:message.text,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+path,
                onLoad:function () {
                    $('#dg').datagrid({
						fit:true,
                        url:"${pageContext.request.contextPath}/shuffling/showAll.do",
                        columns:[[
                            {field:"shufflingId",title:"标识编号",width:90},
                            {field:"shufflingPath",title:"文件名",width:90},
                            {field:"shufflingDescription",title:"描述信息",width:90,},
                            {field:"shufflingStatus",title:"轮播图状态",width:90,
                                styler: function(value,row,index){
                                    if (row.shufflingStatus=="展示中"){
                                        return 'color:red;';
                                    }
                                },
                            },
                            {field:"shufflingDate",title:"轮播图创建时间",width:90,},
							{field:"operation",title:"操作",width:90,
                                formatter:function(value,row,index){
                                    return "<a name='modify' id='"+row.shufflingId+"' onclick='editShu(this)'>修改</a>";
                                },
                            },

                        ]],
						onLoadSuccess:function(){
                            $("a[name=modify]").linkbutton({
                                iconCls:'icon-edit',
                            })
                        },
                        pagination:true,
                        pageList : [9,12,15],
                        pageSize : 9,
                        toolbar : "#tb",
                        fitColumns: true,
                        singleSelect:true,
                        view: detailview,
                        detailFormatter: function(rowIndex, rowData){
                            return '<table><tr>' +
                                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/images/' + rowData.shufflingPath + '"></td>' +
                                '</tr></table>';
                        },
                    })
                }

            });
		};

    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.man.managerName} &nbsp;<a id="update" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
			<%--<c:forEach var="parent" items="${sessionScope.parents}">
				<div title="${parent.menuName}" data-options="iconCls:'${parent.menuIcon}'">
					<c:forEach var="children" items="${parent.menus}">
						<a id="${children.menuId}" class="easyui-linkbutton" data-options="plain:true" style="width: 100%" onclick="one(this)">${children.menuName}</a><br />
					</c:forEach>
				</div>
			</c:forEach>--%>
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url('${pageContext.request.contextPath}/img/shouye.jpg');background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
	<div id="dd" style="width:400px;height:300px;"></div>
	<div id="dd1" style="width:400px;height:300px;"></div>
</body> 
</html>