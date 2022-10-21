/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public abstract class Person {
	protected ProductMenu theProductMenu;
	int selectedProductCategory;
	String Username;
	protected ProductMenu productMenu;
	
	/*
	 * This is Implementation of `Bridge` Design Pattern. 
	 * Inside of abstract class Person, implementation is
	 * hidden from the client program. This implementation
	 * is bridge between types of Persons and types of ProductMenus.
	 *  
	 */
	public Person(ProductMenu menu) {
		this.productMenu = menu;
	}
	
	public abstract void showMenu();
	
	public void showAddButton() {
		System.out.println("1. Add Products");
	};
	public void showViewButton() {
		System.out.println("1. View Tradings.");
	};
	public void showRadioButton() {
		
	};
	public void showLabels() {
		
	};
	
	public abstract void makeProductList();
	
	public abstract ProductMenu createProductMenu();
	

}
