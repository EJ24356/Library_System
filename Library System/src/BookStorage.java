import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BookStorage implements Shelf {
    private HashMap<Integer,Genres> books = new HashMap<Integer,Genres>();
    private ArrayList<ShoeTypes> shoes = new ArrayList<ShoeTypes>();

    protected int numOfBooks;
    protected final String[] genres = {"Action","Drama","Horror","Science Fiction","Satire","Romance","Anthology"};
    Random r = new Random(genres.length);
    private int section;
    private static int serial=0;
    
    BookStorage(File file) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(file)); 

    	String st; 
    	while ((st = br.readLine()) != null) { 
    		createBooks(st); 
    	}
    	numOfBooks = books.size();
    }
    
	@Override
	public HashMap<Integer, Genres> getBooks() {
	 HashMap<Integer,Genres> bookCopies= new HashMap<Integer,Genres>();
	 int i =0;
	 
	 //copy book items
	 
	 for(Genres g:books.values()) {
		 bookCopies.put(i, books.get(i));
		 ++i;
	 }//for

	 return bookCopies;
	 
	}//getBooks
	
	public ArrayList<ShoeTypes> getShoes(){
		return shoes;
	}
	
	
	protected int getNumOfBooks() {
		return numOfBooks;
	}
    
    @Override
    public void createBooks(String st){
    		section=r.nextInt(genres.length);
    		Genres g = new Genres(st);
    		g.setGenre(genres[section]);
    		books.put(serial,g);
    		serial++;
    }//createBooks
    

	@Override
	public void checkinBook(int i) {
		if(books.containsKey(i)&&books.get(i).getCheckOut()==true) {
			books.get(i).setCheckOut(false);
			numOfBooks++;
		}//if
		else
			System.err.println("Book is already in stock.\n");		
	}//checkinBook

	@Override
	public void checkoutBook(int i) {
	    if(books.containsKey(i)&&books.get(i).getCheckOut()==false) {
			books.get(i).setCheckOut(true);
			numOfBooks--;
		}
		else
			System.err.println("Book is unavaiable.");		
	}//checkoutBook
	
	
	@Override
	public void print() {
		System.out.println("Book Selection:\n");
      
		 for(Integer i:books.keySet()) {			
			 if(getBooks().get(i).getCheckOut()==false) {
				   getBooks().get(i).setID(i);
				   getBooks().get(i).print();
				   i++;
			 }
			    }//for
		 System.out.println("\n");
	}//print

	@Override
	public void createShoes(String st) {
		System.err.println("It's a book.\n");
	}

	@Override
	public void checkInShoes(ShoeTypes s) {
		System.err.println("It's a book.\n");
	}

	@Override
	public void checkOutShoes(ShoeTypes s) {
		System.err.println("It's a book.\n");
	}

}//Storage
