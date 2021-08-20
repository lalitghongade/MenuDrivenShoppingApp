package presentation.product;
import exception.BusinessException;
import model.Customer;
import model.Product;
import service.ProductSearchService;
import service.serviceDao.ProductSearchServiceDAO;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.Scanner;

public class ProductCategoryMenu {
	
	 private static final Logger log = Logger.getLogger(ProductCategoryMenu.class);
	    Scanner scanner = new Scanner(System.in);
	    ProductSearchServiceDAO productSearchServiceDAO = new ProductSearchService();
	    ProductMenu productPage = new ProductMenu();

	    public void viewProductByCategory(int productCategoryChoice, Customer customer) {
	        if (customer.isCustomerLoginSession()) {
	            switch (productCategoryChoice) {
	                case 1:
	                    int fashionProductChoice = 0;
	                    log.info("+------------------------------+");
	                    log.info("|           Fashion            |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(1);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                        log.info("+------------------------------+");
	                        log.info("| Enter your choice...         |");
	                        fashionProductChoice = Integer.parseInt(scanner.nextLine());
	                        log.info("+------------------------------+");
	                        log.info("");
	                        productPage.productDetails(fashionProductChoice, productCategoryChoice, customer);
	                    } catch (BusinessException | NumberFormatException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 2:
	                    int mobileProductChoice = 0;
	                    log.info("+------------------------------+");
	                    log.info("|           Mobiles            |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO .searchProductByCategory(2);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 3:
	                    log.info("+------------------------------+");
	                    log.info("|         Electronics          |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(3);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 4:
	                    log.info("+------------------------------+");
	                    log.info("|             Home             |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(4);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 5:
	                    log.info("+------------------------------+");
	                    log.info("|         Appliances           |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(5);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 6:
	                    log.info("+------------------------------+");
	                    log.info("|           Beauty             |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(6);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 7:
	                    log.info("+------------------------------+");
	                    log.info("|         Toys & Baby          |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(6);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 8:
	                    log.info("+------------------------------+");
	                    log.info("|          Furniture           |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(6);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 9:
	                    log.info("+------------------------------+");
	                    log.info("|           Grocery            |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(6);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                case 10:
	                    log.info("+------------------------------+");
	                    log.info("|         Food & more          |");
	                    log.info("+------------------------------+");
	                    try {
	                        List<Product> productList = productSearchServiceDAO.searchProductByCategory(6);
	                        if (productList != null) {
	                            for (Product product: productList) {
	                                log.info("| "+product.getProductId()+". "+product.getProductName());
	                            }
	                        }
	                    } catch (BusinessException e) {
	                        log.warn(e.getMessage());
	                    }
	                    break;
	                default:
	                    log.warn("Invalid User Input : Please enter numbers between (1-10)...");
	            }
	        } else {
	            log.info("Please login to continue");
	            log.info("You will be redirected to your Login portal in 2 seconds...");
	        }
	    }
	}


