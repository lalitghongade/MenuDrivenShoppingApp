package dao;

import java.util.List;

import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Order;
import model.Product;

public interface OrderDAO {
	
	
	  public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus) throws BusinessException;
	  public List<Order> viewOrder(Customer customer) throws BusinessException;
}


