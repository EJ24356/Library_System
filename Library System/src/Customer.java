import java.util.ArrayList;
import java.util.List;

public class Customer {
	private List <Genres> bookItems = new ArrayList<Genres>();
	private List <ShoeTypes> shoeItems = new ArrayList<ShoeTypes>();
    
    public void addBook(Genres g) {
    	bookItems.add(g);
    }
    public void addShoe(ShoeTypes s) {
    	shoeItems.add(s);
    }
    public void removeBook(Genres g) {
    	bookItems.remove(g);
    }
    public void removeShoe(ShoeTypes s) {
    	shoeItems.remove(s);
    }
    
    public void printItems() {
    	if (!bookItems.isEmpty()) {
    		for (int i=0;i<getBookItems().size();++i)
    			getBookItems().get(i).print();
    	}
    	if (!shoeItems.isEmpty()) {
    		for (int i=0;i<getShoeItems().size();++i)
    			getShoeItems().get(i).print();
    	}
    	else if (bookItems.isEmpty()&&shoeItems.isEmpty())
    		System.err.println("No items in your cart!");
    	System.out.println("\n");
    }
    
    public List<Genres> getBookItems(){
		return bookItems;	
    }
    
    public List<ShoeTypes> getShoeItems(){
    	return shoeItems;
    }

}//Customer
