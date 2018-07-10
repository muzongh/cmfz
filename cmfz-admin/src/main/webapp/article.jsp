<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	function editArt(r){
		alert(r);
	}
	$(function () {
        $('#articledg').datagrid({
            url:"${pageContext.request.contextPath}/article/showAllArticle.do",
            columns:[[
                {field:"articleId",title:"标识编号",width:90},
                {field:"articleName",title:"文章名",width:90},
                {field:"articleIntroduction",title:"文章信息",width:90,},
                {field:"articleDate",title:"文章最后修改日期",width:90,},
                {field:"guruId",title:"文章作者",width:90,},
                {field:"articleStatus",title:"文章状态",width:90,},
                {field:"operation",title:"操作",width:90,
                    formatter:function(value,row,index){
                        return"<a name='articlemodify' id='"+row.articleId+"' onclick='editArt(this)'>修改文章</a>"+
							"<a name='articlesingle' id='"+row.articleId+"' onclick='editArt(this)'>查看详情</a>";
                    },
                },

            ]],
            onLoadSuccess:function(){
                $("a[name=articlsingle]").linkbutton({
                    iconCls:'icon-search',
                })
                $("a[name=articlemodify]").linkbutton({
                    iconCls:'icon-edit',
                })
            },
            pagination:true,
            pageList : [9,12,15],
            pageSize : 9,
            fitColumns: true,
            singleSelect:true,
        })
    });
</script>
<table id="articledg" ></table>
<div id="articledd" style="width:400px;height:300px;"></div>
