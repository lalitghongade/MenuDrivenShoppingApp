package service;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Order;
import model.Product;
import service.serviceDao.OrderServiceDAO;
import java.util.List;

public class OrderService implements OrderServiceDAO{
	
	
	 OrderDAO orderDAO = new OrderDAOImpl();
	@Override
	public int addProductToOrder(Product product, Customer customer, Cart cart, int orderStatus)
			throws BusinessException {
		// TODO Auto-generated method stub
		 int isSucessfull;
	        isSucessfull = orderDAO.addProductToOrder(product, customer, cart, orderStatus);
	        return isSucessfull;
	}
	
	 @Override
	    public List<Order> viewOrder(Customer customer) throws BusinessException {
	        List<Order> orderList;
	        orderList = orderDAO.viewOrder(customer);
	        return orderList;
	    }

}
