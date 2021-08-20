package service;

import dao.CartSearchDAO;
import dao.implementation.CartSearchDAOImpl;
import exception.BusinessException;
import model.Cart;
import service.serviceDao.CartSearchServiceDAO;

public class CartSearchService implements CartSearchServiceDAO {
    CartSearchDAO cartSearchDAO = new CartSearchDAOImpl();

    @Override
    public Cart searchCartByCartId(int cartId) throws BusinessException {
        Cart cart;
        cart = cartSearchDAO.searchCartByCartId(cartId);
        return cart;
    }
}