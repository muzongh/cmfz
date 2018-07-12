<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">
	$(function () {
        $('#gurudg').datagrid({
            url:"${pageContext.request.contextPath}/guru/showAll.do",
            columns:[[
                {field:"guruId",title:"上师标识",width:90},
                {field:"guruName",title:"上师法号",width:90},
                {field:"guruPhoto",title:"上师法相",width:90,},
            ]],
            pagination:true,
            pageList : [9,12,15],
            pageSize : 9,
            toolbar : "#gurutb",
            fitColumns: true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/photos/' + rowData.guruPhoto + '"></td>' +
                    '<p>简介: ' + rowData.guruSummary + '</p>' +
                    '</tr></table>';
            },
        });

        $("#guruadd").linkbutton( {
            iconCls:'icon-add',plain:true,text:'新增上师',
            onClick:function(){
                $("#gurudd").dialog({
					title:"新增上师",
                    width:400,
                    height:251,
                    href:"${pageContext.request.contextPath}/addGuru.jsp",
                    buttons:[{
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#guru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/add.do",
                                onSubmit:function(){
                                    return $(this).form("validate");
                                },
                                success:function(data){
                                    if(data==""){
                                        $.messager.show({
                                            title:'添加上师错误提示',
                                            iconCls:"icon-cancel",
                                            msg:'添加上师失败，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");

                                    }else{
                                        $.messager.show({
                                            title:'添加上师成功提示',
                                            iconCls:"icon-ok",
                                            msg:'添加上师成功，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                        $("#gurudg").datagrid("reload");
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            $.messager.show({
                                title:'放弃添加提示',
                                iconCls:"icon-cancel",
                                msg:'您已放弃添加上师信息，本窗口将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#gurudd").dialog("close");
                        },
                    }],

                });
            },
        });

        $("#guruedit").linkbutton({
			text:"修改上师信息",
			iconCls:"icon-edit",
			plain:true,
			onClick:function () {
                var rowData = $("#gurudg").datagrid("getSelected");
                $("#gurudd").dialog({
                    title:"修改上师信息",
                    width:450,
                    height:251,
                    href:"${pageContext.request.contextPath}/modifyGuru.jsp",
                    onLoad:function(){
                        $("#guru").form("load",rowData);
                    },

                    buttons:[{
                        text:"提交",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#guru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/update.do",
                                onSubmit:function(){
                                    return $(this).form("validate");
                                },
                                success:function(data){
                                    if(data==""){
                                        $.messager.show({
                                            title:'修改上师信息错误提示',
                                            iconCls:"icon-cancel",
                                            msg:'修改上师信息失败，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                    }else{
                                        $.messager.show({
                                            title:'修改上师信息成功提示',
                                            iconCls:"icon-ok",
                                            msg:'修改上师信息成功，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                        $("#gurudg").datagrid("reload");
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            $.messager.show({
                                title:'放弃提示',
                                iconCls:"icon-ok",
                                msg:'您已放弃修改上师信息，本窗口将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#gurudd").dialog("close");
                        },
                    }],

                });
            }
		});

        $("#gurucancel").linkbutton({
            text:"删除上师信息",
            iconCls:"icon-cancel",
            plain:true,
            onClick:function () {
                var rowData = $("#gurudg").datagrid("getSelected");
                $("#gurudd").dialog({
					title:"删除上师信息",
                    width:251,
                    height:251,
                    context:"您确定要删除上师信息吗？",
                    buttons:[{
                        text:"确认",
                        iconCls:"icon-save",
                        handler:function(){
							$.ajax({
                                type:"POST",
                                url:"${pageContext.request.contextPath}/guru/cancel.do",
                                data:"id="+rowData.guruId,
                                success : function(message){
                                    if(message==""){
                                        $.messager.show({
                                            title:'删除上师信息失败提示',
                                            iconCls:"icon-cancel",
                                            msg:'删除上师信息失败，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                    }else{
                                        $.messager.show({
                                            title:'删除上师信息成功提示',
                                            iconCls:"icon-ok",
                                            msg:'删除上师信息成功，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                        $("#gurudg").datagrid("reload");
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            $.messager.show({
                                title:'放弃删除上师信息',
                                iconCls:"icon-cancel",
                                msg:'您已放弃删除上师信息，本窗口将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#gurudd").dialog("close");
                        },
                    }],

                });
            }
        });

        $("#help").linkbutton({
            iconCls:'icon-help',plain:true,text:'帮助',
            onClick:function(){

            },
        });

        $('#contains').searchbox({
            width:200,
            searcher:function(value,name){
                $('#dg').datagrid({
                    url:"${pageContext.request.contextPath}/guru/containsByName.do",
                    queryParams:{name:value},
                    columns:[[
                        {field:"guruId",title:"上师标识",width:90},
                        {field:"guruName",title:"上师法号",width:90},
                        {field:"guruPhoto",title:"上师法相",width:90,},
                    ]],
                    pagination:true,
                    pageList : [9,12,15],
                    pageSize : 9,
                    toolbar : "#tb",
                    fitColumns: true,
                    singleSelect:true,
                    view: detailview,
                    detailFormatter: function(rowIndex, rowData){
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/photos/' + rowData.guruPhoto + '"></td>' +
                            '<p>简介: ' + rowData.guruSummary + '</p>' +
                            '</tr></table>';
                    },
                })
            },
            menu:'#mm',
            prompt:'请输入上师法号'
        });

        $("#batch").linkbutton({
            text:"批量插入",
            iconCls:"icon-add",
            plain:true,
            onClick:function () {
                $("#gurudd").dialog({
                    title:"选择导入的Excel文件",
                    width:400,
                    height:200,
                    href:"${pageContext.request.contextPath}/addGuruBatch.jsp",
                    buttons:[{
                        text:"插入",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#addBatch").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/addBatch.do",
                                onSubmit:function(){
                                    return $(this).form("validate");
                                },
                                success:function(data){
                                    if(data==""){
                                        $.messager.show({
                                            title:'批量添加上师错误提示',
                                            iconCls:"icon-cancel",
                                            msg:'批量添加上师失败，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");

                                    }else{
                                        $.messager.show({
                                            title:'批量添加上师成功提示',
                                            iconCls:"icon-ok",
                                            msg:'批量添加上师成功，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#gurudd").dialog("close");
                                        $("#gurudg").datagrid("reload");
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            $.messager.show({
                                title:'放弃添加提示',
                                iconCls:"icon-cancel",
                                msg:'您已放弃添加上师信息，本窗口将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#gurudd").dialog("close");
                        },
                    }],

                });
            }
        });

        $("#export").linkbutton({
            text:"导出上师表",
            iconCls:"icon-application_side_expand",
            plain:true,
            onClick:function () {
                window.location.href="${pageContext.request.contextPath}/guru/export.do";
            }
        });

    });
</script>
<table id="gurudg" ></table>
<div id="gurutb" style="display: none">
    <shiro:hasPermission name="guru:add">
        <a id="guruadd"></a>
    </shiro:hasPermission>
    <shiro:hasPermission name="guru:update">
        <a id="guruedit"></a>
    </shiro:hasPermission>
    <shiro:hasPermission name="guru:cancel">
        <a id="gurucancel"></a>
    </shiro:hasPermission>
    <shiro:hasPermission name="guru:addBatch">
        <a id="batch"></a>
    </shiro:hasPermission>
    <shiro:hasPermission name="guru:export">
        <a id="export"></a>
    </shiro:hasPermission>
    <shiro:hasPermission name="guru:contains">
        <input id="contains" />
        <div id="mm" style="width:120px">
            <div data-options="name:'name',iconCls:'icon-ok'">法号</div>
        </div>
    </shiro:hasPermission>
</div>
<div id="gurudd" style="width:400px;height:300px;"></div>