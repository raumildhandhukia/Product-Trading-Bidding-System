/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.util.Scanner;

public class Product {
	
	public String productName;
	public int productCategory;
	
	public Product(String pname, String cname) {
		this.productName = pname;
		if (cname.equals("Meat")) {
			this.productCategory = 0;
		} else {
			this.productCategory = 1;
		}
		
	}
	
	public void setProductCategory() {
		boolean state = true;
		while (state){
			System.out.println("Select Product Category:-");
			System.out.println("1. Meat");
			System.out.println("2. Produce");
			System.out.println("3. Exit");
			Scanner sc = new Scanner(System.in);
			int productCategory = sc.nextInt();
			if (productCategory == 1) {
				this.productCategory = 0;
				state = false;
			} else if (productCategory == 2) {
				this.productCategory = 1;
				state = false;
			
			} else if (productCategory == 3) {
				state = false;
				System.exit(0);
			} else {
				System.out.println("Please select appropriate value...");
			}
		}
		
		
	}

}
