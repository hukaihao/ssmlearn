<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserInfo List</title>
</head>

<body>
	SessionID:<%=session.getId()%><BR> SessionIP:<%=request.getServerName()%>
	<BR> SessionPort:<%=request.getServerPort()%>
	<%
		out.println("This is Tomcat Server 8.5！");
	%>
	<br />
	<table>
		<tr>
			<th>主键</th>
			<th>姓名</th>
			<th>性别</th>
			<th>证件类型</th>
			<th>证件号码</th>
			<th>出生日期</th>
			<th>年龄</th>
			<th>手机号码</th>
		</tr>

		<c:forEach items="${userInfoList}" var="userInfo">
			<tr>
				<td>${userInfo.idLearnUser}</td>
				<td>${userInfo.name}</td>
				<td>${userInfo.sex}</td>
				<td>${userInfo.idType}</td>
				<td>${userInfo.idNo}</td>
				<td><fmt:formatDate  value="${userInfo.birthday}" type="both"  pattern="yyyy-MM-dd"/></td>
				<td>${userInfo.age}</td>
				<td>${userInfo.phoneNo}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>
