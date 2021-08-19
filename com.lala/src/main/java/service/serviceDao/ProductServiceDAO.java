package service.serviceDao;

import exception.BusinessException;
import model.Product;

import java.util.List;

public interface ProductServiceDAO {
    public int createProduct(Product product) throws BusinessException;
    public int deleteProduct(int productId);
    public List<Product> viewProduct();
}
