<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function () {

    });
</script>

<form id="addBatch" method="post" enctype="multipart/form-data" style="margin: 15px">
	<table>
		<tr>
			<td>请选择文件:</td>
			<td>
				<input name="addfile" id="files" class="easyui-filebox" data-options=" buttonText: '选择Excel文件',btonIcon:'icon-add',buttonAlign: 'right',accept:'.xls,.xlsx',width:251,required:true">
			</td>
		</tr>
	</table>
</form>

