
public abstract class Person implements ProductMenu {
	protected ProductMenu theProductMenu;
	int selectedProductCategory;
	String Username;
	
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
	
	public abstract ProductMenu createProductMenu();
	

}
