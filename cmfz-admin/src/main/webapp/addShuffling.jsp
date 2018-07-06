<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {

    });
</script>

<form id="ud" method="post" enctype="multipart/form-data" style="margin: 15px">
	<table>
		<tr>
			<td>轮播图描述:</td>
			<td>
				<input id="des" name="description" class="easyui-textbox" data-options="width:251"/>
			</td>
		</tr>
		<tr>
			<td>轮播图状态:</td>
			<td>
				<select id="sts" class="easyui-combobox" data-options="panelHeight:50,width:251" name="status">
					<option value="未展示">未展示</option>
					<option value="展示中">展示中</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>请选择图片:</td>
			<td>
				<input name="file" id="files" class="easyui-filebox" data-options=" buttonText: '选择文件',buttonIcon:'icon-add',buttonAlign: 'right',accept:'.jpg',width:251">
			</td>
		</tr>
	</table>
</form>

