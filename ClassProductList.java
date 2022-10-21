/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClassProductList extends ArrayList<Product>{

	/**
	 * 
	 */
	ArrayList<Product> productList = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	
	public void accept(NodeVisitor visitor) {
		
	}
	
	public ArrayList<Product> makeProductList(String filename) {
		FileReader PI;
		try {
			PI = new FileReader(filename);
			Scanner PIReader = new Scanner(PI);
			int i = 0;
		      while (PIReader.hasNextLine()) {
		    	i++;
		        String tuple = PIReader.nextLine();
		        ArrayList<String> tupleList = new ArrayList<>(Arrays.asList(tuple.split(":")));
		        String type = tupleList.get(0);
		        String productName = tupleList.get(1);
		        productList.add(new Product(productName,type));

		      }
		      PIReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}

}
