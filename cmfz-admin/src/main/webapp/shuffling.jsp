<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {
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
                                success:function(data){
                                    if(data==""){
                                        alert("添加轮播图失败！");
                                        $("#dd").dialog("close",true);
                                    }else{
                                        alert("添加轮播图成功！");
                                        $("#dd").dialog("close",true);
                                    }
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
                            alert("您已经放弃添加轮播图");

                            $("#dd").dialog("close",true);
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
