<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button{
padding: 15px 30px;
}
div.showComments{
width:500px;
border-style : solid;
vertical-align:"center";
}
td{
column-width:200px
}
.com{
border-style : solid;
border-width : 1px;
column-width : 200px;
text-align :center;
border-spacing : 15px;
vertical-align:middle;
}
</style>
<meta charset="ISO-8859-1">
<title>Comments Section</title>
</head>
<body>
<center>
<h1>Comments</h1>
<form:form modelAttribute = "comments" method = "post" action = "${pageContext.request.contextPath}/saveComment">
<table>
<tr>
<td>Enter your comment</td>
</tr>
<tr>
<td><form:textarea cssClass = "button" path="comment"/></td>
<td><input class = "button" type = "submit" value = "save" /></td>
</tr>
</table>
</form:form>
<br><br><br>
<div class = "showComments">

<form action = "${pageContext.request.contextPath}/filter">
<p align = "right">
<input class = "button"  type = "submit" value = "filter">
</p>
</form>
<c:choose>
<c:when test="${empty myComments}">
<c:if test="${not empty allComments}">
<c:forEach var = "comment" items = "${allComments}">
<table>
<tr>
<td>${comment.cred.email} </td>
<td class = "com">${comment.comment}</td>
</tr>
</table>
</c:forEach>
</c:if>
</c:when>
<c:otherwise>
<c:forEach var = "comment" items = "${myComments}">
<table>
<tr>
<td>${comment.cred.email}</td>
<td class = "com">${comment.comment}</td>
</tr>
</table>
</c:forEach>
</c:otherwise>
</c:choose>

</div >

<a href = "${pageContext.request.contextPath}/">home</a>
</center>
</body>
</html>