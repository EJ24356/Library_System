import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface Shelf {
	File novelfile = new File("C:\\Users\\Eldel\\Documents\\MIST4600_Library\\src\\Novels.txt"); 
	File shoefile = new File("C:\\Users\\Eldel\\Documents\\MIST4600_Library\\src\\Shoes.txt");
	
HashMap<Integer,Genres> getBooks();
ArrayList<ShoeTypes> getShoes();

public void createBooks(String st);

public void checkinBook(int i);

public void checkoutBook(int i);

public void print();

public void createShoes(String st);

public void checkInShoes(ShoeTypes s);

public void checkOutShoes(ShoeTypes s);



}
