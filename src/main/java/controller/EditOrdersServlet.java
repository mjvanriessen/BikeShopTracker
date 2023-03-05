package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bike;
import model.BikeShop;
import model.Orders;

/**
 * Servlet implementation class EditOrdersServlet
 */
@WebServlet("/editOrdersServlet")
public class EditOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersHelper oh = new OrdersHelper();
		BikeHelper bh = new BikeHelper();
		BikeShopHelper bsh = new BikeShopHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Orders orderToUpdate = oh.searchForOrderById(tempId);
		
		String newCustomerName = request.getParameter("customerName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String ownerName = request.getParameter("ownerName");
		
		BikeShop newBikeShop = bsh.findBikeShop(ownerName);
		
		LocalDate dd;
		try {
			dd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException e) {
			dd = LocalDate.now();
		}
		
		try {
			String[] selectedBikes = request.getParameterValues("allBikesAdded");
			List<Bike> selectedBikeList = new ArrayList<Bike>();
			
			for(int i = 0; i<selectedBikes.length; i++) {
				Bike b = bh.searchForBikeById(Integer.parseInt(selectedBikes[i]));
				selectedBikeList.add(b);
			}
			orderToUpdate.setOrderDetails(selectedBikeList);
		} catch(NullPointerException e) {
			List<Bike> selectedBikeList = new ArrayList<>();
			orderToUpdate.setOrderDetails(selectedBikeList);
		}
		
		orderToUpdate.setCustomerName(newCustomerName);
		orderToUpdate.setOrderDate(dd);
		orderToUpdate.setBikeShop(newBikeShop);
		
		oh.updateOrder(orderToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}

}
