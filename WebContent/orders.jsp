<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ecommerce.model.*" import="com.ecommerce.dao.*"%>
<% request.setAttribute("userOrder", AdminOrderDao.getOrder( Integer.parseInt(request.getParameter("id")))); %>
<% request.setAttribute("orderlists", UserOrderDao.getAllOrder( Integer.parseInt(request.getParameter("id")))); %>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Siparişlerim</title>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- tables begin -->
	<div class="mt-4 mr-4 ml-4">
	    <table class= "table table-bordered">
			<thead>
				<tr>
					<th>Sipariş Kodu</th>
					<th>Ürün Adı</th>
					<th>Adet</th>
					<th>Fiyat</th>
					<th>Toplam Fiyat</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach  var="a" items="${orderlists}">
				<tr>
					<td><c:out value="${a.ordernum}"/></td>
					<td><c:out value="${a.name}"/></td>
					<td><c:out value="${a.adet}"/></td>
					<td><c:out value="${a.cost}"/></th>
					<td><c:out value="${a.sumcost}"/></th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
    <!-- tables end -->
</body>
</html>