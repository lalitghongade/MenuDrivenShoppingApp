package presentation.order;

import org.apache.log4j.Logger;

import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Order;
import model.Product;
import presentation.CartMenu;
import service.OrderService;
import service.serviceDao.OrderServiceDAO;

public class OrderMenu {
	 private static final Logger log = Logger.getLogger(CartMenu.class);
	    OrderServiceDAO orderServiceDAO = new OrderService();
	    public void addOrder(Product product, Customer customer, Cart cart, int orderStatus) {
	        int isSucessfull;
	        Order order = new Order();
	        try {
	            isSucessfull = orderServiceDAO.addProductToOrder(product, customer, cart, orderStatus);
	            if (isSucessfull == 1) {
	                log.info("Your order information appears below.");
	                log.info("+------------------------------+");
	                log.info("|         Order Details        |");
	                log.info("+------------------------------+");
	                log.info("| Order ID : " +order.getOrderId());
	                log.info("|                              ");
	                log.info("| Name : " +product.getProductName());
	                log.info("| Category : " +product.getProductCategory().getProductCategoryName());
	                log.info("| Quantity: "+cart.getCartProductQuantity());
	                log.info("| Total Price : ₹" +cart.getCartProductTotal());
	                log.info("+------------------------------+");
	                log.info("");
	                log.info("Happy Shopping!!!");
	            }
	        } catch (BusinessException e) {
	            log.warn(e.getMessage());
	        }
	    }
}
