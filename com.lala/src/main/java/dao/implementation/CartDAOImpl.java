package dao.implementation;

import dao.CartDAO;
import dbConnection.MySQLDBConnection;
import exception.BusinessException;
import model.Cart;
import model.Product;
import org.apache.log4j.Logger;
import pages.cart.CartPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    private static final Logger log = Logger.getLogger(CartPage.class);
    @Override
    public List<Cart> viewCart() throws BusinessException {
        List<Cart> cartList = new ArrayList<>();
        try(Connection connection = MySQLDBConnection.getConnection()) {
            String sql = "SELECT cartId, cartProductID, cartCustomerId FORM cart";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                Product product = new Product();
                product.setProductId(resultSet.getInt(""));

            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return null;
    }

    @Override
    public int addProductToCart(Cart cart) throws BusinessException {
        try(Connection connection = MySQLDBConnection.getConnection()) {
            String sql = "INSERT INTO cart(productId, customerId, productQuantity, productTotalPrice)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return 0;
    }
}
