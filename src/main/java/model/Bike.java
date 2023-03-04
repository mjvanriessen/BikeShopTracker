/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bikes")
public class Bike {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MODEL")
	private String bikeModel;
	@Column(name="SPECIALTY")
	private String bikeUse;
	@Column(name="PRICE")
	private int bikePrice;
	
	public Bike() {
		super();
	}
	
	public Bike(String bikeModel) {
		this.bikeModel = bikeModel;
	}
	
	public Bike(String bikeModel, String bikeUse) {
		super();
		this.bikeModel = bikeModel;
		this.bikeUse = bikeUse;
	}
	
	public Bike(String bikeModel, String bikeUse, int bikePrice) {
		super();
		this.bikeModel = bikeModel;
		this.bikeUse = bikeUse;
		this.bikePrice = bikePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public String getBikeUse() {
		return bikeUse;
	}

	public void setBikeUse(String bikeUse) {
		this.bikeUse = bikeUse;
	}

	public int getBikePrice() {
		return bikePrice;
	}

	public void setBikePrice(int bikePrice) {
		this.bikePrice = bikePrice;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", bikeModel=" + bikeModel + ", bikeUse=" + bikeUse + ", bikePrice=" + bikePrice
				+ "]";
	}

	
	
	

}
