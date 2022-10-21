/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class Seller extends Person {

	
	public Seller(ProductMenu menu) {
		super(menu);
	}
	
	public void showMenu() {
		productMenu.showMenu("Seller");
	}
	
	public void makeProductList() {
		productMenu.makeProductList();
	}
	
	@Override
	public ProductMenu createProductMenu() {
		// TODO Auto-generated method stub
		return null;
	}
}
