package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Order;
import model.OrderStatus;
import model.Product;

public class OrderDAOImpl implements OrderDAO{
	 private static final Logger log = Logger.getLogger(OrderDAOImpl.class);
	    @Override
	    public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus) throws BusinessException {
	        int isSucessfull;
	        try(Connection connection = MySQLDBConnection.getConnection()) {
	            String sql = "INSERT INTO orders(orderCustomerId, orderProductId, orderQuantity, orderTotal, orderStatusId) VALUES (?,?,?,?,?)";
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
	    @Override
	    public List<Order> viewOrder(Customer customer) throws BusinessException {
	        List<Order> orderList = new ArrayList<>();
	        try(Connection connection = MySQLDBConnection.getConnection()) {
	            String sql = "SELECT o.orderId, o.orderCustomerId, o.orderProductId, o.orderQuantity, o.orderTotal, o.orderStatusId, os.orderStatusType FROM `orders` o JOIN orderstatus os ON o.orderStatusId = os.orderStatusId";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Order order = new Order();
	                Product product = new Product();
	                Customer customerObj = new Customer();
	                OrderStatus orderStatus = new OrderStatus();
	                order.setOrderId(resultSet.getInt("orderId"));
	                customerObj.setCustomerId(resultSet.getInt("orderCustomerId"));
	                product.setProductId(resultSet.getInt("orderProductId"));
	                order.setOrderQuantity(resultSet.getInt("orderQuantity"));
	                order.setOrderTotal(resultSet.getDouble("orderTotal"));
	                orderStatus.setOrderStatusId(resultSet.getInt("orderStatusId"));
	                orderStatus.setOrderStatusType(resultSet.getString("orderStatusType"));

	                order.setOrderStatus(orderStatus);
	                order.setCustomer(customerObj);
	                order.setProduct(product);
	                orderList.add(order);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            log.warn(e);
	            throw new BusinessException("Internal error occurred! contact systemAdmin");
	        }
	        return orderList;
	    }
	    
	    
	}