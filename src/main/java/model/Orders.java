/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	private LocalDate orderDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private BikeShop bikeShop;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Bike> orderDetails;
	
	public Orders() {
		
	}
	
	public Orders(int id, String customerName, LocalDate orderDate, BikeShop bikeShop, List<Bike> orderDetails) {
		this.id = id;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.bikeShop = bikeShop;
		this.orderDetails = orderDetails;
	}
	
	public Orders(String customerName, LocalDate orderDate, BikeShop bikeShop, List<Bike> orderDetails) {
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.bikeShop = bikeShop;
		this.orderDetails = orderDetails;
	}
	
	public Orders(String customerName, LocalDate orderDate, BikeShop bikeShop) {
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.bikeShop = bikeShop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public BikeShop getBikeShop() {
		return bikeShop;
	}

	public void setBikeShop(BikeShop bikeShop) {
		this.bikeShop = bikeShop;
	}

	public List<Bike> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Bike> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", bikeShop="
				+ bikeShop + ", orderDetails=" + orderDetails + "]";
	}
	
	

}
