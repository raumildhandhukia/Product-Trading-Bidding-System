import java.util.ArrayList;

public class OfferingIterator implements ListIterator{
	
	public ArrayList<Offering> Offerings;
	int index;
	
	@Override
	public boolean hasNext() {
		
		if(index < Offerings.size()){
            return true;
         }
         return false;
	}

	@Override
	public Offering next() {
		if(this.hasNext()){
			int i = 1;
			index++;
			for(Offering o : Offerings)
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
		Offering o = Offerings.get(index);
		Offerings.remove(index);
		Offerings.add(0,o);
		return true;
	}

	@Override
	public boolean Remove() {
		if (index <= Offerings.size()) {
			Offerings.remove(index);
			return true;
		}
		return false;
		
		
	}

}
