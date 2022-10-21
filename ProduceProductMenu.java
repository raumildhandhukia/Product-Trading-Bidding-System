/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProduceProductMenu implements ProductMenu{
	
String personType;
ArrayList<Product> productList;
	
	@Override
	public void showMenu(String userType) {
		this.personType = userType;
		this.showAddButton();
		this.showViewButton();
		
	}
	
	public String takeInputFromProductList() {
		System.out.println("Select Produce Product by Typing Name of The Produce...");
		Scanner sc= new Scanner(System.in);
		String productName = sc.nextLine();
		return productName;
		
	}
	
	public void makeProductList() {
		ClassProductList pl = new ClassProductList();
		productList = pl.makeProductList("ProductInfo.txt");
		int i = 0;
		for(Product pro : productList)
		{	if (pro.productCategory == 1){
            System.out.println(i + "1. " + pro.productName);
			}
        }

		
	}

	@Override
	public void showAddButton() {
		if (this.personType == "Buyer") {
		System.out.println("1. Add and Bid for Produce Products.");
		} else {
			System.out.println("1. Make offering for Produce Products.");
		}
	}

	@Override
	public void showViewButton() {
		System.out.println("2. View Tradings for Produce Products.");
		
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
