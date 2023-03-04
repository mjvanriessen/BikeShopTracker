package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bike;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String action = request.getParameter("doThisToBike");
		BikeHelper bh = new BikeHelper();
		String path = "/viewAllBikesServlet";
		
		if(action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bike bikeToDelete = bh.searchForBikeById(tempId);
				bh.deleteBike(bikeToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Please select a bike entry to delete");
			}
		}
		else if(action.equals("edit")) {
			try {
				Integer bikeId = Integer.parseInt(request.getParameter("id"));
				Bike bikeToEdit = bh.searchForBikeById(bikeId);
				request.setAttribute("bikeToEdit", bikeToEdit);
				path = "/edit-bike.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Please select a bike entry to edit");
			}
		}
		else if(action.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
