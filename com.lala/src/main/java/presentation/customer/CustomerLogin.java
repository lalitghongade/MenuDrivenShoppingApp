package presentation.customer;

import dao.CustomerDAO;
import dao.implementation.CustomerDAOImpl;
import exception.BusinessException;
import model.Customer;

import java.util.Scanner;

import org.apache.log4j.Logger;

import service.CustomerSearchService;
import service.CustomerService;
import service.serviceDao.CustomerSearchServiceDAO;
import service.serviceDao.CustomerServiceDAO;

public class CustomerLogin {
	private static final Logger log = Logger.getLogger(CustomerLogin.class);
    CustomerServiceDAO customerServiceDAO = new CustomerService();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerDashboard customerDashboard = new CustomerDashboard();
    CustomerSearchServiceDAO customerSearchServiceDAO = new CustomerSearchService();
    Scanner scanner = new Scanner(System.in);

    public void registerCustomer() {
        int isSucessfull = 0;
        do {
            Customer customer = new Customer();
            log.info("");
            log.info("+-------------------------------- +");
            log.info("|      Register New Customer      |");
            log.info("+---------------------------------+");
            log.info("| Hello..!!                       |");
            log.info("| Welcome                         |");
            log.info("| Use this form to register       |");
            log.info("|                                 |");
            log.info("| Enter Name :                    |");
            String customerName = scanner.nextLine();
            customer.setCustomerName(customerName);
            log.info("| Enter Username :                |");
            String customerUsername = scanner.nextLine();
            try {
                if (customerServiceDAO.isValidCustomerUsername(customerUsername) && !customerDAO.isUsernameAlreadyExist(customerUsername)) {
                    customer.setCustomerUsername(customerUsername);
                    log.info("| Enter Password :                |");
                    String customerPassword = scanner.nextLine();
                    log.info("|                                 |");
                    log.info("+---------------------------------+");
                    if (customerServiceDAO.isValidCustomerPassword(customerPassword)) {
                        customer.setCustomerPassword(customerPassword);
                        isSucessfull = customerServiceDAO.createCustomer(customer);
                        if (isSucessfull == 1) {
                            Thread.sleep(1500);
                            log.info("Congratulations!!!");
                            log.info("Your account has been created and verified.");
                            log.info("");
                            Thread.sleep(1000);
                            log.info("Thanks for joining us, " + customerName);
                            Thread.sleep(1000);
                            log.info("We're so pleased to have you here.");
                           
                            log.info("");
                        }
                    }
                } else {
                    log.info("|                                 |");
                    log.info("+---------------------------------+");
                    log.info("");
                    log.warn("Username already exists. Please try with another one");
                    Thread.sleep(1500);
                }
            } catch (BusinessException | InterruptedException e) {
                log.info("|                                 |");
                log.info("+---------------------------------+");
                log.warn(e.getMessage());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                log.info("");
            }
        } while (isSucessfull != 1);
    }

    public void customerLogin() {
        boolean isSucessfull = false;
        do {
            Customer customer;
            log.info("");
            log.info("+-------------------------------- +");
            log.info("|         Login Customer          |");
            log.info("+--------------------------------+");
            log.info("| Welcome To ShopingApp...     |");
            log.info("| Please enter your details..     |");
            log.info("|                                 |");
            log.info("| Enter Username :                |");
            String customerUsername = scanner.nextLine();
            try {
                if (customerDAO.isUsernameAlreadyExist(customerUsername)) {
                    log.info("| Enter Password :                |");
                    String customerPassword = scanner.nextLine();
                    if (customerDAO.isPasswordAlreadyExist(customerUsername, customerPassword)) {
                        log.info("|                                 |");
                        log.info("+---------------------------------+");
                        customer = customerSearchServiceDAO.searchCustomerByCustomerUsername(customerUsername);
                        customer.setCustomerLoginSession(true);
                        isSucessfull = true;
                        Thread.sleep(1000);
                        log.info("\nLogin Sucessfull!!!");
                        Thread.sleep(1000);
                        log.info("Please wait...Redirecting to your Dashboard");
                        Thread.sleep(1500);
                        customerDashboard.customerDashboard(customer);
                    } else {
                        log.info("|                                 |");
                        log.info("+---------------------------------+");
                        log.info("");
                        log.warn("The username or password you entered is incorrect.");
                        log.warn("Try again :)");
                        Thread.sleep(1000);
                    }
                } else {
                    log.info("|                                 |");
                    log.info("+---------------------------------+");
                    log.info("");
                    log.warn("That username doesn't exist.");
                    Thread.sleep(500);
                    log.warn("Enter a different username or get a new one.");
                    Thread.sleep(1000);
                }
            } catch (BusinessException | InterruptedException e) {
                log.info("|                                 |");
                log.info("+---------------------------------+");
                log.info("");
                log.warn(e.getMessage());
                log.info("");
            }
        } while (!isSucessfull);
    }
}