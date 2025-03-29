<%@page import="java.awt.Menu"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

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
	<div align="center">
		<%@ include file="menu.jsp"%>
		<div align="left">
			<form:form action="search" method="GET">
				<input name="id">
				<button type="submit" class="btn btn-primary">search</button>
			</form:form>
		</div>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>Instructor Id</th>
					<th>Instructor name</th>
					<th>Instructor exp</th>
					<th>Instructor email</th>
					<th>Courses</th>
					<th>Delete Instructor</th>
				</tr>
			</thead>
			<c:forEach var="instructor" items="${instructorList}">
				<tr>
					<td>${instructor.id}</td>
					<td>${instructor.name}</td>
					<td>${instructor.instructorExp}</td>
					<td>${instructor.email}</td>
					<td>
						<table class="table">
							<thead class="table-info">
								<tr>
									<th>Course Name</th>
									<th>Course Duration</th>
								</tr>
							</thead>
							<c:forEach var="course" items="${instructor.courses}">
								<tr>
									<td>${course.courseName}</td>
									<td>${course.courseDuration}</td>
									<td><form:form action="show/${course.id}"
											method="GET">
											<button type="submit" class="btn btn-success">show</button>
										</form:form></td>
									<br>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td><form:form action="delete/${instructor.id}" method="GET">
							<button type="submit" class="btn btn-danger">delete</button>
						</form:form></td>
					<br>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>