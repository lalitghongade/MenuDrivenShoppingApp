package service.serviceDao;

import exception.BusinessException;
import model.Order;

public interface OrderSearchServiceDAO {

	 public Order searchOrderByOrderId(int orderId) throws BusinessException;
	  public Order searchOrderByCustomerId(int customerId) throws BusinessException;
}
