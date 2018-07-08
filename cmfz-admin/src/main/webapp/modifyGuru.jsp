<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {

    });
</script>

<form id="guru" method="post" enctype="multipart/form-data" style="margin: 15px">
	<table>
		<input name="guruId" value="" hidden/>
		<tr>
			<td>上师法号:</td>
			<td>
				<input id="nam" name="guruName" class="easyui-textbox" data-options="width:251,required:true"/>
			</td>
		</tr>
		<tr>
			<td>上师简介:</td>
			<td>
				<input id="des" name="guruSummary" class="easyui-textbox" data-options="width:251,multiline:true,required:true"/>
			</td>
		</tr>
		<tr>
			<td>上师法相:</td>
			<td>
				<input name="file" id="files" class="easyui-filebox" data-options=" buttonText: '选择图片',btonIcon:'icon-add',buttonAlign: 'right',accept:'.jpg',width:251">
			</td>
		</tr>
	</table>
</form>

