import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.BikeShopHelper;
import controller.OrdersHelper;
import model.Bike;
import model.BikeShop;
import model.Orders;

/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */


public class OrdersTester {

	
	public static void main(String[] args) {
		
		BikeShop bikeShop = new BikeShop("mike");
		
		BikeShopHelper bsh = new BikeShopHelper();
		
		Bike bike1 = new Bike("scott", "mountain", 100);
		Bike bike2 = new Bike("trek", "road", 200);
		
		List<Bike> mikesBikes = new ArrayList<Bike>();
		mikesBikes.add(bike2);
		mikesBikes.add(bike1);
		
		OrdersHelper oh = new OrdersHelper();
		
		Orders mikeOrders = new Orders("jenn smith", LocalDate.now(), bikeShop);
		mikeOrders.setOrderDetails(mikesBikes);
		
		oh.insertNewOrders(mikeOrders);
		
		List<Orders> allOrders = oh.getOrders();
		
		for (Orders o : allOrders) {
			System.out.println(o.toString());
		}

	}

}
