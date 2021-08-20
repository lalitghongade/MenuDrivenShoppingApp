package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Product;

public class OrderDAOImpl implements OrderDAO{
	 private static final Logger log = Logger.getLogger(OrderDAOImpl.class);
	    @Override
	    public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus) throws BusinessException {
	        int isSucessfull;
	        try(Connection connection = MySQLDBConnection.getConnection()) {
	            String sql = "INSERT INTO order(orderCustomerId, orderProductId, orderQuantity, orderTotal, orderStatusId) VALUES (?,?,?,?,?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, customer.getCustomerId());
	            preparedStatement.setInt(2, product.getProductId());
	            preparedStatement.setInt(3, cart.getCartProductQuantity());
	            preparedStatement.setDouble(4, cart.getCartProductTotal());
	            preparedStatement.setInt(5, orderStatus);

	            isSucessfull = preparedStatement.executeUpdate();
	        } catch (ClassNotFoundException | SQLException e) {
	            log.warn(e);
	            throw new BusinessException("Internal error occurred! contact systemAdmin");
	        }
	        return isSucessfull;
	    }
	}