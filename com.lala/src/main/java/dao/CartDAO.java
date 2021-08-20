package dao;
import java.util.List;

import exception.BusinessException;
import model.Cart;
import model.Customer;


public interface CartDAO {
	
	  public List<Cart> viewCart(Customer customer) throws BusinessException;
	    public int addProductToCart(Cart cart) throws BusinessException;
	    public int removeProductFromCart(int cartId) throws BusinessException;
}
