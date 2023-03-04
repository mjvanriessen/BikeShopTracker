<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit bike entry</title>
</head>
<body>
	<form action="editBikeServlet" method="post">
		Bike Model: <input type="text" name="bikeModel" value="${bikeToEdit.bikeModel}">
		Bike Specialty: <input type="text" name="bikeUse" value="${bikeToEdit.bikeUse}">
		Price : <input type="text" name="bikePrice" value="${bikeToEdit.bikePrice}">
		<input type="hidden" name="id" value="${bikeToEdit.id}"><br />
		<input type="submit" value="Save bike entry">
	</form>
</body>
</html>