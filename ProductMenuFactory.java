/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
public class ProductMenuFactory {
/*
 * This class has implementation of `Factory`
 * design pattern. getMenu function decides
 * which class of object to create.
 */
	
   public ProductMenu getMenu(int menuType){
      if(menuType == 0){
         return new MeatProductMenu();
         
      } else if(menuType == 1){
         return new ProduceProductMenu();
     
      }
      
      return null;
   }
}