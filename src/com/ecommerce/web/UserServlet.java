package com.ecommerce.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.AdminOrderDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.model.AdminOrder;
import com.ecommerce.model.User;
@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
    private UserDao valiDao;
    private AdminOrderDao orderDao;

    public void init() {
        userDao = new UserDao();
        valiDao = new UserDao();
        orderDao = new AdminOrderDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/register":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/login":
                	authenticate(request, response);
                	break;
                case "/details":
                    showDetails(request, response);
                    break;
                default:
                    listOrder(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }


    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User newUser = new User(name, surname, email, password);
        userDao.saveUser(newUser);
        response.sendRedirect("login.jsp");
    }
    
    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
	    String username = request.getParameter("username");
	    String password = request.getParameter("pass");
	    User user = valiDao.validate(username, password);
	    if (user != null) {
	    	if (user.getEmail().equals("root")){
	    		response.sendRedirect("admin-panel.jsp");
	        	request.getSession().setAttribute("admin", valiDao.validate(username, password));
	    	}
	    	else {
	    	response.sendRedirect("index");
	    	request.getSession().setAttribute("user", valiDao.validate(username, password));
	    	}
	    }
	    else {
	    	response.sendRedirect("login.jsp");
	    }
	}
    
    private void listOrder(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < AdminOrder > orderlist = orderDao.getAllOrder();
        System.out.println(orderlist.get(0).getOrdernum());
        request.setAttribute("orderlist", orderlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-panel.jsp");
        dispatcher.forward(request, response);
   }
    
    @SuppressWarnings("unchecked")
	private void showDetails(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
        List <AdminOrder> orderId = (List<AdminOrder>) orderDao.getOrder(id);
        request.setAttribute("orderId", orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-details.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("order-details");
	}

}
