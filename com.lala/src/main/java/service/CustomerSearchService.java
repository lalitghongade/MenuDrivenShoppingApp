package service;

import dao.CustomerSearchDAO;
import dao.implementation.CustomerSearchDAOImpl;
import exception.BusinessException;
import model.Customer;
import service.serviceDao.*;

public class CustomerSearchService implements CustomerServiceDAO {
    CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();

    @Override
    public Customer searchCustomerByCustomerUsername(String customerUsername) throws BusinessException {
        Customer customer;
        customer = customerSearchDAO.searchCustomerByCustomerUsername(customerUsername);

        return customer;
    }
}
