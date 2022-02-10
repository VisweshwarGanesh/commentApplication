<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset your password</title>
</head>
<body>
<center>
<h1>Reset Password</h1>
<form:form modelAttribute = "credLogin" method = "post" action = "${pageContext.request.contextPath}/resetPassword">
<table>
<tr>
<td>Email</td>
</tr>
<tr>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>Secret</td>
</tr>
<tr>
<td><form:input path="secret"/>
</tr>
<tr>
<td><input type = "submit" value = "reset"></td>
</tr>
</table>
</form:form>
<c:if test="${not empty message}">
<h4>${message}</h4>
</c:if>
<a href = "${pageContext.request.contextPath}/">home</a>
</center>
</body>
</html>