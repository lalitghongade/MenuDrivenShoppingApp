package service.serviceDao;

import model.Cart;
import model.Customer;

import java.util.List;

import exception.BusinessException;

public interface CartServiceDAO {
	  public List<Cart> viewCart(Customer customer) throws BusinessException;
	    public int addProductToCart(Cart cart) throws BusinessException;
	    public int removeProductFromCart(int cartId) throws BusinessException;
}
