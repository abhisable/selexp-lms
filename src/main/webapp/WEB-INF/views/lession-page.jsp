<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<h1>${course.courseName}</h1>
	<br>
	<hr>
	<spring:url value="/show/${course.id}" var="viewPageUrl" />

	<c:forEach var="lession" items="${pagedLessionListHolder.pageList}">
		<a href="/selexp-lms/lession?id=${lession.lessionId}">${lession.lessionName}</a>
		<br />

	</c:forEach>
	<c:choose>
		<c:when test="${pagedLessionListHolder.firstPage}">prev</c:when>
		<c:otherwise>
			<a href="${viewPageUrl}?pageNum=prev">prev</a>
		</c:otherwise>
	</c:choose>
	<c:forEach begin="0" end="${pagedLessionListHolder.pageCount-1}"
		varStatus="loop">
		<c:choose>
		<c:when test="${pagedLessionListHolder.page==loop.index}">${loop.index+1}</c:when>
		<c:otherwise>
			<a href="${viewPageUrl}?pageNum=${loop.index}">${loop.index+1}</a>
		</c:otherwise>
	</c:choose>
		
	</c:forEach>
	<c:choose>
		<c:when test="${pagedLessionListHolder.lastPage}">next</c:when>
		<c:otherwise>
			<a href="${viewPageUrl}?pageNum=next">next</a>
		</c:otherwise>
	</c:choose>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>