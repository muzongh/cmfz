<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {
        $('#logdg').datagrid({
            url:"${pageContext.request.contextPath}/log/showAll.do",
            columns:[[
                {field:"logId",title:"标识编号",width:90},
                {field:"logUser",title:"操作人",width:90},
                {field:"logTime",title:"操作时间",width:90,},
                {field:"logResource",title:"操作对象",width:90,},
                {field:"logAction",title:"操作动作",width:90,},
                {field:"logMessage",title:"操作信息",width:90,},
                {field:"logResult",title:"操作结果",width:90,},
            ]],
            pagination:true,
            pageList : [9,12,15],
            pageSize : 9,
            fitColumns: true,
            singleSelect:true,
        })
    });
</script>
<table id="logdg" ></table>
<div id="logdd" style="width:400px;height:300px;"></div>
