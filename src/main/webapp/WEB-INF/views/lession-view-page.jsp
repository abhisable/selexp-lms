
<%@page import="io.micrometer.observation.Observation.Context"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.se.selexplms.entity.Lession" %>
	

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
<%
  Lession lession=(Lession)request.getAttribute("lession");
  Integer nextLession=lession.getLessionId()+1;
  Integer prevLession=lession.getLessionId()-1;
  pageContext.setAttribute("nextLession", nextLession);
  pageContext.setAttribute("prevLession",prevLession);
%>
	<div class="container" align="center">
		<h1>${lession.lessionName}</h1>
		<br /> ${lession.lessionLink} <br />
	</div>
	<c:if test="${nextLession<=max}">
	<div class ="container" align="right">
		<a href="/selexp-lms/lession?id=${pageScope.nextLession}" align="right">next
			lession</a>
	</div>
	</c:if>
	<c:if test="${prevLession>=min}">
	<div class ="container" align="left">
		<a href="/selexp-lms/lession?id=${pageScope.prevLession}" align="right">prev
			lession</a>
	</div>
	</c:if>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>