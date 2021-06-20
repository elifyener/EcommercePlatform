package com.ecommerce.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.model.Item;
import com.ecommerce.model.*;
import com.ecommerce.dao.*;
import com.ecommerce.web.*;
import com.ecommerce.utl.*;
/**
 * Servlet implementation class CatologPage
 */
@WebServlet("/index")
public class CatalogPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Item[] items;
	private String[] itemIDs = { "lillian001", "bag001","bejhat001", "flowdress001", "blackcrop001",
			"blackcigarette001","blueskirt001","lilashirt001" };
	private UserDao valiDao;
	/**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		valiDao = new UserDao();
	}
	protected void setItems(String[] itemIDs) {
		this.itemIDs = itemIDs;
		items = new Item[itemIDs.length];
		for(int i=0; i<items.length; i++) {
			items[i] = ItemCatalog.getItem(itemIDs[i]);
		}
	}
	
    public CatalogPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		setItems(itemIDs);
		if (items == null) {
			response.sendError(response.SC_NOT_FOUND,
			"Missing Items.");
			return;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html>"+
				"<html>"+
				"<head>"+
				"<meta charset='utf-8'>"+
				"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"+
				"<title>Anasayfa</title>"+

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
				  "<button class=\'navbar-toggler\' type=\'button\' data-toggle=\'collapse\' data-target=\'#navbarNav\' "
				  + "aria-controls=\'navbarNav\' aria-expanded=\'false\' aria-label=\'Toggle navigation\'>"+
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
				"</nav>"+
				"<!-- product tabs begin -->"+
				"<div class = 'product-tabs bg-custom-light mt-3 py-3'>"+
					"<div class ='container'>"+
						"<div class='row'>"+
							"<div class='col-12'>"+
								"<ul class='nav nav-tabs justify-content-end'>"+
									"<li class='nav-item'>"+
										"<a href='products' class='nav-link active rounded-0' data-toggle='tab'>Ürünler </a>"+
									"</li>"+
								"</ul>"+
								"<div class='tab-content'>"+
									"<div id = 'products' class='tab-pane fade show active'>"+
										"<div class='row py-3'>";
		
		out.println(docType);
		Item item;
		for(int i=0; i<items.length; i++) {
			out.println("<HR>");
			item = items[i];
			NumberFormat formatter = new DecimalFormat("#0.00");
			String itemOld = formatter.format(item.getCost()+50);
			// Show error message if subclass lists item ID
			// that's not in the catalog.
			if (item == null) {
				out.println("<FONT COLOR=\"RED\">" +
							"Unknown item ID " + itemIDs[i] +
							"</FONT>");
			} else {
				out.println();
				String formURL = "cart";
			// Pass URLs that reference own site through encodeURL.
			formURL = response.encodeURL(formURL);
			
			out.println("<!-- Product Card Begin-->"+
			"<div class='col-sm-6 col-lg-3 mb-3 mb-lg-0 d-flex'>"+
				"<div class='card border-0 mb-3'>"+
					"<div class='card-body'>"+
						"<a href='#' ><img src="+item.getShortDescription() +" alt='...' class='card-img-top'/></a>"+
						"<div class='product-rating'>"+
							"<i class='text-warning fa fa-star'></i>"+
							"<i class='text-warning fa fa-star'></i>"+
							"<i class='text-warning fa fa-star'></i>"+
							"<i class='text-warning fa fa-star'></i>"+
							"<i class='text-warning fa fa-star'></i>"+
						"</div>"+
						"<p class = 'card-text'>"+
							item.getName()+
						"</p>"+
						"<p class = 'card-text'>"+
							item.getLongDescription()+
						"</p>"+
					"</div>"+
					"<form id='test' action="+formURL+" method='post'>"+
					"<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
					" VALUE=\"" + item.getItemID() + "\">\n" +
					"<div class='card-footer'>"+
						"<div class='row align-items-center'>"+
							"<div class ='col-auto'>"+
								
								"<button type='submit' class='btn btn-dark rounded-0 btn-sm' ><i class='fa-xs fa fa-shopping-cart'></i> Sepete Ekle</button>"+
							"</div>"+
							"<div class ='col card-price'>"+
								"<span class='price-old'>"+ itemOld+ "TL</span>"+
								"<br>"+
								"<span class='price-new'>"+ item.getCost()+ "TL</span>"+
							"</div>"+
						"</div>"+
					"</div>"+
					"</form>"+
				"</div>"+
			"</div>"+
			"<!-- Product Card End-->");
			
			}
		}
		out.println("						</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<!-- product tabs end --></BODY></HTML>");
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
