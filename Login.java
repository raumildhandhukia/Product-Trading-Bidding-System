import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Login {

	public String Login() throws IOException {
		String userName;
		String password;
		String LoginStatus = "Not Found";
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to Trading system.");
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
//	        System.out.println(credList);
	        userName = credList.get(0);
	        password = credList.get(1);
//	        System.out.println(userName);
//	        System.out.println(password);
	        if (userName.equals(userNameInput) && password.equals(passwordInput)) {
	        	LoginStatus = "BI Login";
	        	BIReader.close();
	        	return LoginStatus;
	        }
	      }
	      BIReader.close();
        Scanner SIReader = new Scanner(SI);
	        while (SIReader.hasNextLine()) {
		        String credentials = SIReader.nextLine();
		        ArrayList<String> credList = new ArrayList<>(Arrays.asList(credentials.split(":")));
//		        System.out.println(credList);
		        userName = credList.get(0);
		        password = credList.get(1);
		        if (userName.equals(userNameInput) && password.equals(passwordInput)) {
		        	LoginStatus = "SI Login";
		        	SIReader.close();
		    		return LoginStatus;
		        }
	        }
	    SIReader.close();
		return LoginStatus;
	}
	
	
}
