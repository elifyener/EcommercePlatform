<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Sepet</title>
</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- cart table begin -->
	<div class=" mt-4 mr-4 ml-4">
	<table class= "table table-bordered">
		<thead>
			<tr>
				<th>Resim</th>
				<th>Ürün Adı</th>
				<th>Adet</th>
				<th>Fiyat</th>
				<th>Toplam Fiyat</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td><img alt="" src="https://cdn.dsmcdn.com//ty51/product/media/images/20210325/12/75199292/18111190/1/1_org.jpg" height= "40"></td>
				<td>Ekru Kuşaklı Düğmeli Elbise TWOSS19IE0009</td>
				<td>2</td>
				<td>90 TL</th>
				<td>180 TL</th>
				<td><button class="btn btn-danger"><i class="fa fa-trash"></i> Sil</button></td>
			</tr>
			<tr>
				<td colspan="4"></td>
				<td style = "display:block"> <strong>Toplam Tutar 540 TL</strong></td>
				<td></td>
			</tr>
		</tbody>
		
	</table>
	<a href="index" class="btn btn-success"><i class="fa fa-arrow-left"></i> Alışverişe Devam Et</a>
	<a href="payment.jsp" class="btn btn-success pull-right">Alışverişe Tamamla <i class="fa fa-arrow-right"></i></a>
	</div>
	<!-- cart table begin -->

</body>
</html>