package service;

import dao.ProductSearchDAO;
import dao.implementation.ProductSearchDAOImpl;
import exception.BusinessException;
import model.Product;
import service.serviceDao.*;

import java.util.List;

public class ProductSearchService implements ProductSearchServiceDAO{
    ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
    @Override
    public List<Product> searchProductByCategory(int productCategory) throws BusinessException {
        List<Product> productList;
        if(productCategory > 0 && productCategory < 11) {
            productList = productSearchDAO.searchProductByCategory(productCategory);
        } else {
            throw new BusinessException("Invalid Product Category : Please enter numbers between (1-10)...");
        }
        return productList;
    }

    @Override
    public Product searchProductByProductAndCategory(int productChoice, int productCategoryChoice) throws BusinessException {
        Product product;
        if (productCategoryChoice > 0 && productCategoryChoice < 11) {
            product = productSearchDAO.searchProductByProductAndCategory(productChoice,productCategoryChoice);
        } else {
            throw new BusinessException("Invalid Product Category : Please enter numbers between (1-10)...");
        }
        return product;
    }
}
