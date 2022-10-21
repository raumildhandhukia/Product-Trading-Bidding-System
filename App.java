/**
 * Product  Trading  and  Bidding System (PTBS)
 * Implemented Design Patterns.
 * 
 * 1. Facade
 * 2. Factory
 * 3. Bridge
 * 4. Iterator
 * 5. Visitor
 * 
 * Buyer biddings are stored in Bidding.txt file.
 * Seller offerings are stored in Offering.txt file.
 * 
 * IN AN INTIAL STAGE, WHEN NO BIDDINGS AND OFFERINGS ARE
 * MADE, Bidding.txt and Offering.txt FILES WILL NOT
 * EXIST. THEY WILL BE CREATED AUTOMATICALLY WHEN FIRST
 * BIDDNG AND OFFERING ARE DONE.
 * 
 * Trades will be done automatically and successful trade
 * requires enough offerings which buyers can bid on.
 * 
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */

import java.io.IOException;


public class App{
	
	
	public App() throws IOException{
		boolean loginStatus;
		/*
		 Implementation of Facade design pattern. Facade works as an interface
		 to handle internal code functionality and also reduces complexity.
		 */
		Facade facade = new Facade();
		loginStatus = facade.login();
		if (loginStatus) {
			facade.productOperation();
		}
	}
	

	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to Tempe's Product Trading & Bidding System.");
		new App();
	}

}
