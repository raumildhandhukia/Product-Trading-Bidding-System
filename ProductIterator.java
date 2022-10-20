import java.util.ArrayList;

public class ProductIterator implements ListIterator{
	
	public ArrayList<Product> Products;
	int index;
	
	@Override
	public boolean hasNext() {
		
		if(index < Products.size()){
            return true;
         }
         return false;
	}

	@Override
	public Product next() {
		if(this.hasNext()){
			int i = 1;
			index++;
			for(Product o : Products)
			{	
				if (i == index) {
					return o;
				}
			    
			}
           
         }
         return null;
	}

	@Override
	public boolean MoveToHead() {
		Product o = Products.get(index);
		Products.remove(index);
		Products.add(0,o);
		return true;
	}

	@Override
	public boolean Remove() {
		if (index <= Products.size()) {
			Products.remove(index);
			return true;
		}
		return false;
		
		
	}

}
