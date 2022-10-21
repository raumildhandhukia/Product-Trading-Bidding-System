/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.File; 
import java.io.IOException;  

public class FileCreator {
	/*
	 * File Creator class. It will create 
	 * .txt files if they do not exist.
	 * */
	
 public String fileName;
 
 public FileCreator(String fileName) {
	 this.fileName = fileName;
 }
	
  public String createFile() {
    try {
      File myObj = new File(this.fileName + ".txt");
      if (myObj.createNewFile()) {
    	  return "create";
      } else {
        
        return "exists";
      }
    } catch (IOException e) {
      System.out.println("An error occurred while accessing file.");
      e.printStackTrace();
    }
	return "error";
  }
}
