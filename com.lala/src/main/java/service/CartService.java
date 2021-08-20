package service;

import model.Cart;
import model.Customer;

import java.util.List;

import dao.CartDAO;
import dao.implementation.CartDAOImpl;
import exception.BusinessException;
import service.serviceDao.*;

public class CartService implements CartServiceDAO {
	CartDAO cartDAO = new CartDAOImpl();

    @Override
    public List<Cart> viewCart(Customer customer) throws BusinessException {
        List<Cart> cartList = null;
        cartList = cartDAO.viewCart(customer);
        return cartList;
    }

    @Override
    public int addProductToCart(Cart cart) throws BusinessException {
        int isSucessfull = 0;
        isSucessfull = cartDAO.addProductToCart(cart);
        return isSucessfull;
    }

    @Override
    public int removeProductFromCart(int cartId) throws BusinessException {
        return 0;
    }
}