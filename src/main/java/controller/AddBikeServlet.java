package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bike;

/**
 * Servlet implementation class AddBikeServlet
 */
@WebServlet("/addBikeServlet")
public class AddBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bikeModel = request.getParameter("bikeModel");
		String bikeUse = request.getParameter("bikeUse");
		String bikePriceStr = request.getParameter("price");
		int bikePrice = Integer.parseInt(bikePriceStr);
		
		Bike newbike = new Bike(bikeModel, bikeUse, bikePrice);
		BikeHelper bh = new BikeHelper();
		bh.insertBike(newbike);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
