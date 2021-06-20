package com.ecommerce.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.utl.ShoppingCart;
import com.ecommerce.model.ItemOrder;

@WebServlet("/cart")
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart;
		String itemID = request.getParameter("itemID");
		
		synchronized(session) {
			cart = (ShoppingCart)session.getAttribute("shoppingCart");
			// New visitors get a fresh shopping cart.
			// Previous visitors keep using their existing cart.
			if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("shoppingCart", cart);
			}
			
			if (itemID != null) {
				String numItemsString =
				request.getParameter("numItems");
				if (numItemsString == null) {
					cart.addItem(itemID);
				} else {
					int numItems;
					try {
						numItems = Integer.parseInt(numItemsString);
					} catch(NumberFormatException nfe) {
						numItems = 1;
					}
					cart.setNumOrdered(itemID, numItems);
				}
			}
		}
		// Whether or not the customer changed the order, show
		// order status.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "Status of Your Order";
		String docType =
						"<!DOCTYPE html>"+
						"<html>"+
						"<head>"+
						"<meta charset='utf-8'>"+
						"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"+
						"<title>Sepetim</title>"+

						"<!-- CSS Styles -->"+
						"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>"+
						"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>"+
						"<link rel='stylesheet' href='Content'\'site.css'>"+

						"<!-- Font -->"+
						"<link rel='preconnect' href='https://fonts.gstatic.com'>"+
						"<link href='https://fonts.googleapis.com/css2?family=Open+Sans&display=swap' rel='stylesheet'>"+

						"<!-- Javascripts -->"+
						"<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>"+
						"<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>"+
						"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>"+
						
						"<!-- Icon -->"+
						"<link rel = 'icon' href = "+
						"'https://c3.klipartz.com/pngpicture/307/726/sticker-png-daisy-thumbnail.png' type = 'image/x-icon'>"+
						
						"</head>"+
						"<style>"+
						"body{font-family:'Open Sans', sans-serif; font-size: 13px;}"+
						".shadow{box-shadow: 0px 0px 8px #000;}"+
						".bg-custom-light{background: #f5f5f5;}"+

						".product-tabs .card .card-footer{background: transparent; border-top: 0;}"+
						".card-price{color: #262626; font-size: 17px; font-weight: 600;}"+

						".price-old{color: #878787; text-decoration: line-through; font-weight: 500;}"+
						".card:hover{box-shadow:0px 2px 10px 0px rgba(49,57,66,0.12);}"+
						"</style>"+
						"<body>"+
						"<nav class='navbar navbar-expand-md navbar-light bg-light'>"+
						  "<a class='navbar-brand' href='index'>My Shop</a>"+
						  "<button class=\'navbar-toggler\' type=\'button\' data-toggle=\'collapse\' data-target=\'#navbarNav\' aria-controls=\'navbarNav\' aria-expanded=\'false\' aria-label=\'Toggle navigation\'>"+
						  	"<span class='navbar-toggler-icon'></span>"+
						  "</button>"+
						  "<div class='collapse navbar-collapse' id='navbarNav'>"+
						 		"<ul class='navbar-nav mr-auto mt-2 mt-log-0'>"+
						  		"<li class='nav-item active'>"+
						  			"<a class='nav-link' href=index>Ana Sayfa <span class='sr-only'>(current)</span></a>"+
						 		 "</li>"+
						 	 "</ul>"+
						  	"<ul class= 'navbar-nav navbar-right'>";
						    if(request.getSession().getAttribute("user") == null){
						      docType += "<li class='nav-item'>"+
						        "<a class='nav-link' href='register.jsp'>"+
						        	"<span class = 'fa fa-user-plus mr-2'></span> Kayýt Ol"+
						        "</a>"+
						      "</li>"+
						      "<li class='nav-item'>"+
						        "<a class='nav-link' href='login.jsp'>"+
						        	"<span class = 'fa fa-sign-in mr-2'></span>Giriþ"+
						        "</a>"+
						      "</li>";
						    }
						    docType += "<li class='nav-item'>"+
						        "<a class='nav-link' href='cart'>"+
						        	"<span class = 'fa fa-shopping-cart mr-2'></span>Sepete Git"+
						        "</a>"+
						      "</li>";
						      if(request.getSession().getAttribute("user") != null){
						    	docType +="<li class='nav-item'>"+
						        "<a class='nav-link' href='orders.jsp'>"+
						        	"<span class = 'fa fa-truck mr-2'></span>Sipariþlerim"+
						        "</a>"+
						      "</li>"+
						      "<li class='nav-item'>"+
						        "<a class='nav-link' href='logout'>"+
						        	"<span class = 'fa fa-sign-out mr-2'></span>Çýkýþ"+
						        "</a>"+
						      "</li>";
						      }
						     docType +="</ul>"+
						  "</div>"+
						"</nav>";
				
				out.println(docType);
		synchronized(session) {
			List itemsOrdered = cart.getItemsOrdered();
			if (itemsOrdered.size() == 0) {
				out.println("<div class=\"container\">\r\n" + 
						"		<div class=\"row my-4\">\r\n" + 
						"			<div class = \"col-md-4 offset-md-4 my-4\">\r\n" + 
						"				<i  class=\"fa fa-shopping-cart\" style=\"font-size: 20rem; color: #F8C471;\"></i>\r\n" + 
						"				<h1 text-align='center'>&nbsp&nbsp&nbsp&nbspSepetiniz Boþ</h1>" + 				
						"			</div>" + 
						"		</div>" + 
						"	</div>");
			} else {
				// If there is at least one item in cart, show table
				// of items ordered.
				out.println(
						"<!-- cart table begin -->"+
						"<div class=' mt-4 mr-4 ml-4'>"+
						"<table class= 'table table-bordered'>"+
							"<thead>"+
								"<tr>"+
									"<th>Ürün Kodu </th>"+
									"<th>Ürün Adý</th>"+
									"<th>Fiyat</th>"+
									"<th>Adet</th>"+
									"<th>Toplam Fiyat</th>"+
									"<th></th>"+
								"</tr>"+
							"</thead>"+
							"<tbody>");
				ItemOrder order;
				// Rounds to two decimal places, inserts dollar
				// sign (or other currency symbol), etc., as
				// appropriate in current Locale.
				NumberFormat formatter =
					NumberFormat.getCurrencyInstance();
				// For each entry in shopping cart, make
				// table row showing ID, description, per-item
				// cost, number ordered, and total cost.
				// Put number ordered in textfield that user
				// can change, with "Update Order" button next
				// to it, which resubmits to this same page
				// but specifying a different number of items.
				
				for(int i=0; i<itemsOrdered.size(); i++) {
					order = (ItemOrder)itemsOrdered.get(i);
					out.println(
						
							"<tr>"+
								"<td>"+ order.getItemID() +"</td>"+
								"<td>"+ order.getName()+"</td>"+
								"<td>"+ formatter.format(order.getUnitCost())+"</td>"+
								"<td>"+
									"<form>" + // Submit to current URL
									   "<input type ='hidden' name='itemID' value= "+ order.getItemID()+" >" +
									   "<div class='row align-items-center'>"+
											"<div class ='col-auto'>"+
												"<input type='text' name='numItems' class='form-control form-control-sm'"+ 
												"aria-label='Small' size=1 aria-describedby='inputGroup-sizing-sm'"+
												"value=" +order.getNumItems() + ">" +
											"</div>"+
											"<div class ='col-auto'>"+
												"<button type='submit' class='btn btn-primary btn-sm'>Güncelle</button>" +
											"</div>"+
										"</div>"+
								    "</form>"+
								"</td>"+
								"<td>"+formatter.format(order.getTotalCost())+"</td>"+
								
								"<form>" + // Submit to current URL
								   "<input type ='hidden' name='itemID' value= "+ order.getItemID()+" >" +
								   "<div class='row align-items-center'>"+
										"<div class ='col-auto'>"+
											"<input type='hidden' name='numItems' class='form-control form-control-sm'"+ 
											"aria-label='Small' size=1 aria-describedby='inputGroup-sizing-sm'"+
											"value=" + 0 + ">" +
										"</div>"+
										"<div class ='col-auto'>"+
										"<td><button type = 'submit' class='btn btn-danger'><i class='fa fa-trash'></i> Sil</button></td>"+
										"</div>"+
									"</div>"+
							    "</form>"+
							"</tr>"
						);
				}
				out.println
			  	   ("</tbody>" + 
			  		"</table>"+
					"</tbody>"+
					"</table>"+
					"<a href='index' class='btn btn-success'><i class='fa fa-arrow-left'></i> Alýþveriþe Devam Et</a>");
					if(request.getSession().getAttribute("user") == null){
						out.println("<a href='login.jsp' class='btn btn-success pull-right'>Alýþveriþe Tamamla"+ 
								"<i class='fa fa-arrow-right'></i></a>");
					}
					if(request.getSession().getAttribute("user") != null){
						out.println("<a href='payment.jsp' class='btn btn-success pull-right'>Alýþveriþe Tamamla"+ 
								"<i class='fa fa-arrow-right'></i></a>");
					}
					out.println("</div>"+
					"<!-- cart table begin -->"+
					"</body>"+
					"</html>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
