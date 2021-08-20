package presentation.employee;

import java.util.Scanner;

import org.apache.log4j.Logger;

import exception.BusinessException;
import model.Customer;
import presentation.customer.CustomerLogin;

public class EmployeeLogin {
	private static final Logger log = Logger.getLogger(EmployeeLogin.class);
	Scanner scanner= new Scanner(System.in);
	
	public void login() {
		boolean isSucessfull = false;
		String username="lala";
		String password ="lala";
        do {
            Customer customer;
            log.info("");
            log.info("+-------------------------------- +");
            log.info("|         Login Employee          |");
            log.info("+--------------------------------_+");
            log.info("| Welcome To ShoppingApp...       |");
            log.info("| Please enter your details..     |");
            log.info("|                                 |");
            log.info("| Enter Username :                |");
            String EmployeeUsername = scanner.nextLine();
            try {
                if (EmployeeUsername==username) {
                    log.info("| Enter Password :                |");
                    String EmployeePassword = scanner.nextLine();
                    if (EmployeePassword == password) {
                        log.info("|                                 |");
                        log.info("+---------------------------------+");
                        
                        isSucessfull = true;
                        Thread.sleep(1000);
                        log.info("\nLogin Sucessfull!!!");
                        Thread.sleep(1000);
                        log.info("Please wait...Redirecting to your Dashboard");
                        Thread.sleep(1500);
                       // customerDashboard.customerDashboard(customer);
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
                    log.warn("That  username doesn't exist.");
                    Thread.sleep(500);
                    log.warn("Enter a different username or get a new one.");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log.info("|                                 |");
                log.info("+---------------------------------+");
                log.info("");
                log.warn(e.getMessage());
                log.info("");
            }
        } while (!isSucessfull);
    }
		
		
		
	}
	
	

