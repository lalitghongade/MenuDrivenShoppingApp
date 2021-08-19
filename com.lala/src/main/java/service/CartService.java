package service;

import model.Cart;
import java.util.List;
import service.serviceDao.*;

public class CartService implements CartServiceDAO {

    @Override
    public List<Cart> viewCart() {
        List<Cart> cartList = null;
        return cartList;
    }

    @Override
    public int addProductToCart(Cart cart) {
        int isSucessfull = 0;
        return isSucessfull;
    }
}
