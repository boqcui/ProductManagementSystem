/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc.JdbcUtility;
import model.Product;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public class ProductDaoImpl implements ProductDao {
	private Scanner sc;
	private Connection con;
	
	
	/**
	 * @param sc
	 */
	public ProductDaoImpl() {
		this.sc = new Scanner(System.in);
		con = new JdbcUtility("jdbs_db", "root", "root").getConnection();
	}

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO product" 
					 + "(id, name, category, price, manufacturer_date, expiry_date)"
					 + "VALUES(?,?,?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getCategory());
			ps.setDouble(4, p.getPrice());
			ps.setDate(5, p.getManufacturerDate());
			ps.setDate(6, p.getExpiryDate());
			System.out.printf("%s\n\n", ps.executeUpdate()>0? "addProduct Done" : "addProduct Failed");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM product "
					 + "WHERE id = " + id +";";
		executeQuery(query);
		System.out.println("delete By Id Done.\n");
	}

	@Override
	public void deleteProductByCat(String category) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM product "
					 + "WHERE category = " + "'"+category+"'" +";";
		executeQuery(query);
		System.out.println("delete By Category Done.\n");
	}

	@Override
	public Product findCheapestProductInCat(String category) {
		// TODO Auto-generated method stub
		String query = "SELECT * "
					 + "FROM product "
					 + "WHERE category = " + "'"+category+"'" + " "
					 + "ORDER BY price "
					 + "LIMIT 1;";
		Product p = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			p = rs.next()? convertToProduct(rs) : null;
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> findProductByCat(String category) {
		// TODO Auto-generated method stub
		String query = "SELECT * "
				 	 + "FROM product "
				 	 + "WHERE category = " + "'"+category+"'" + ";";
		ArrayList<Product> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(convertToProduct(rs));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * "
					 + "FROM product "
					 + "WHERE id = " + id + ";";
		Product p = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			p = rs.next()? convertToProduct(rs) : null;
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		String query = "UPDATE product "
					 + "SET name = ?, category = ?, price = ?, manufacturer_date = ?, expiry_date = ? "
					 + "WHERE id = " + p.getId() + ";";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setString(2, p.getCategory());
			ps.setDouble(3, p.getPrice());
			ps.setDate(4, p.getManufacturerDate());
			ps.setDate(5, p.getExpiryDate());
			System.out.printf("%s\n\n", ps.executeUpdate()>0? "update Product Done" : "update Product Failed");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findExpiredProducts() {
		// TODO Auto-generated method stub
		String query = "SELECT * "
			 	 	 + "FROM product "
			 	 	 + "WHERE expiry_date < CURDATE();";
		ArrayList<Product> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(convertToProduct(rs));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void executeQuery(String query) {
		try {
			Statement statement = con.createStatement();
			statement.execute(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Product convertToProduct(ResultSet rs) {
		Product p = null;
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String category = rs.getString("category");
			double price = rs.getDouble("price");
			Date manufacturerDate = rs.getDate("manufacturer_date");
			Date expiryDate = rs.getDate("expiry_date");
			p = new Product(id, name, price, expiryDate, manufacturerDate, category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
