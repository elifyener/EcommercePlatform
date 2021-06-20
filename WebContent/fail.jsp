<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Hata</title>
<style>
.container {
  text-align: center;
}
</style>
</head>

<body>		
	<!-- success begin -->
	<div class="container">
		<div class="row my-4">
			<div class = "col-md-4 offset-md-4 my-4">
				<i class="fa fa-exclamation-circle" style="font-size: 20rem; color: indianred;"></i>
				<h2 text-align="center">İşlem Başarısız</h2>
				<a href="index" class="btn btn-primary btn-block"><i class="fa fa-home"></i> Anasayfa</a>
			</div>
		</div>
	</div>
	<!-- success end -->

</body>
</html>