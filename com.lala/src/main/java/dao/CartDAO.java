package dao;
import java.util.List;

import exception.BusinessException;
import model.Cart;


public interface CartDAO {
	
	public List<Cart> viewCart() throws BusinessException;
	public int addProductToCart(Cart cart) throws BusinessException;
}
