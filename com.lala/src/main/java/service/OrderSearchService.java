package service;

import dao.OrderSearchDAO;
import dao.implementation.OrderSearchDAOImpl;
import exception.BusinessException;
import model.Order;
import service.serviceDao.OrderSearchServiceDAO;

public class OrderSearchService implements OrderSearchServiceDAO {
    OrderSearchDAO orderSearchDAO = new OrderSearchDAOImpl();

    @Override
    public Order searchOrderByOrderId(int orderId) throws BusinessException {
        Order order = new Order();
        //TODO Under Construction
        return order;
    }

    @Override
    public Order searchOrderByCustomerId(int customerId) throws BusinessException {
        Order order;
        order = orderSearchDAO.searchOrderByCustomerId(customerId);
        return order;
   
    }
}