/**
 * 
 */
package model;

import java.sql.Date;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public class Product {
	private int id;
	private String name;
	private String category;
	private double price;
	private Date manufacturerDate;
	private Date expiryDate;
	
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param expiryDate
	 * @param manufacturerDate
	 * @param category
	 */
	public Product(int id, String name, double price, Date expiryDate, Date manufacturerDate, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.expiryDate = expiryDate;
		this.manufacturerDate = manufacturerDate;
		this.category = category;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the manufacturerDate
	 */
	public Date getManufacturerDate() {
		return manufacturerDate;
	}
	/**
	 * @param manufacturerDate the manufacturerDate to set
	 */
	public void setManufacturerDate(Date manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", manufacturerDate=" + manufacturerDate + ", expiryDate=" + expiryDate;
	}
	
	
	
	
}
