/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.util.Scanner;

public class ManageOffering {
	/*
	 * Manages Seller offering functionalities. Part of
	 * implementation of `Facade` Design Pattern.
	 * */

	
	public void markOffering(UserInfoItem uii) {
		System.out.println("Please Select The Offering Value.");
		Scanner sc = new Scanner(System.in);
		float lineNum = sc.nextFloat();
		uii.productValue = lineNum;
	}
	
	public void submitOffering(UserInfoItem uii) {
		FileCreator fc = new FileCreator("Offering");
		String state = fc.createFile();
		if (state.equals("create") || state.equals("exists")) {
			WriteToFile wf = new WriteToFile();
			String line = uii.theSelectedProduct.productName + ":" +uii.productValue + ":" + uii.userName;
			wf.write(line, "Offering.txt");
		}
		System.out.println("Offering has been created for "+uii.theSelectedProduct.productName +" for "+uii.productValue);
		this.addOffering(uii);
	}
	
	public void addOffering(UserInfoItem uii) {
		FileCreator fc = new FileCreator("UserProduct");
		String state = fc.createFile();
		if (state.equals("create") || state.equals("exists")) {
			WriteToFile wf = new WriteToFile();
			String line = uii.userName + ":"+uii.theSelectedProduct.productName;
			wf.write(line, "UserProduct.txt");
		}
		
	}

}
