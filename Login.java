/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Login {
	/*
	 * Login Class for login functionalities. This class
	 * will handle login system. Based upon provided credentials,
	 * system will automatically identify the type of user.
	 * */

	public UserInfoItem userLogin(UserInfoItem uii) throws IOException {
		String userName;
		String password;
		String LoginStatus = "Not Found";
		Scanner sc= new Scanner(System.in);
		System.out.println("Please Enter Your UserName: ");
		String userNameInput= sc.nextLine();
		System.out.println("Please Enter Your Password: ");
		String passwordInput = sc.nextLine();
		FileReader BI = new FileReader("BuyerInfo.txt");
		FileReader SI = new FileReader("SellerInfo.txt");
		Scanner BIReader = new Scanner(BI);
	      while (BIReader.hasNextLine()) {
	        String credentials = BIReader.nextLine();
	        ArrayList<String> credList = new ArrayList<>(Arrays.asList(credentials.split(":")));

	        userName = credList.get(0);
	        password = credList.get(1);

	        if (userName.equals(userNameInput) && password.equals(passwordInput)) {
	        	LoginStatus = "BI Login";

	        	uii.userName = userName;
	        	uii.userType = "Buyer";

	        	BIReader.close();
	        	System.out.println("The Buyer has logged in...");
	        	return uii;
	        }
	      }
	      BIReader.close();
        Scanner SIReader = new Scanner(SI);
	        while (SIReader.hasNextLine()) {
		        String credentials = SIReader.nextLine();
		        ArrayList<String> credList = new ArrayList<>(Arrays.asList(credentials.split(":")));
		        userName = credList.get(0);
		        password = credList.get(1);
		        if (userName.equals(userNameInput) && password.equals(passwordInput)) {
		        	LoginStatus = "SI Login";
		        	uii.userName = userName;
		        	uii.userType = "Seller";
		        	SIReader.close();
		        	System.out.println("The Seller has logged in...");
		    		return uii;
		        }
	        }
	    SIReader.close();
		return null;
	}
	
	
}
