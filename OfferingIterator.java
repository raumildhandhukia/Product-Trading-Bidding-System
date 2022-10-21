/**
 * @author Raumil Dhandhukia, rdhandhu@asu.edu
 * @date 10-20-2022
 */
import java.util.ArrayList;

public class OfferingIterator implements ListIterator{
	/*
	 * Implementation of `Iterator` Design Pattern. This is 
	 * Iterator class which is implemented from ListIterator
	 * interface. Methods to iterate OfferingLists are
	 * defined in this class.
	 */
	
	OfferingList offeringList;
	Product selectedProduct;
	
	public OfferingIterator(OfferingList offeringList, Product product) {
		this.offeringList = offeringList;
		this.selectedProduct = product;
	}
	public ArrayList<Offering> Offerings;
	int index = 0;
	
	@Override
	public boolean hasNext() {
		
		if(index < offeringList.size()){
            return true;
         }
         return false;
	}

	@Override
	public Offering next() {
		if(this.hasNext()){
			int i = 1;
			index++;
			for(Offering o : offeringList)
			{	
				if (i == index && o.productName.equalsIgnoreCase(selectedProduct.productName)) {
					return o;
				}
			    
			}
           
         }
         return null;
	}

	@Override
	public boolean MoveToHead() {
		Offering o = offeringList.get(index);
		offeringList.remove(index);
		offeringList.add(0,o);
		return true;
	}

	@Override
	public boolean Remove() {
		if (index <= offeringList.size()) {
			offeringList.remove(index);
			return true;
		}
		return false;
		
		
	}

}
