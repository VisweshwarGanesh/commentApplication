<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up yourself</title>
</head>
<body>
<center>
<h1>Sign up</h1>
<form:form modelAttribute = "credLogin" method = "post" action = "${pageContext.request.contextPath}/signUp">
<table>
<tr>
<td>Already have an account? <a href = "${pageContext.request.contextPath}/">Sign in</a></td>
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
<tr>
<td>Secret</td>
</tr>
<tr>
<td><form:input path="secret"/>
</tr>
<tr>
<td><input type = "submit" value = "sign up"></td>
</tr>
<tr>
<td><a href = "${pageContext.request.contextPath}/">home</a>
</tr>
</table>
</form:form>
</center>
</body>
</html>