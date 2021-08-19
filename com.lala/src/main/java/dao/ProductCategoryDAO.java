package dao;
import java.util.List;

import exception.BusinessException;
import model.ProductCategory;
public interface ProductCategoryDAO {
	
	  public List<ProductCategory> viewProductCategory() throws BusinessException;
	  public int addCategory(ProductCategory productCategory);
	  public int deleteCategory(ProductCategory productCategory);
	
	

}
