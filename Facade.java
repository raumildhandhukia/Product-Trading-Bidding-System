/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Facade{
	/*
	 * Class Facade: This class acts as an interface to
	 * handle different subsystems. Implementation of 
	 * Facade Design Pattern is done in this class.
	 */

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	
	public UserInfoItem uii;
	
	public ProductMenu productMenu;
	
	public String productString; 
	public Facade() {
		UserInfoItem uii = new UserInfoItem();
		this.uii = uii;
	}
	
	/*
	 Implementation of Facade design pattern. By separating functionalities,
	 we can get rid of unwanted dependency in one place. Here Login functionality
	 is implemented by calling Login subsystem's object.
	 */
	public boolean login() throws IOException{
		String loginStatus;
		Login loginToApp = new Login();
		uii = loginToApp.userLogin(uii);
		if (uii == null) {
			System.out.println("Incorrect Username/Password.");
			return false;
		}
		return true;
	}
	
	//Implementation of Facade Design pattern.
	public void decideBidding(ManageBidding manageBidding) {
		manageBidding.decideBidding(this.uii);
	}
	
	//Implementation of Facade Design pattern.
	public void discussBidding(ManageBidding manageBidding) {
		manageBidding.discussBidding(this.uii);
	}
	
	//Implementation of Facade Design pattern.
	public void submitBidding(ManageBidding manageBidding) {
		manageBidding.submitBidding(this.uii);
	}
	
	//Implementation of Facade Design pattern.
	public void markOffering(ManageOffering manageOffering) {
		manageOffering.markOffering(this.uii);
	}
	
	//Implementation of Facade Design pattern.
	public void submitOffering(ManageOffering manageOffering) {
		manageOffering.submitOffering(this.uii);
	}
	
	//Implementation of Facade Design pattern.
	public void addTrading(ManageBidding manageBidding) {
		manageBidding.addTrading(this.uii);

	}

	public void viewTrading() {
		TradingMenu TM = new TradingMenu();
		TM.displayTradingData(this.nProductCategory);
	}	
	

	public void productOperation() {
		theSelectedProduct = new Product("","");
		theSelectedProduct.setProductCategory();
		this.nProductCategory = theSelectedProduct.productCategory;
		
		/* This is implementation of `Factory` Design Pattern.
		 * Here, objects creation is abstracted. Object creation
		 * functionality is abstracted and decided by subclasses.
		 */
		ProductMenuFactory pmf = new ProductMenuFactory();
		PersonFactory pf = new PersonFactory();
		productMenu = pmf.getMenu(theSelectedProduct.productCategory);
		
		/* `Bridge` Design pattern is implemented while constructing
		 * Person Class object alongside `Factory` Design Pattern.
		 * Object of ProductMenu is passed for further implementation
		 * of `Bridge` Design Pattern. 
		 */
		thePerson = pf.getPerson(uii.userType,productMenu);
		thePerson.selectedProductCategory = theSelectedProduct.productCategory;
		thePerson.showMenu();
		this.takeInputShowMenu();
	}
	
	public void takeInputShowMenu() {
		boolean state = true;
		while (state) {
			Scanner sc= new Scanner(System.in);
			int lineNum = sc.nextInt();
			if (lineNum == 1) {
				state = false;
				thePerson.makeProductList();
				productString = productMenu.takeInputFromProductList();
				theSelectedProduct.productName = productString;
				uii.theSelectedProduct = theSelectedProduct;
				if (uii.userType == "Buyer") {
					
					//Implementation of Facade Design pattern.
						ManageBidding manageBidding = new ManageBidding();
						this.discussBidding(manageBidding);
						this.decideBidding(manageBidding);
						this.submitBidding(manageBidding);
						this.addTrading(manageBidding);
						
					} else {
						
					//Implementation of Facade Design pattern.
						ManageOffering manageOffering = new ManageOffering();
						this.markOffering(manageOffering);
						this.submitOffering(manageOffering);
					
				}
			} else if (lineNum == 2){
				this.viewTrading();
			} else {
				System.out.println("Please Enter The Correct Value...");
			}
		}
	}
	
	



}
