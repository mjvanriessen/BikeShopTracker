<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing all bike listings</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allBikes}" var="currentbike">
			Model | Specialty | Price
				<tr>
					<td><input type="radio" name="id" value="${currentbike.id}"></td>
					<td>${currentbike.bikeModel} |</td>
					<td>${currentbike.bikeUse} |</td>
					<td>${currentbike.bikePrice}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToBike">
		<input type="submit" value="delete" name="doThisToBike">
		<input type="submit" value="add" name="doThisToBike">
	</form>
</body>
</html>