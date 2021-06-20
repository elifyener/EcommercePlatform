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
	
	<title>Sipariş Detayları</title>
<style>
h2{
	text-align: center;
	margin-top: 20px;
}
</style>

</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- tables begin -->
    <div class="mt-4 mr-4 ml-4">
    	<h2> Sipariş Detayı </h2>
    	<dl class="row">
		  <dt class="col-sm-3">Sipariş Sahibi</dt>
		  <dd class="col-sm-9"><c:out value="${userOrder.name} ${userOrder.surname}"/></dd>
		
		  <dt class="col-sm-3">Sipariş Numarası</dt>
		  <dd class="col-sm-9"><c:out value="${userOrder.ordernum}"/></dd>
		
		  <dt class="col-sm-3">Toplam Tutar</dt>
		  <dd class="col-sm-9"><c:out value="${userOrder.cost}"/> TL</dd>
		  
		  <dt class="col-sm-3">E-Mail Adresi</dt>
		  <dd class="col-sm-9"><c:out value="${userOrder.email}"/></dd>
		
		</dl>
    </div>
    <br/>
    <div class="mt-4 mr-4 ml-4">
	    <table class= "table table-bordered">
			<thead>
				<tr>
					<th>Ürün Adı</th>
					<th>Adet</th>
					<th>Fiyat</th>
				</tr>
			</thead>
			<c:forEach  var="a" items="${orderlists}">
			<tbody>
				<tr>
					<td><c:out value="${a.name}"/></td>
					<td><c:out value="${a.adet}"/></td>
					<td><c:out value="${a.cost}"/> TL</th>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
    <!-- tables end -->
</body>
</html>