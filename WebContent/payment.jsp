<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Ödeme</title>
</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- payment begin -->
		<div class="container my-5">
			<div class="row">
				<div class="col-md-6">
				<h4>Fatura Bilgileriniz</h4>
					<form class="was-validation" method = "post" action="fail.jsp">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Adınız" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Soy Adınız" required>
						</div>
						<div class="form-group">
							<textarea class="form-control" placeholder="Adres" rows= "5" required></textarea>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Posta Kodu" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Telefon" minlength="10" required>
						</div>
				</div>
				
				<div class="col-md-6">
				<h4>Ödeme Adımı</h4>
						<div class="form-group">
							<label><b>Kart Sahibi</b></label>
							<input type="text" name = "owner"class="form-control" placeholder="Kart Sahibi" required>
							<small class="text-muted">İsim bilgisini eksiksiz giriniz.</small>
						</div>
						<div class="form-group">
							<label><b>Kart Numarası</b></label>
							<input type="text" name = "number" class="form-control" placeholder="Kart Numarası" minlength="16" required>
							<small class="text-muted">Kart numarasını boşluk bırakmadan yazınız.</small>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label><b>Bitiş Tarihi</b></label>
									<input type="text" name = "skt" class="form-control" placeholder="xx/xxxx" required>
									<small class="text-muted">Bitiş tarihi</small>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label><b>Güvenlik Kodu</b></label>
									<input type="text" name = "cvc" class="form-control" placeholder="CVV" minlength="3" required>
									<small class="text-muted">Güvenlik kodu</small>
								</div>
							</div>
						</div>
						
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Satın Al
						</button>
					</div>
					</form>
				</div>
			</div>
			
		</div>
	<!-- payment end -->

</body>
</html>