import java.util.List;

import controller.BikeHelper;
import model.Bike;

/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */


public class BikeTester {

	
	public static void main(String[] args) {
		
		Bike bike = new Bike("Scott Speedster", "Road", 50);
		
		BikeHelper bh = new BikeHelper();
		
		bh.insertBike(bike);
		
		List<Bike> allBikes = bh.showAllBikes();
		for(Bike b: allBikes) {
			System.out.println(b.toString());
		}

	}

}
