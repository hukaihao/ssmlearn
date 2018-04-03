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
		out.println("This is Tomcat Server 8.5...");
	%>
	<br />
	<table>
		<tr>
			<th>提示</th>
		</tr>
		<tr>
			<td>${successTip}</td>
		</tr>
	</table>
</body>

</html>
