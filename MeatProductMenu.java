import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeatProductMenu implements ProductMenu{

	@Override
	public void showMenu() {
		this.showAddButton();
		this.showViewButton();
		
	}

	@Override
	public void showAddButton() {
		System.out.println("1. Add and Bid Products.");
		
	}

	@Override
	public void showViewButton() {
		System.out.println("2. View Tradings.");
		
	}
	
	public void makeMeatList() throws FileNotFoundException {
		FileReader PI = new FileReader("ProductInfo.txt");
		Scanner PIReader = new Scanner(PI);
		System.out.println("Select product name.");
		Scanner sc= new Scanner(System.in);
		String productNumber = sc.nextLine();
		int i = 0;
	      while (PIReader.hasNextLine()) {
	    	i++;
	        String tuple = PIReader.nextLine();
	        ArrayList<String> tupleList = new ArrayList<>(Arrays.asList(tuple.split(":")));
	        String type = tupleList.get(0);
	        String productName = tupleList.get(1);

	        if (type == "meat") {
	        	System.out.println(i + ". " + productName);
	        }
	      }
	      PIReader.close();
	}

	@Override
	public void showRadioButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showLabels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showComboxes() {
		// TODO Auto-generated method stub
		
	}

}
