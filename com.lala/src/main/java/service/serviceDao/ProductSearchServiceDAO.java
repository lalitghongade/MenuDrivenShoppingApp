package service.serviceDao;

import exception.BusinessException;
import model.Product;

import java.util.List;

public interface ProductSearchServiceDAO {
	public List<Product> searchProductByCategory(int productCategory) throws BusinessException;
	    public Product searchProductByProductId(int productId) throws BusinessException;
	    public Product searchProductByProductAndCategory(int productChoice, int productCategoryChoice) throws BusinessException;
	}

