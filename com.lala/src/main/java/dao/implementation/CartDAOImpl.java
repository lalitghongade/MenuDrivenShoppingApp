package dao.implementation;

import dao.CartDAO;
import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Product;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    private static final Logger log = Logger.getLogger(CartDAOImpl.class);
    @Override
    public List<Cart> viewCart(Customer customer) throws BusinessException {
        List<Cart> cartList = new ArrayList<>();
        try(Connection connection = MySQLDBConnection.getConnection()) {
            String sql = "SELECT cartId, productId, customerId, productQuantity, productTotalPrice FROM cart WHERE customerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCustomerId());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                Product product = new Product();
                Customer customerObj = new Customer();
                cart.setCartId(resultSet.getInt("cartId"));
                product.setProductId(resultSet.getInt("productID"));
                customerObj.setCustomerId(resultSet.getInt("customerId"));
                cart.setCartProductQuantity(resultSet.getInt("productQuantity"));
                cart.setCartProductTotal(resultSet.getDouble("ProductTotalPrice"));
                cart.setProduct(product);
                cart.setCustomer(customerObj);
                cartList.add(cart);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return cartList;
    }
    @Override
    public int addProductToCart(Cart cart) throws BusinessException {
    	int isSucessfull;
        try(Connection connection = MySQLDBConnection.getConnection()) {
        	String sql = "INSERT INTO cart(productId, customerId, productQuantity, productTotalPrice) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart.getProduct().getProductId());
            preparedStatement.setInt(2, cart.getCustomer().getCustomerId());
            preparedStatement.setInt(3, cart.getCartProductQuantity());
            preparedStatement.setDouble(4, cart.getCartProductTotal());

            isSucessfull = preparedStatement.executeUpdate();
            if (isSucessfull == 0) {
                throw new BusinessException(" creation failed! Check your query and try again!!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return isSucessfull;
    }
	@Override
	public int removeProductFromCart(int cartId) throws BusinessException {
		 int isSucessfull;
	        try(Connection connection = MySQLDBConnection.getConnection()) {
	            String sql = "DELETE FROM cart WHERE cartId=?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, cartId);
	            isSucessfull = preparedStatement.executeUpdate();
	        } catch (ClassNotFoundException | SQLException e) {
	            log.warn(e);
	            throw new BusinessException("Internal error occurred! contact systemAdmin");
	        }
	        return isSucessfull;
	}
}
