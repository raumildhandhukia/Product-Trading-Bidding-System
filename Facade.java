import java.io.IOException;
import java.util.Scanner;

public class Facade{

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	
	public UserInfoItem uii;
	
	public Facade() {
		UserInfoItem uii = new UserInfoItem();
		this.uii = uii;
	}
	

	public boolean login() throws IOException{
		String loginStatus;
		Login loginToApp = new Login();
		uii = loginToApp.userLogin(uii);
		if (uii == null) {
			System.out.println("Credentials incorrect.");
			return false;
		}
		else if (uii.userType == "Buyer") {
			this.UserType = 0;
			System.out.println("Buyer has logged in.");
		}
		else if (uii.userType == "Seller") {
			this.UserType = 1;
			System.out.println("Seller has logged in.");
		}
		return true;
	}
	

	public void addTrading() {

	}

	public void vieTrading() {

	}

	public void decideBinding() {

	}

	public void discussBinding() {

	}

	public void submitbinding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}
	
	public void productCategory() {
		boolean state = true;
		while (state){
			System.out.println("Select Product Category: 1. Meat 2. Produce 3.Exit");
			Scanner sc = new Scanner(System.in);
			int productCategory = sc.nextInt();
			if (productCategory == 1) {
				this.nProductCategory = 0;
				state = false;
			} else if (productCategory == 2) {
				this.nProductCategory = 1;
				state = false;
			
			} else if (productCategory == 3) {
				state = false;
			} else {
				System.out.println("Please select appropriate value.");
			}
		}
		
		
	}

	public void productOperation() {
		this.productCategory();
		if (uii.userType == "Buyer") {
			thePerson = new Buyer();
		} else {
			thePerson = new Seller();
		}
		thePerson.showMenu();
	}



}
