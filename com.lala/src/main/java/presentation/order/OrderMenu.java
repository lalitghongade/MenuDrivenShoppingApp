package presentation.order;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import exception.BusinessException;
import model.Cart;
import model.Customer;
import model.Order;
import model.Product;
import presentation.CartMenu;
import service.OrderSearchService;
import service.OrderService;
import service.ProductSearchService;
import service.ProductService;
import service.serviceDao.OrderSearchServiceDAO;
import service.serviceDao.OrderServiceDAO;
import service.serviceDao.ProductSearchServiceDAO;
import service.serviceDao.ProductServiceDAO;

public class OrderMenu {
	 private static final Logger log = Logger.getLogger(CartMenu.class);
	    OrderServiceDAO orderServiceDAO = new OrderService();
	    ProductServiceDAO productServiceDAO=new ProductService();
	    ProductSearchServiceDAO productSearchServiceDAO = new ProductSearchService();
	    OrderSearchServiceDAO orderSearchServiceDAO = new OrderSearchService();
	    Scanner scanner = new Scanner(System.in);
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
	    public void viewOrder(Customer customer) {
	        if (customer.isCustomerLoginSession()) {
	            try {
	                List<Order> orderList = orderServiceDAO.viewOrder(customer);
	                if (orderList.size() != 0) {
	                    Product product;
	                    int orderChoice;
	                  log.info("\n+--------------------------------+");
	                    log.info("|           My Orders            |");
	                    log.info("+--------------------------------+");
	                    for (Order order: orderList) {
	                        product = productSearchServiceDAO.searchProductByProductId(order.getProduct().getProductId());
	                        log.info("| "+order.getOrderId()+". "+product.getProductName());
	                    }
	                    log.info("+------------------------------+");
	                    log.info("| Choose product to get status |");
	                    orderChoice = Integer.parseInt(scanner.nextLine());
	                    log.info("+------------------------------+");
	                    log.info("");
	                    orderedProductDetail(customer, orderChoice);
	                } else {
	                    Thread.sleep(500);
	                    log.info("You have no order!");
	                    log.info("It's a good day to buy the items you saved for later!");
	                    Thread.sleep(1000);
	                }
	            } catch (BusinessException | InterruptedException e) {
	                log.warn(e.getMessage());
	            }
	        }
	    }
	    
	    public void orderedProductDetail(Customer customer, int productId) {
	        if (customer.isCustomerLoginSession()) {
	            int orderedProductDetailChoice;
	            try {
	                Order order = orderSearchServiceDAO.searchOrderByCustomerId(customer.getCustomerId());
	                Product product = productSearchServiceDAO.searchProductByProductId(productId);
	                log.info("+------------------------------+");
	                log.info("|         Order Details        |");
	                log.info("+------------------------------+");
	                log.info("| Product ID : " + product.getProductId());
	                log.info("|                              ");
	                log.info("| Name : " + product.getProductName());
	                log.info("| Category : " + product.getProductCategory().getProductCategoryName());
	                log.info("| Quantity: " + order.getOrderQuantity());
	                log.info("| Total Price : ₹" + order.getOrderTotal());
	                log.info("| Order Status :" + order.getOrderStatus().getOrderStatusType());
	                log.info("+------------------------------+");
	                log.info("");
	                log.info("+------------------------------+");
	                log.info("| 1. Received? Change status   |");
	                log.info("| 2. Go back to Dashboard      |");
	                log.info("+------------------------------+");
	                log.info("| Enter your choice            |");
	                orderedProductDetailChoice = Integer.parseInt(scanner.nextLine());
	                log.info("+------------------------------+");
	                log.info("");
	                switch (orderedProductDetailChoice) {
	                    case 1:
	                        //TODO change the order status.
	                        if (order.getOrderStatus().getOrderStatusId() == 4) {
	                            //TODO update status
	                            log.info("Order Delivered Successfully");
	                            log.info("Thank you for Shopping!!.");
	                        } else {
	                            log.info("Your order is still under" +order.getOrderStatus().getOrderStatusType() +" status");
	                            log.info("Wait until it's Out for Delivery...");
	                        }
	                        Thread.sleep(1500);
	                        break;
	                    case 2:
	                        log.info("Please wait...Redirecting to your Dashboard.");
	                        Thread.sleep(1500);
	                        break;
	                    default:
	                        log.warn("Invalid User Input : Please enter numbers between (1-2)...");
	                }
	            } catch (BusinessException | InterruptedException e) {
	                log.warn(e.getMessage());
	            }
	        }
	    }
	    
	    
	    
}
