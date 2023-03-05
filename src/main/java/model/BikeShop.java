/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bikeshop")
public class BikeShop {
	@Id
	@GeneratedValue
	private int id;
	private String bikeShopOwner;
	private String bikeShopLocation;
	
	public BikeShop() {
		super();
	}
	
	public BikeShop(String bikeShopOwner) {
		super();
		this.bikeShopOwner = bikeShopOwner;
	}
	
	public BikeShop(int id, String bikeShopOwner) {
		super();
		this.id = id;
		this.bikeShopOwner = bikeShopOwner;
	}
	
	public BikeShop(String bikeShopOwner, String bikeShopLocation) {
		super();
		this.bikeShopOwner = bikeShopOwner;
		this.bikeShopLocation = bikeShopLocation;
	}
	
	public BikeShop(int id, String bikeShopOwner, String bikeShopLocation) {
		super();
		this.id = id;
		this.bikeShopOwner = bikeShopOwner;
		this.bikeShopLocation = bikeShopLocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikeShopOwner() {
		return bikeShopOwner;
	}

	public void setBikeShopOwner(String bikeShopOwner) {
		this.bikeShopOwner = bikeShopOwner;
	}

	public String getBikeShopLocation() {
		return bikeShopLocation;
	}

	public void setBikeShopLocation(String bikeShopLocation) {
		this.bikeShopLocation = bikeShopLocation;
	}

	@Override
	public String toString() {
		return "BikeShop [id=" + id + ", bikeShopOwner=" + bikeShopOwner + ", bikeShopLocation=" + bikeShopLocation
				+ "]";
	}
	
	
	
	

}
