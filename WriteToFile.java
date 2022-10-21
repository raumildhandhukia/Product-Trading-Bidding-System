/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.io.BufferedWriter;
import java.io.FileWriter; 
import java.io.IOException;  

public class WriteToFile {
	/*
	 * File Writer Class. It will handle storing
	 * data in .txt files.
	 * */
  public boolean write(String line, String fileName) {
    try {
      FileWriter fstream = new FileWriter(fileName, true);
      BufferedWriter out = new BufferedWriter(fstream);
      out.newLine();
      out.write(line);
      out.close();
      return true;
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	return false;
  }
}