<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Kayıt Ol</title>
</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- register begin -->
	<div class="container">
		<div class="row my-4">
			<div class = "col-md-4 offset-md-4 my-4">
				<form action="insert" method="post" class="was-validation">
					<div class="card card-default shadow">
					  <div class="card-header">
					  	<div class = "row">
					  		<div class="col-md-3">
					  			<h3>
					  				<span class = "fa fa-user-plus fa-2x"></span>
					  			</h3>
					  		</div>
					  		<div class = "col-md-9 text-right">
					  			<h2>Kayıt Ol</h2>
					  			<small>Lütfen bilgilerinizi giriniz.</small>
					  		</div>
					  	</div>
					  </div>
					  <div class="card-body">
					  	<c:if test="${user != null}">
		        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
		        		</c:if>
					  	<div class = "form-group">
					    	<input type= "text" name="name" id = "name" placeholder="name" 
					    	class="form-control" required value="<c:out value='${user.name}' />" />
					    </div>
					    <div class = "form-group">
					    	<input type= "text" name="surname" id = "surname" placeholder="surname" 
					    	class="form-control" required value="<c:out value='${user.username}'/>" />
					    </div>
					    <div class = "form-group">
					    	<input type= "text" name="email" id = "email" placeholder="email" 
					    	class="form-control" required value="<c:out value='${user.email}'/>" />
					    </div>
					    <div class = "form-group">
					    	<input type= "password" name="password" id = "password" placeholder="password" 
					    	class="form-control" required value="<c:out value='${user.password}'/>" />
					    </div>
					  </div>
					  <div class="card-footer text-muted text-right">
					  		<button class ="btn btn-success" type= "submit">
					  			<span class="fa fa-user-plus mr-2"></span>Kayıt Ol
					  		</button>
					  </div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- login end -->
</body>
</html>