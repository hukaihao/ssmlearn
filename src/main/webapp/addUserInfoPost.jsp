<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserInfo Add</title>
</head>

<body>
	SessionID:<%=session.getId()%><BR> SessionIP:<%=request.getServerName()%>
	<BR> SessionPort:<%=request.getServerPort()%>
	<%
		out.println("采用post方式 新增user ...");
	%>
	<br />

	<form
		action="${pageContext.request.contextPath}/userInfo/addUserInfoPost"
		method="post">
		<table>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>证件类型:</td>
				<td><input type="text" name="idType" /></td>
			</tr>
			<tr>
				<td>证件号码:</td>
				<td><input type="text" name="idNo" /></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>

</body>

</html>
