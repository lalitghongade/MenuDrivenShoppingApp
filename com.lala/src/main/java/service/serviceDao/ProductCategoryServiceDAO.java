package service.serviceDao;

import exception.BusinessException;
import model.ProductCategory;

import java.util.List;
import java.util.Locale;

public interface ProductCategoryServiceDAO{
    public List<ProductCategory> viewProductCategory() throws BusinessException;
    public int addCategory(ProductCategory productCategory);
    public int deleteCategory(ProductCategory productCategory);
}
