<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
<center>
<h2>Login</h2>
<form:form modelAttribute = "credLogin"  method = "post" action = "${pageContext.request.contextPath}/login">
<table>
<tr>
<td>Don't have an account? <a href = "${pageContext.request.contextPath}/loadSignUp">Sign Up</a></td>
</tr>
<tr>
<td>Email</td>
</tr>
<tr>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>Password</td>
</tr>
<tr>
<td><form:password path="password"/>
</tr>
<tr>
<td align = "right"><a href = "${pageContext.request.contextPath}/loadResetPassword">forgot password</a></td>
</tr>
<tr>
<td><input type = "submit" value = "Sign in"></td>
</tr>
<tr>
<c:if test="${not empty error}">
<td style = "color:red">${error}</td>
</c:if>
</tr>
</table>
</form:form>
</center>
</body>
</html>