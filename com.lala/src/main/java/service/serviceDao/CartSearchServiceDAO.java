package service.serviceDao;

import exception.BusinessException;
import model.Cart;

public interface CartSearchServiceDAO {

	 public Cart searchCartByCartId(int cartId) throws BusinessException;
	
}
