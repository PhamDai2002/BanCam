<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GIỎ HÀNG</title>
</head>
<body>
	<table class="table table-bordered table-striped border border-dark border=1">
		<thead>
			<tr>
				<th>ID</th>
				<th>ẢNH</th>
				<th>TÊN</th>
				<th>SỐ lƯỢNG</th>
				<th>GIÁ</th>
				<th>TỔNG</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="sp" items="${cartItems}">
			<form action="/update-to-cart" method="post">
			
				<td>${sp.id}</td>
				<td><img alt="" src="/anhcam/${sp.anh}" height="50%" width="50%" ></td>
				<td>${sp.ten}</td>
				<td><input type="hidden" name="id"
					value="${sp.id}"> <input type="number"
					value="${sp.quantity}" onblur="this.form.submit()" name="quantity" min="0" max="1000"></td>
				<td>${sp.gia}</td>
				<td>${sp.gia*sp.quantity}</td>
			
			</form>
		</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
		<th>TỔNG TIỀN:  ${total}</th>
		<th><a href="/paying/${total}"> THANH TOÁN </a></th>
		</tr>
	</table>
</body>
</html>