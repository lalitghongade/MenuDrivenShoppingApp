package service.serviceDao;
import exception.BusinessException;
import model.Customer;

public interface CustomerSearchServiceDAO {
    public Customer searchCustomerByCustomerUsername(String customerUsername) throws BusinessException;
}
