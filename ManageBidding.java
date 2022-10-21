/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class ManageBidding {
	/*
	 * This class contains functionalities to Manage Biddings
	 * done by buyers. Implemented design patterns in this class
	 * are 1) Iterator 2) Facade. 
	 * */
	
	
	OfferingList offeringList = new OfferingList();
	float bid;
	boolean bidSuccess = false;
	
	public OfferingList makeOfferingList(String filename) {
		FileReader PI;
		try {
			PI = new FileReader(filename);
			Scanner PIReader = new Scanner(PI);
			int i = 0;
		      while (PIReader.hasNextLine()) {
		    	i++;
		        String tuple = PIReader.nextLine();
		        ArrayList<String> tupleList = new ArrayList<>(Arrays.asList(tuple.split(":")));
		        String productName = tupleList.get(0);
		        String price = tupleList.get(1);
		        String sellerName = tupleList.get(2);
		        offeringList.add(new Offering(sellerName,productName, price));

		      }
		      PIReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offeringList;
		
	}
	
	public void decideBidding(UserInfoItem uii) {
		System.out.println("Please Select The Bid Value.");
		Scanner sc = new Scanner(System.in);
		float price = sc.nextFloat();
		if (this.bid > price) {
			System.out.println("Trade cannot be completed as you are bidding lower than sellers expected value.");
			System.exit(0);
		} else {
			uii.productValue = price;
			this.bidSuccess = true;
		}
		
		
	}
	
	//Implementation of Iterator Design Pattern.
	public void discussBidding(UserInfoItem uii) {
		/*
		 * This is implementation of Iterator Design Pattern.
		 * Here, offeringList is ArrayList of Offerings.
		 * 
		 * Iterator Design Pattern is used to find the Offerings
		 * done by sellers which has product requested by the buyer. 
		 *
		 */
		offeringList = this.makeOfferingList("Offering.txt");
		OfferingIterator oi = new OfferingIterator(offeringList,uii.theSelectedProduct);
		OfferingList productOfferings = new OfferingList();
		float bid = -1;
				while(oi.hasNext()){
						Offering of = oi.next();
						if (of != null) {
						productOfferings.add(of);	
						Float price = new Float(of.price);
						if (bid == -1) {
							bid = price;
						} else {
							if (price < bid) {
								bid = price;
							}
						}}
				}
				if (productOfferings.isEmpty()) {
					System.out.println("No seller is offering the " + uii.theSelectedProduct.productName + " currently");
					System.exit(0);
				} else {
					System.out.println("Seller offerings are available for this product.");
					System.out.println("Bidding starts with value " + bid + ".");
					System.out.println("Bid higher than starting bidding value to complete this trade.");
					this.bid = bid;
				}
	}

	public void submitBidding(UserInfoItem uii) {
		FileCreator fc = new FileCreator("Bidding");
		String state = fc.createFile();
		if (state.equals("create") || state.equals("exists")) {
			WriteToFile wf = new WriteToFile();
			String line = uii.theSelectedProduct.productName + ":" +uii.productValue + ":" + uii.userName;
			wf.write(line, "Bidding.txt");
		}
		if (this.bidSuccess) {
			System.out.println("Trade will be completed for product " + uii.theSelectedProduct.productName + " for " + uii.productValue);
		}
	}
	
	public void addTrading(UserInfoItem uii) {
		FileCreator fc = new FileCreator("UserProduct");
		String state = fc.createFile();
		if (state.equals("create") || state.equals("exists")) {
			WriteToFile wf = new WriteToFile();
			String line = uii.userName + ":"+uii.theSelectedProduct.productName;
			wf.write(line, "UserProduct.txt");
		}
		
	}

}
