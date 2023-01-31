/**
 * 
 */
package dao;

import java.util.List;
import model.Product;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public interface ProductDao {
	public void addProduct(Product p);

	public void deleteProductById(int id);
	
	public void deleteProductByCat(String category);
	
	public Product findCheapestProductInCat(String category);
	
	public List<Product> findProductByCat(String category);
	
	public Product findProductById(int id);

	public void updateProduct(Product p);

	public List<Product> findExpiredProducts();

}
