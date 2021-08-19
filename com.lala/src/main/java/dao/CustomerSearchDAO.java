package dao;
import java.util.List;

import exception.BusinessException;
import model.Customer;


public interface CustomerSearchDAO {
	
	public Customer searchCustomerByUsername(String customerUsername)throws BusinessException;
	
}