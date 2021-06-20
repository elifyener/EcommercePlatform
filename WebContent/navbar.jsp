<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page
	import="com.ecommerce.model.*"
	import="com.ecommerce.DAO.*"
%>
<!-- navbar begin -->
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="index">My Shop</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" 
	  aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav mr-auto mt-2 mt-log-0">
	      <li class="nav-item active">
	        <a class="nav-link" href=index>Ana Sayfa <span class="sr-only">(current)</span></a>
	      </li>
	    </ul>
	    <ul class= "navbar-nav navbar-right">
	    <%if(session.getAttribute("user") == null){ %>
		    <li class="nav-item">
		        <a class="nav-link" href="register.jsp">
		       		<span class = "fa fa-user-plus mr-2"></span> Kayıt Ol
		        </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="login.jsp">
		        	<span class = "fa fa-sign-in mr-2"></span>Giriş
		        </a>
		      </li>
		 <%}%>
		      <li class="nav-item">
		        <a class="nav-link" href="cart">
		        	<span class = "fa fa-shopping-cart mr-2"></span>Sepete Git
		        </a>
		      </li>
		  <%if(session.getAttribute("user") != null){ %>
	  		  <li class="nav-item">
		        <a class="nav-link" href="orders.jsp">
		        	<span class = "fa fa-truck mr-2"></span>Siparişlerim
		        </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="logout">
		        	<span class = "fa fa-sign-out mr-2"></span>Çıkış
		        </a>
		      </li>
		  <%}%>
	    </ul>
	  </div>
	</nav>
	<!-- navbar end -->