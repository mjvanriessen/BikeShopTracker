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
 * Servlet implementation class AddNewOrderServlet
 */
@WebServlet("/addNewOrderServlet")
public class AddNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BikeHelper bh = new BikeHelper();
		String customerName = request.getParameter("customerName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		String shopLocation = request.getParameter("shopLocation");
		LocalDate dd;
		try {
			dd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException e) {
			dd = LocalDate.now();
		}
		
		String[] selectedBikes = request.getParameterValues("allBikesAdded");
		List<Bike> selectedBikesList = new ArrayList<Bike>();
		if(selectedBikes != null && selectedBikes.length > 0){
			for(int i = 0; i<selectedBikes.length; i++) {
				System.out.println(selectedBikes[i]);
				Bike b = bh.searchForBikeById(Integer.parseInt(selectedBikes[i]));
				selectedBikesList.add(b);
			}
		}
		
		BikeShop bikeShop = new BikeShop(ownerName, shopLocation);
		Orders newOrder = new Orders(customerName, dd, bikeShop);
		newOrder.setOrderDetails(selectedBikesList);
		OrdersHelper oh = new OrdersHelper();
		oh.insertNewOrders(newOrder);
		
		System.out.println(newOrder.toString());
		
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
