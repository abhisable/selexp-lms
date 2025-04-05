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
 <form:form action="saveCourse" method="post" modelAttribute="course">
 <br>
 <label>course name: </label>
 <form:input path="courseName"/>
 <br>
 <label>course Duration : </label>
 <form:input path="courseDuration"/>
 <br>
 <label>Instructor : </label>
 <form:select path="instructor.id">
 <form:options items="${allInstructors}" itemLabel="name" itemValue="id"/>
 </form:select>
 <br>
 <form:button type="submit"> Add</form:button>
 
 </form:form>
 
</div>
</body>
</html>