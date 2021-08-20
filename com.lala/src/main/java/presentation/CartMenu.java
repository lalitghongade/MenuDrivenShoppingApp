package presentation;


import model.Cart;
import model.Customer;
import model.Product;
import presentation.order.OrderMenu;
import service.CartSearchService;
import service.CartService;
import service.ProductSearchService;
import service.serviceDao.CartSearchServiceDAO;
import service.serviceDao.CartServiceDAO;
import service.serviceDao.ProductSearchServiceDAO;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import exception.BusinessException;

public class CartMenu {
	private static final Logger log = Logger.getLogger(CartMenu.class);
    CartServiceDAO cartServiceDAO = new CartService();
    CartSearchServiceDAO cartSearchServiceDAO = new CartSearchService();
    ProductSearchServiceDAO productSearchServiceDAO = new ProductSearchService();
    OrderMenu orderMenu = new OrderMenu();
    Scanner scanner = new Scanner(System.in);

    public void addProductToCard(int productQuantity, Customer customer, int productId) {
        int isSucessfull;
        try {
            Cart cart = new Cart();
            Product product;
            product = productSearchServiceDAO.searchProductByProductId(productId);
            cart.setProduct(product);
            cart.setCustomer(customer);
            cart.setCartProductQuantity(productQuantity);
            cart.setCartProductTotal(product.getProductPrice() * productQuantity);

            isSucessfull = cartServiceDAO.addProductToCart(cart);
            if (isSucessfull == 1) {
                log.info(product.getProductName()+" is added to your cart successfully!!!");
                Thread.sleep(1000);
            }
        } catch (BusinessException | InterruptedException e) {
            log.warn(e.getMessage());
        }
    }

    public void viewCart(Customer customer) {
        if (customer.isCustomerLoginSession()) {
            try {
                List<Cart> cartList = cartServiceDAO.viewCart(customer);
                if (cartList.size() != 0) {
                    Product product;
                    int cartChoice;
                    log.info("\n+------------------------------+");
                    log.info("|           My Cart            |");
                    log.info("+------------------------------+");
                    for (Cart cart : cartList) {
                        product = productSearchServiceDAO.searchProductByProductId(cart.getProduct().getProductId());
                        log.info("| " + cart.getCartId() + ". " + product.getProductName());
                    }
                    log.info("+------------------------------+");
                    log.info("| Choose product to Buy...     |");
                    cartChoice = Integer.parseInt(scanner.nextLine());
                    log.info("+------------------------------+");
                    productToBuy(customer, cartChoice);
                } else {
                    Thread.sleep(1000);
                    Thread.sleep(1000);
                    log.info("Your cart is empty!");
                    log.info("It's a good day to buy the items you saved for later!");
                    Thread.sleep(1000);
                }
            } catch (BusinessException | InterruptedException e) {
                log.warn(e.getMessage());
            }
        }
    }

    public void productToBuy(Customer customer, int cartId) {
        if (customer.isCustomerLoginSession()) {
            int productBuyChoice;
            try {
                Cart cart = cartSearchServiceDAO.searchCartByCartId(cartId);
                Product product = productSearchServiceDAO.searchProductByProductId(cart.getProduct().getProductId());
                log.info("+------------------------------+");
                log.info("|         Cart Details         |");
                log.info("+------------------------------+");
                log.info("| Product ID : " +product.getProductId());
                log.info("|                              ");
                log.info("| Name : " +product.getProductName());
                log.info("| Category : " +product.getProductCategory().getProductCategoryName());
                log.info("| Quantity: "+cart.getCartProductQuantity());
                log.info("| Total Price : ₹" +cart.getCartProductTotal());
                log.info("+------------------------------+");
                log.info("");
                log.info("+------------------------------+");
                log.info("| 1. Buy Now                   |");
                log.info("| 2. Go back to Cart List      |");
                log.info("+------------------------------+");
                log.info("| Enter your choice            |");
                productBuyChoice = Integer.parseInt(scanner.nextLine());
                log.info("+------------------------------+");
                log.info("");
                switch (productBuyChoice) {
                    case 1:
                        cartServiceDAO.removeProductFromCart(cartId);
                        int orderStatus = 1;
                        log.info("Order Successfully Placed");
                        log.info("Thank you for ordering.");
                        orderMenu.addOrder(product, customer, cart, orderStatus);
                        Thread.sleep(1500);
                        break;
                    case 2:
                        log.info("Please wait...Redirecting to your Cart");
                        Thread.sleep(1500);
                        break;
                    default:
                        log.warn("Invalid User Input : Please enter numbers between (1-2)...");
                }
            } catch (BusinessException | NumberFormatException | InterruptedException e) {
                log.warn(e.getMessage());
            }
        }
    }
}