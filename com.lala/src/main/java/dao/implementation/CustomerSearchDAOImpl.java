package dao.implementation;

import org.apache.log4j.Logger;

import dao.CustomerSearchDAO;
import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerSearchDAOImpl implements CustomerSearchDAO {
	private static final Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);

	@Override
	public Customer searchCustomerByUsername(String customerUsername) throws BusinessException {
		// TODO Auto-generated method stub
		  Customer customer = new Customer();
	        try(Connection connection = MySQLDBConnection.getConnection()) {
	            String sql = "SELECT customerId, name, username, password FROM customers";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                customer.setCustomerId(resultSet.getInt("customerId"));
	                customer.setCustomerName(resultSet.getString("name"));
	                customer.setCustomerUsername(resultSet.getString("username"));
	                customer.setCustomerPassword(resultSet.getString("password"));
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            log.warn(e);
	            throw new BusinessException("Internal error occurred! contact systemAdmin");
	        }
	        return customer;
	}
	
}
