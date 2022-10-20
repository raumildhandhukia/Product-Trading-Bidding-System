
public class Seller extends Person {

	@Override
	public void showComboxes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMenu() {
		theProductMenu = createProductMenu();
		
	}

	@Override
	public ProductMenu createProductMenu() {
		ProductMenu ProductMenu;
		if (this.selectedProductCategory == 0) {
			ProductMenu = new MeatProductMenu();
		} else {
			ProductMenu = new ProduceProductMenu();
		}
		ProductMenu.showMenu();
		
		return ProductMenu;
	}

}
