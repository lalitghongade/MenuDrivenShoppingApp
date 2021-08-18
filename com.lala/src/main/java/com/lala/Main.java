package com.lala;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	
	//created log instance for logging
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//log4j error Quick solution
		String log4jConfPath = "/home/lala/Documents/revature/MenuDrivenShoppingApp/com.lala/src/main/resources/log4j2.Properties";
		PropertyConfigurator.configure(log4jConfPath);
		//log.info("logger succefully configured");
		
		//User Story1 : user can login
		Menu menu=new Menu();
		
		menu.starMenu();
		
		

	}

}
