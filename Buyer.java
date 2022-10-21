/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class Buyer extends Person{
	
	
	// Implementation of Bridge Design Pattern.
	public Buyer(ProductMenu menu) {
		super(menu);
	}
	
	// Implementation of Bridge Design Pattern.
	public void setPerson() {
		productMenu.showMenu("Buyer");
	}
	
	// Implementation of Bridge Design Pattern.
	public void makeProductList() {
		productMenu.makeProductList();
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		productMenu.showMenu("Buyer");
		
	}

	@Override
	public ProductMenu createProductMenu() {
		// TODO Auto-generated method stub
		return null;
	}



}
