import java.util.List;

import controller.BikeShopHelper;
import model.BikeShop;

/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */


public class BikeShopTester {

	public static void main(String[] args) {
		
		BikeShop bikeShop = new BikeShop("mike", "123 Main Street, Anywhere, IA");
		BikeShop bikeShop2 = new BikeShop("john");
		
		BikeShopHelper bsh = new BikeShopHelper();
		
		bsh.insertBikeShop(bikeShop);
		bsh.insertBikeShop(bikeShop2);
		
		List<BikeShop> allShops = bsh.showAllBikeShops();
		for(BikeShop s : allShops) {
			System.out.println(s.toString());
		}
		

	}

}
