<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ecommerce.model.*" import="com.ecommerce.dao.*"%>
<% request.setAttribute("ordersl", AdminOrderDao.getAllOrder()); %>
<html>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Admin Panel</title>
	
<style>
h2{
	text-align: center;
	margin-top: 20px;
}
</style>

</head>
<body>
	<!-- navbar begin -->
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="#">My Shop</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" 
	  aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav mr-auto mt-2 mt-log-0">
	    </ul>
	    <ul class= "navbar-nav navbar-right">
		      <li class="nav-item">
		        <a class="nav-link" href="admin-panel.jsp">
		        	<span class = "fa fa-truck mr-2"></span>Alınan Siparişler
		        </a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link" href="logout">
		        	<span class = "fa fa-sign-out mr-2"></span>Çıkış
		        </a>
		      </li>
	    </ul>
	  </div>
	</nav>
	<!-- navbar end -->
	
	<!-- tables begin -->
    <div class="mt-5 mr-5 ml-5">
    <h2>Satışlar</h2>
	    <table class= "table table-bordered">
			<thead>
				<tr>
					<th>Sipariş Numarası</th>
					<th>Alıcı Adı</th>
					<th>Sipariş Tutarı</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="order" items="${ordersl}">
				<tr>
					<td><c:out value="${order.ordernum}" /></td>
					<td><c:out value="${order.name} - ${order.surname}"/></td>
					<td><c:out value="${order.cost}"/></td>
					<td><a href="details?id=<c:out value='${order.id}'/>"class="btn btn-sm btn-primary">Sipariş Detay</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
			
		</table>
    </div>
    <!-- tables end -->
    
    
</body>
</html>