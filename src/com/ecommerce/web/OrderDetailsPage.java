package com.ecommerce.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ecommerce.dao.UserOrderDao;
import com.ecommerce.model.UserOrder;

@WebServlet("/details")
public class OrderDetailsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");//Formdan gelen veri her zaman stringdir
		if(id != null && !id.equals("")){
			int orderId = Integer.parseInt(id); //Bu yüzden String gelen id yi inte çeviririz.
			List <UserOrder> orderlists = (List<UserOrder>) UserOrderDao.getAllOrder(orderId);
			System.out.println(orderlists);
			request.setAttribute("orderlists", orderlists);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("order-details.jsp");
	        dispatcher.forward(request, response);
		}
	}

}