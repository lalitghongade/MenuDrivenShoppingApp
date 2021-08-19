package presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Menu {
	private static final Logger log = Logger.getLogger(Menu.class);
	
	public Menu() {
		
	}
	
	public void starMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		do {
		log.info("-----------------------------");
		log.info("Welecome to the Shopping App");
		log.info("-----------------------------");
		log.info("1. Login As Customer");
		log.info("2. Login As Employee");
		log.info("3. Register As Customer");
		log.info("4. Exit");
		log.info("-----------------------------");
		log.info("-----------------------------");
		log.info("Enter Your Choice");
		try {
			choice=Integer.parseInt(scanner.nextLine());
		}
		catch(Exception e){
			log.info(e);
		}
		
		switch(choice)
		{
			case 1:
					//Login as customer case
					log.info("still in development case :"+1);
				
					break;
			case 2:
					//Login as employee case
					log.info("still in development case :"+2);
					break;
			case 3:
					//register as customer case
					log.info("still in development case :"+3);
					break;
			case 4:
					log.info("Thank You for your valuable Time ");
					
                    log.info("See you soon....Bye Bye!!!");
                    break;
			default:
				//default case
				log.info("invalid choice");
				break;
	}//switch block
				
		}while(choice!=4);//do-while block
		
	}//startMenuMethod
	
	
	
	
}//class menu