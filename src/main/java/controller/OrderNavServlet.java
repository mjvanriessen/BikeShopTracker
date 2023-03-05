package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Orders;

/**
 * Servlet implementation class OrderNavServlet
 */
@WebServlet("/orderNavServlet")
public class OrderNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNavServlet() {
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
		String action = request.getParameter("doThisToOrder");
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
		}
		else if(action.equals("delete")) {
			try {
				Integer orderId = Integer.parseInt(request.getParameter("id"));
				Orders orderToDelete = oh.searchForOrderById(orderId);
				oh.deleteOrder(orderToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Please select an order to remove.");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			}
		}
		else if(action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Orders orderToEdit = oh.searchForOrderById(tempId);
				request.setAttribute("orderToEdit", orderToEdit);
				request.setAttribute("month", orderToEdit.getOrderDate().getMonthValue());
				request.setAttribute("date", orderToEdit.getOrderDate().getDayOfMonth());
				request.setAttribute("year", orderToEdit.getOrderDate().getYear());
				
				BikeHelper bh = new BikeHelper();
				request.setAttribute("allBikes", bh.showAllBikes());
				
				if(bh.showAllBikes().isEmpty()) {
					request.setAttribute("allBikes", " ");
				}
				getServletContext().getRequestDispatcher("/edit-order.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			}
		}
		
	}

}
