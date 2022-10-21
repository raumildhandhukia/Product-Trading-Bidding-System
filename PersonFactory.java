/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class PersonFactory {
/*
 * This class has implementation of `Factory` method 
 * as well as `Bridge` method. getPerson function decides
 * which class of object to create. At the same time 
 * ProductMenu object is passed to implement `Bridge`
 * design pattern. 
 * 
 */
	
   public Person getPerson(String userType, ProductMenu productMenu){
	  /*
	   * Here, Person Object is created with instance of ProductMenu.
	   * Implementation of ProductMenu class is hidden from Client program.
	   * This is Implementation of `Bridge` alongside `Factory` method. 
	   */
      if(userType == null){
         return null;
      }		
      if(userType.equalsIgnoreCase("Buyer")){
         return new Buyer(productMenu);
         
      } else if(userType.equalsIgnoreCase("Seller")){
         return new Seller(productMenu);
     
      }
      
      return null;
   }
}