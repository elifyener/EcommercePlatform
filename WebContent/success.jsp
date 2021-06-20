<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>İşlem Tamamlandı</title>
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
				<i class="fa fa-check-circle" style="font-size: 20rem; color: palegreen;"></i>
				<h2 text-align="center">İşlem Tamamlandı</h2>
				<h5>Sipariş Numarası: 214121857</h5>
				<a href="index" class="btn btn-primary btn-block"><i class="fa fa-home"></i> Anasayfa</a>
			</div>
		</div>
	</div>
	<!-- success end -->

</body>
</html>