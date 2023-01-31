/**
 * 
 */
package controller;

import java.util.List;

import dao.ProductDaoImpl;
import model.Product;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public class Controller {
	ProductDaoImpl dao;
	public Controller() {
		this.dao = new ProductDaoImpl();
	}
	
	public void addProduct (Product p) {
		dao.addProduct(p);
	}
	
	public void deleteProductById(int id) {
		dao.deleteProductById(id);
	}
	
	public void deleteProductByCat(String category) {
		dao.deleteProductByCat(category);
	}
	
	public Product findCheapestProductInCat(String category) {
		return dao.findCheapestProductInCat(category);
	}
	
	public List<Product> findProductByCat(String category){
		return dao.findProductByCat(category);
	}
	
	public Product findProductById(int id) {
		return dao.findProductById(id);
	}
	
	public void updateProduct(Product p) {
		dao.updateProduct(p);
	}
	
	public List<Product> findExpiredProducts(){
		return dao.findExpiredProducts();
	}
	
	public void closeConnection() {
		dao.closeConnection();
	}
}
