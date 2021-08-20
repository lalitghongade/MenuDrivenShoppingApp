package presentation.product;
import exception.BusinessException;
import model.Customer;
import model.Product;
import presentation.CartMenu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import service.ProductSearchService;
import service.serviceDao.ProductSearchServiceDAO;

public class ProductMenu {
	private static final Logger log = Logger.getLogger(ProductCategoryMenu.class);
    Scanner scanner = new Scanner(System.in);
    ProductSearchServiceDAO productSearchServiceDAO = new ProductSearchService();
    CartMenu cartMenu = new CartMenu();

    public void productDetails(int productChoice, int productCategoryChoice, Customer customer) {
        Product product;
        int productCartChoice;
        if (customer.isCustomerLoginSession()) {
            try {
                product = productSearchServiceDAO.searchProductByProductAndCategory(productChoice, productCategoryChoice);
                log.info("+------------------------------+");
                log.info("|       Product Details        |");
                log.info("+------------------------------+");
                log.info("| Product ID : " +product.getProductId());
                log.info("|                              ");
                log.info("| Name : " +product.getProductName());
                log.info("| Category : " +product.getProductCategory().getProductCategoryName());
                log.info("| Price : ₹" +product.getProductPrice());
                log.info("| Description :                ");
                log.info("+------------------------------+");
                log.info("");
                log.info("+------------------------------+");
                log.info("| 1. Add To Cart               |");
                log.info("| 2. Go back to Product List   |");
                log.info("+------------------------------+");
                log.info("| Enter your choice            |");
                productCartChoice = Integer.parseInt(scanner.nextLine());
                log.info("+------------------------------+");
                log.info("");
                switch (productCartChoice) {
                    case 1:
                        int productQuantity;
                        log.info("+------------------------------+");
                        log.info("| Add Product Quantity         |");
                        log.info("+------------------------------+");
                        log.info("| Enter your choice            |");
                        productQuantity = Integer.parseInt(scanner.nextLine());
                        log.info("+------------------------------+");
                        log.info("");
                        cartMenu.addProductToCard(productQuantity, customer, product.getProductId());
                        log.info("Please wait...Redirecting to your Cart");
                        Thread.sleep(1500);
                        break;
                    case 2:
                        log.info("Please wait...Redirecting to your Product List");
                        Thread.sleep(1500);
                        break;
                    default:
                        log.warn("Invalid User Input : Please enter numbers between (1-2)...");
                }
            } catch (BusinessException | NumberFormatException | InterruptedException e) {
                log.warn(e.getMessage());
            }
        } else {
            log.info("Please login to continue");
            log.info("You will be redirected to your Login portal in 2 seconds...");
        }
    }
}
