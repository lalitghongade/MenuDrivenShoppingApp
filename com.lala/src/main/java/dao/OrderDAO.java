package dao;

import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Product;

public interface OrderDAO {
	
	
	  public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus) throws BusinessException;
	}


