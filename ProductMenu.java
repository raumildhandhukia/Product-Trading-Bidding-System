/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public interface ProductMenu {

	public abstract void showMenu(String ut);

	public abstract void showAddButton();

	/**
	 *  
	 */
	public abstract void showViewButton();

	/**
	 *  
	 */
	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();
	
	public abstract void makeProductList();
	
	public abstract String takeInputFromProductList();

}
