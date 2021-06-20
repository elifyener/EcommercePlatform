<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- head include begin -->
	<%@ include file="head.jsp"%>
	<!-- head include end -->
	
	<title>Anasayfa</title>
</head>
<body>	
	<!-- navbar begin -->
	<%@ include file="navbar.jsp"%>
	<!-- navbar end -->
	
	<!-- product tabs begin -->
	<div class = "product-tabs bg-custom-light mt-3 py-3">
		<div class ="container">
			<div class="row">
				<div class="col-12">
					<ul class="nav nav-tabs justify-content-end">
						<li class="nav-item">
							<a href="products" class="nav-link active rounded-0" data-toggle="tab">Ürünler </a>
						</li>
					</ul>
					<div class="tab-content">
						<div id = "products" class="tab-pane fade show active">
							<div class="row py-3">
							
								<!-- Product Card Begin-->
								<div class="col-sm-6 col-lg-3 mb-3 mb-lg-0 d-flex">
									<div class="card border-0 mb-3">
										<div class="card-body">
											<a href="#" ><img src="https://cdn.dsmcdn.com//ty51/product/media/images/20210325/12/75199292/18111190/1/1_org.jpg" alt="..." class="card-img-top"/></a>
											<div class="product-rating">
												<i class="text-warning fa fa-star"></i>
												<i class="text-warning fa fa-star"></i>
												<i class="text-warning fa fa-star"></i>
												<i class="text-warning fa fa-star"></i>
												<i class="text-warning fa fa-star"></i>
											</div>
											<p class = "card-text">
												What can be more convenient...
											</p>
											<h6 class="card-title">Elbise</h6>
											<p class = "card-text">
												Some quick example text to build on the card title and make up the bulk of the card's content.
											</p>
										</div>
										<div class="card-footer">
											<div class="row align-items-center">
												<div class ="col-auto">
													<a class="btn btn-dark rounded-0 btn-sm" role="button" href="#"><i class="fa-xs fa fa-shopping-cart"></i> Sepete Ekle</a>
												</div>
												<div class ="col card-price">
													<span class="price-old">$119</span>
													<span class="price-new">$89</span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Product Card End-->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- product tabs end -->
</body>
</html>