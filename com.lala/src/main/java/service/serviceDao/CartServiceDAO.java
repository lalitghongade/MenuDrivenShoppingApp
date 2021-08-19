package service.serviceDao;

import model.Cart;

import java.util.List;

public interface CartServiceDAO {
    public List<Cart> viewCart();
    public int addProductToCart(Cart cart);
}
