/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class Seller extends Person {

	// Implementation of Bridge Design Pattern.
	public Seller(ProductMenu menu) {
		super(menu);
	}
	// Implementation of Bridge Design Pattern.
	public void showMenu() {
		productMenu.showMenu("Seller");
	}
	// Implementation of Bridge Design Pattern.
	public void makeProductList() {
		productMenu.makeProductList();
	}
	
	@Override
	public ProductMenu createProductMenu() {
		// TODO Auto-generated method stub
		return null;
	}
}
