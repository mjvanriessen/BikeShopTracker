<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit the Order</title>
</head>
<body>
	<form action="editOrdersServlet" method="post">
		<input type="hidden" name="id" value="${orderToEdit.id}">
		Customer Name: <input type="text" name="customerName"><br />
		Delivery Date: <input type="text" name="month" placeholder="mm" size="4">
					   <input type="text" name="day" placeholder="dd" size="4">
					   <input type="text" name="year" placeholder="yyyy" size="4"><br />
		Shop Owner Name: <input type="text" name="ownerName"><br />
		Shop Location: <input type="text" name="shopLocation"><br />
		
		Bike Availability:<br />
		<select name="allBikesAdded" multiple size="6">
			<c:forEach items="${requestScope.allBikes}" var="currentbike">
				<option value="${currentbike.id}">${currentbike.bikeModel} | ${currentbike.bikeUse} | $ ${currentbike.bikePrice}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Edit Order">
	</form>
	<a href="index.html">Add a bike entry</a>
</body>
</html>