/**
 * 
 */
package main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Product;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			showMenu();
			int id = 0;
			String name, category = "";
			double price = 0;
			Date manufacturerDate, expiryDate = null;
			int choice = sc.nextInt();
			switch(choice) {
			case 0:
				controller.closeConnection();
				sc.close();
				System.out.println("Done.");
				System.exit(choice);
				
			case 1:
				System.out.println("Please enter product ID:");
				id = askForInt();		
				System.out.println("Please enter product name:");
				name = askForString();
				System.out.println("Please enter product categore:");
				category = askForString();
				System.out.println("Please enter product price:");
				price = askForDouble();
				System.out.println("Please enter manufacturer Date(yyyy-mm-dd):");
				manufacturerDate = askForDate();
				System.out.println("Please enter expiry Date(yyyy-mm-dd):");
				expiryDate = askForDate();
				Product p = new Product(id, name, price, expiryDate, manufacturerDate, category);
				controller.addProduct(p);
				break;
				
			case 2:
				System.out.println("Please enter product ID:");
				id = askForInt();
				controller.deleteProductById(id);
				break;
				
			case 3:
				System.out.println("Please enter product category:");
				category = askForString();
				controller.deleteProductByCat(category);
				break;
				
			case 4:
				System.out.println("Please enter product category:");
				category = askForString();
				Product cheapestProduct = controller.findCheapestProductInCat(category);
				System.out.printf("%s\n\n", cheapestProduct == null? "Not product in this category." : cheapestProduct.toString());
				break;
				
			case 5:
				System.out.println("Please enter product category:");
				category = askForString();
				List<Product> productList = controller.findProductByCat(category);
				if (productList.size() == 0) {
					System.out.println("No products in this category.");
				} else {
					for(Product eachProduct : productList) {
						System.out.println(eachProduct.toString());
					}
				}
				System.out.println();
				break;
				
			case 6:
				System.out.println("Please enter product ID:");
				id = askForInt();
				Product findProduct = controller.findProductById(id);
				System.out.printf("%s\n\n", findProduct == null? "Not product found." : findProduct.toString());
				break;
				
			case 7:
				System.out.println("Please enter product ID:");
				id = askForInt();
				if (controller.findProductById(id) == null) {
					System.out.println("No product has this ID.\n");
				} else {
					System.out.println("Please enter product's new name:");
					name = askForString();
					System.out.println("Please enter product's new categore:");
					category = askForString();
					System.out.println("Please enter product's new price:");
					price = askForDouble();
					System.out.println("Please enter new manufacturer's Date(yyyy-mm-dd):");
					manufacturerDate = askForDate();
					System.out.println("Please enter new expiry Date(yyyy-mm-dd):");
					expiryDate = askForDate();
					Product updatedProduct = new Product(id, name, price, expiryDate, manufacturerDate, category);
					controller.updateProduct(updatedProduct);
				}
				break;
				
			case 8:
				List<Product> expiredProducts = controller.findExpiredProducts();
				if (expiredProducts.size() == 0) {
					System.out.println("No expired product.");
				} else {
					for (Product expired : expiredProducts) {
						System.out.println(expired.toString());
					}
				}
				System.out.println();
				break;
				
			default:
				System.out.println("Not a vaild number");
			}
		}
		
	}

	private static void showMenu() {
		System.out.println("*****Menu******");
		System.out.println("Type 1 for adding a new record");
		System.out.println("Type 2 for deleting Product By Id");
		System.out.println("Type 3 for deleting Product By Category");
		System.out.println("Type 4 for finding Cheapest Product In Category");
		System.out.println("Type 5 for finding Product By Category");
		System.out.println("Type 6 for finding Product By Id");
		System.out.println("Type 7 for updating Product By Id");
		System.out.println("Type 8 for finding Expired Products");
		System.out.println("Type 0 to exit");
	}
	

	private static int askForInt() {
		return new Scanner(System.in).nextInt();
	}
	
	private static String askForString() {
		return new Scanner(System.in).nextLine();
	}
	
	private static Double askForDouble() {
		return new Scanner(System.in).nextDouble();
	}
	
	private static Date askForDate() {
		String s = new Scanner(System.in).nextLine();
		Date date = null;
		try {
			date = Date.valueOf(s);
		} catch (Exception e) {
			System.out.println("Not a vaild date, please enter data again.");
			date = askForDate();
		}
		return date;
	}
		
		
}
 