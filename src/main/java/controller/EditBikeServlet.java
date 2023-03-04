package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bike;

/**
 * Servlet implementation class EditBikeServlet
 */
@WebServlet("/editBikeServlet")
public class EditBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBikeServlet() {
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
		BikeHelper bh = new BikeHelper();
		String bikeModel = request.getParameter("bikeModel");
		String bikeUse = request.getParameter("bikeUse");
		String bikePriceStr = request.getParameter("bikePrice");
		int bikePrice = Integer.parseInt(bikePriceStr);
		Integer tempId;
		tempId = Integer.parseInt(request.getParameter("id")); // This isn't efficient, was just trying some things to resolve an HTTP error. Should still work
		
		
		Bike bikeToUpdate = bh.searchForBikeById(tempId);
		bikeToUpdate.setBikeModel(bikeModel);
		bikeToUpdate.setBikeUse(bikeUse);
		bikeToUpdate.setBikePrice(bikePrice);
		bh.updateBike(bikeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBikesServlet").forward(request, response);
	}

}
