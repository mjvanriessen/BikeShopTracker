<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bike Orders</title>
</head>
<body>
	<form method="post" action="orderNavServlet">
		<table>
			<c:forEach items="${requestScope.allOrders}" var="currentorder">
				<tr>
					<td><input type="radio" name="id" value="${currentorder.id}"></td>
					<td><h2>${currentorder.customerName}</h2></td></tr>
					<tr><td colspan="3">Order placed: ${currentorder.orderDate}</td></tr>
					<tr><td colspan="3"> Shop Owner/Location: ${currentorder.bikeShop.bikeShopOwner} / ${currentorder.bikeShop.bikeShopLocation}</td></tr>
					<c:forEach var="orderVal" items="${currentorder.orderDetails}">
						<tr><td></td><td colspan="3">${orderVal.bikeModel} | ${orderVal.bikeUse} | $ ${orderVal.bikePrice}</td></tr>
					</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToOrder">
		<input type="submit" value="delete" name="doThisToOrder">
	</form>
	<a href="addBikesForOrderServlet">Add an order to track</a>
	<a href="index.html">Add a new bike entry</a>
</body>
</html>