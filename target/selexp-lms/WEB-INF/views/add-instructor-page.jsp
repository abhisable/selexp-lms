<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8" isELIgnored = "false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">You are on instructor page!</h1>
<div align="center">
 <form:form action="/addInstructor" method="post" modelAttribute="instructor">
 <br>
 <label>Name: </label>
 <form:input path="name"/>
 <br>
 <label>email : </label>
 <form:input path="email"/>
 <br>
 <label>Experience : </label>
 <form:input path="instructorExp"/>
 </form:form>
 <input type="submit" value="Add"/>
</div>
</body>
</html>