package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.OrderSearchDAO;
import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Customer;
import model.Order;
import model.OrderStatus;
import model.Product;

public class OrderSearchDAOImpl implements OrderSearchDAO {
    private static final Logger log = Logger.getLogger(OrderSearchDAOImpl.class);
    @Override
    public Order searchOrderByOrderId(int orderId) throws BusinessException {
        Order order = new Order();
        try(Connection connection = MySQLDBConnection.getConnection()) {
            String sql = "SELECT orderId, orderCustomerId, orderProductId, productQuantity, orderTotal, orderStatusId FROM `orders` WHERE orderId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                Product product = new Product();
                OrderStatus orderStatus = new OrderStatus();
                order.setOrderId(orderId);
                customer.setCustomerId(resultSet.getInt("orderCustomerId"));
                product.setProductId(resultSet.getInt("orderProductId"));
                order.setOrderQuantity(resultSet.getInt("orderQuantity"));
                order.setOrderTotal(resultSet.getDouble("orderTotal"));
                orderStatus.setOrderStatusId(resultSet.getInt("orderStatusId"));
                order.setCustomer(customer);
                order.setProduct(product);
                order.setOrderStatus(orderStatus);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return order;
    }

    @Override
    public Order searchOrderByCustomerId(int customerId) throws BusinessException {
        Order order = new Order();
        try(Connection connection = MySQLDBConnection.getConnection()) {
            String sql = "SELECT orderId, orderCustomerId, orderProductId, orderQuantity, orderTotal, orderStatusId FROM `orders` WHERE orderCustomerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                Product product = new Product();
                OrderStatus orderStatus = new OrderStatus();
                order.setOrderId(resultSet.getInt("orderId"));
                customer.setCustomerId(resultSet.getInt("orderCustomerId"));
                product.setProductId(resultSet.getInt("orderProductId"));
                order.setOrderQuantity(resultSet.getInt("orderQuantity"));
                order.setOrderTotal(resultSet.getDouble("orderTotal"));
                orderStatus.setOrderStatusId(resultSet.getInt("orderStatusId"));
                order.setCustomer(customer);
                order.setProduct(product);
                order.setOrderStatus(orderStatus);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return order;
    }
}
