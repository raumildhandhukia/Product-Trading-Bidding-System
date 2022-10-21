/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeatProductMenu implements ProductMenu{
		
	
	ArrayList<Product> productList;
	String personType;
	
	@Override
	public void showMenu(String userType) {
		this.personType = userType;
		this.showAddButton();
		this.showViewButton();
		
	}
	
	public String takeInputFromProductList() {
		System.out.println("Select Meat Product by Typing Name of The Meat...");
		Scanner sc= new Scanner(System.in);
		String productName = sc.nextLine();
		//DO VALIDATIONS HERE.
		return productName;
		
	}
	
	public void makeProductList() {
		ClassProductList pl = new ClassProductList();
		productList = pl.makeProductList("ProductInfo.txt");
		int i =0;
		for(Product pro : productList)
		{	if (pro.productCategory == 0){
			i++;
            System.out.println(i+". "+pro.productName);
			}
        }
	}

	@Override
	public void showAddButton() {
		if (this.personType == "Buyer") {
		System.out.println("1. Add and Bid for Meat Products.");
		} else {
			System.out.println("1. Make Offering for Meat Products.");
		}
	}

	@Override
	public void showViewButton() {
		System.out.println("2. View Tradings for Meat Products.");
		
	}

	@Override
	public void showRadioButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showLabels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showComboxes() {
		// TODO Auto-generated method stub
		
	}

}
