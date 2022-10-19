import java.io.IOException;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public boolean login() throws IOException{
		String loginStatus;
		Login loginToApp = new Login();
		loginStatus = loginToApp.Login();
		if (loginStatus == "Not Found") {
			System.out.println("Credentials incorrect.");
			return false;
		}
		else if (loginStatus == "BI Login") {
			System.out.println("Buyer has logged in.");
		}
		else if (loginStatus == "SI Login") {
			System.out.println("seller has logged in.");
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

	public void productOperation() {

	}

}
