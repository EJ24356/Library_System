import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class ShoeStorage implements Shelf {
    private HashSet<ShoeTypes> shoeSet = new HashSet<ShoeTypes>();
    private HashMap<Integer,Genres> books;
    private ArrayList<ShoeTypes> shoes;
//    private HashMap<Integer,Shoe> shoeSet;
    protected int numOfShoes=0;
    
    ShoeStorage(File file) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(file));
    	String st; 
    	while ((st = br.readLine()) != null) { 
    		createShoes(st); 
    		numOfShoes++;
    	}
    	toArrayList(shoeSet);
    }
    
	@Override
	public HashMap<Integer, Genres> getBooks() {
		return books;
	}//getBooks
	
	public ArrayList<ShoeTypes> getShoes(){
		return shoes;
	}
	
	@Override
	public void createShoes(String st) {
		ShoeTypes s = new ShoeTypes(st);
		if(s.price<=35)
			s.setShoeType("Cheap Sneakers");
		else if(s.price>35&&s.price<=60)
			s.setShoeType("Regular Sneakers");
		else if(s.price>60&&s.price<=110)
			s.setShoeType("Upscale Sneakers");
		else if (s.price>110&&s.price<=450)
			s.setShoeType("Expensive Sneakers");
		else if (s.price>250)
			s.setShoeType("Designer Shoes");	
		shoeSet.add(s);
		toArrayList(shoeSet);
	}//createShoes

	@Override
	public void checkInShoes(ShoeTypes s) {
		if(shoes.get(Main.userNumber).getCheckOut()==true) {
			shoes.get(Main.userNumber).setCheckOut(false);
			numOfShoes++;
		}			
		else 
			System.err.println("The shoe is in stock");
			
	}//checkinShoe

	@Override
	public void checkOutShoes(ShoeTypes s) {
	if(shoes.get(Main.userNumber).getCheckOut()==false) {
		shoes.get(Main.userNumber).setCheckOut(true);
		numOfShoes--;
	}
	else
		System.err.println("The shoe is out of stock");
	}//checkOutShoes

	protected int getNumOfShoes() {
		return numOfShoes;
	}//getNumOfShoes
    
    @Override
    public void createBooks(String st){
    	System.err.println("It's a Shoe");
    }//createBooks
    

	@Override
	public void checkinBook(int i) {
		System.err.println("It's a Shoe");
	}

	@Override
	public void checkoutBook(int i) {
		System.err.println("It's a Shoe");			
	}
	public ArrayList<ShoeTypes> toArrayList(HashSet<ShoeTypes> st) {
		shoes = new ArrayList<ShoeTypes>();
		int i = 0;
		for(ShoeTypes s: st) {
			shoes.add(s);
			shoes.get(i).setID(i);
			i++;
		}
		return shoes;	
	}
	
	@Override
	public void print() {
		System.out.println("Shoe Selection:\n");
		int i = 0;
		 for(ShoeTypes s:shoes) {
			 if(shoes.get(i).getCheckOut()==false) {
				 shoes.get(i).setID(i);
				 shoes.get(i).print();
			 }
			 i++;
			    }//for	
		 System.out.println("\n");
	}//print

}//Storage
