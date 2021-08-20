package service.serviceDao;

import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Product;

import model.Order;
import java.util.List;

public interface OrderServiceDAO {

	  public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus) throws BusinessException;
	  public List<Order> viewOrder(Customer customer) throws BusinessException;
}
