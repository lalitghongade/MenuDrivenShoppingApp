package service;
import dao.ProductDAO;
import dao.implementation.ProductDAOImpl;
import exception.BusinessException;
import model.Product;
import service.serviceDao.*;

import java.util.List;

public class ProductService implements ProductServiceDAO{
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public int createProduct(Product product) throws BusinessException {
        int isSucessfull;
        if (product.getProductName().length() != 0) {
            isSucessfull = productDAO.createProduct(product);
        } else {
            throw new BusinessException("Invalid Product Details");
        }
        return isSucessfull;
    }

    @Override
    public int deleteProduct(int productId) {
        return 0;
    }

    @Override
    public List<Product> viewProduct() {
        return null;
    }
}
