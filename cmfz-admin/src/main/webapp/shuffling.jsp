<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {
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
        $("#add").linkbutton({
            iconCls:'icon-add',plain:true,text:'新增轮播图',
            onClick:function(){
                $("#dd").dialog({
					title:"新增轮播图",
                    width:400,
                    height:251,
                    href:"${pageContext.request.contextPath}/addShuffling.jsp",
                    buttons:[{
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#ud").form("submit",{
                                url:"${pageContext.request.contextPath}/shuffling/add.do",
                                onSubmit:function(){
                                    return $(this).form("validate");
                                },
                                success:function(data){
                                    if(data==""){
                                        $.messager.show({
                                            title:'添加轮播图失败提示',
                                            iconCls:"icon-cancel",
                                            msg:'添加轮播图失败，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#dd").dialog("close");
                                    }else{
                                        $.messager.show({
                                            title:'添加轮播图成功提示',
                                            iconCls:"icon-ok",
                                            msg:'添加轮播图成功，本窗口将在3秒后关闭。',
                                            timeout:3000,
                                            showType:'slide'
                                        });
                                        $("#dd").dialog("close");
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            $.messager.show({
                                title:'放弃添加轮播图',
                                iconCls:"icon-cancel",
                                msg:'您已放弃添加轮播图，本窗口将在3秒后关闭。',
                                timeout:3000,
                                showType:'slide'
                            });
                            $("#dd").dialog("close");
                        },
                    }],

                });
            },
        });

        $("#help").linkbutton({
            iconCls:'icon-help',plain:true,text:'帮助',
            onClick:function(){

            },
        });
    });
</script>
<table id="dg" ></table>
<div id="tb" style="display: none">
	<a id="add"></a>
	<a id="help"></a>
</div>
<div id="dd" style="width:400px;height:300px;"></div>
