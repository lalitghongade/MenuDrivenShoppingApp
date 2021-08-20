package presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import presentation.customer.CustomerLogin;
import presentation.employee.EmployeeLogin;

public class Main {
	
	//created log instance for logging
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//log4j error Quick solution
		String log4jConfPath = "/home/lala/Documents/revature/MenuDrivenShoppingApp/com.lala/src/main/resources/log4j2.Properties";
		PropertyConfigurator.configure(log4jConfPath);
		//log.info("logger succefully configured");
		
		CustomerLogin customerLogin = new CustomerLogin();

        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                log.info("+---------------------------------------- +");
                log.info("|     Welcome To MenuDrivenShoppingApp    |");
                log.info("+-----------------------------------------+");
                Thread.sleep(1000);
                log.info("|          Come for what you love.        |");
                Thread.sleep(1000);
                log.info("|       Stay for what you discover.       |");
                Thread.sleep(1000);
                log.info("|                                         |");
                log.info("|     1. New Customer Registration        |");
                log.info("|     2. Customer Login                   |");
                log.info("|     3. Employee Login                   |");
                log.info("|     4. Exit                             |");
                log.info("+-----------------------------------------+");
                log.info("|     Choose your option :            |");
                try {
                    menuChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    log.warn("Invalid Input : Please enter numbers between (1-3)...");
                    continue;
                }
                log.info("+---------------------------------+");

                switch (menuChoice) {
                    case 1:
                        customerLogin.registerCustomer();
                        break;
                    case 2:
                        customerLogin.customerLogin();
                        break;
                    case 3:
                        	EmployeeLogin employeeLogin = new EmployeeLogin();
                        		employeeLogin.login();
                        break;
                    case 4:
                        log.info("Oh no! You're leaving");
                        log.info("Bye!!");
                        break;
                    default:
                        log.warn("Invalid Input : Please enter numbers between (1-3)...");
                }
            } while (menuChoice != 4);
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
        }

        scanner.close();
    }
		

	}


