import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class TradingMenu {
	ArrayList<Trading> tradings = new ArrayList<Trading>();
	public void displayTradingData(int categ) {
		ClassProductList pl = new ClassProductList();
		ArrayList<Product> products = pl.makeProductList("ProductInfo.txt");
		FileReader PI;
		try {
			PI = new FileReader("UserProduct.txt");
			Scanner PIReader = new Scanner(PI);
			int i = 0;
		      while (PIReader.hasNextLine()) {
		    	i++;
		        String tuple = PIReader.nextLine();
		        ArrayList<String> tupleList = new ArrayList<>(Arrays.asList(tuple.split(":")));
		        String user = tupleList.get(0);
		        String productName = tupleList.get(1);
		        for(Product pro: products) {
		        	if (pro.productName.equals(productName) && pro.productCategory == categ) {
		        		tradings.add(new Trading(user,productName));
		        	}
		        }
		        

		      }
		      PIReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Trading t: tradings) {
			System.out.println(t.userName + ":" + t.productName);
		}
		
	}
}
