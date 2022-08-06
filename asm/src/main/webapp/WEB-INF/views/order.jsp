<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>ORDER ID</th>
<th>NGÀY MUA</th>
<th>TỔNG TIỀN</th>
</tr>
<c:forEach var="o" items="${listOrder}">
<tr>
<td>${o.orderId}</td>
<td>${o.orderDate}</td>
<td>${o.amount}</td>
</tr>
</c:forEach>
</table>
</body>
</html>