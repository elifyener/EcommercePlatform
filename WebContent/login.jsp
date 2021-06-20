<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Giriş Yap</title>

</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- login begin -->
	<div class="container">
		<div class="row my-4">
			<div class = "col-md-4 offset-md-4 my-4">
				<form class="was-validation" action="login" method="post">
					<div class="card card-default shadow">
					  <div class="card-header">
					  	<div class = "row">
					  		<div class="col-md-3">
					  			<h3>
					  				<span class = "fa fa-sign-in fa-2x"></span>
					  			</h3>
					  		</div>
					  		<div class = "col-md-9 text-right">
					  			<h2>Giriş Yap</h2>
					  			<small>Lütfen e-posta ve şifrenizi giriniz.</small>
					  		</div>
					  	</div>
					  </div>
					  <div class="card-body">
					    <div class = "form-group">
					    	<input type= "text" name="username" id = "username" placeholder="email" class="form-control" required>
					    </div>
					    <div class = "form-group">
					    	<input type= "password" name="pass" id = "pass" placeholder="password" class="form-control" required>
					    </div>
					  </div>
					  <div class="card-footer text-muted text-right">
					  		<button class ="btn btn-success" type= "submit">
					  			<span class="fa fa-sign-in mr-2"></span>Giriş
					  		</button>
					  </div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- register end -->
</body>
</html>
