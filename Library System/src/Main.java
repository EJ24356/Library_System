import java.io.IOException;
import java.util.Scanner;

/*
 * The main method of the program
 */
public class Main {
	static Scanner user;
	static int userNumber;
	static int bookOrShoe;
	static String newItem;
   public static void selection() {
	   System.out.println("Select a number 1-6\n1) Leave Store\n2) Check Out\n"
				+ "3) Check In \n4) See Item Selections\n5) Current Item(s)\n6)Donate");	
   }
   public static void chooseBookNumber() {
	   System.out.println("Choose Book Number");
	   user = new Scanner(System.in);
	   while (!user.hasNextInt()) {
		   System.err.println("Invalid. Enter in the Book Number from avaiable selection.");
		   user = new Scanner(System.in);	
	   }
	   userNumber = user.nextInt();
   }
   public static void chooseShoeNumber() {
	   System.out.println("Choose Shoe Number");
	   user = new Scanner(System.in);
	   while (!user.hasNextInt()) {
		   System.err.println("Invalid. Enter in the Book Number from avaiable selection.");
		   user = new Scanner(System.in);	
	   }
	   userNumber = user.nextInt();
   }
   public static void bookOrShoe() {
	   System.out.println("Do you want a Book [1] or Shoes [2]? Type number");
	   user = new Scanner(System.in);
	   while (!user.hasNextInt()) {
		   System.err.println("Type in 1 for Book, 2 for Shoes");
		   user = new Scanner(System.in);
	   }
	   bookOrShoe = user.nextInt(); 
   }//bookOrShoe
   
   public static void checkOutBook(Library lib,Customer c) {
	   lib.getbooks().checkoutBook(userNumber);
	   try {
		if(lib.getbooks().getBooks().get(userNumber).getCheckOut()==true)
			c.addBook(lib.getbooks().getBooks().get(userNumber));
	   }
	   catch (Exception e) {System.err.println("Not a valid Book number");}
   }//checkOutBook
   
   public static void checkOutShoe(Library lib, Customer c) {
	   lib.getshoes().checkOutShoes(lib.getshoes().getShoes().get(userNumber));
	   try {
	   if(lib.getshoes().getShoes().get(userNumber).getCheckOut()==true)
		   c.addShoe(lib.getshoes().getShoes().get(userNumber));	
	   }//try
	   catch (Exception e) {System.err.println("Not a valid Book number");}
   }//checkOutShoe
   
   public static void checkInBook(Library lib, Customer c) {
	   lib.getbooks().checkinBook(userNumber);
	   try {
		if(lib.getbooks().getBooks().get(userNumber).getCheckOut()==false)
			c.removeBook(lib.getbooks().getBooks().get(userNumber));
	   }//try
	   catch (Exception e) {System.err.println("Not a valid Shoe number");}
   }//checkInBook
   
   public static void checkInShoe(Library lib, Customer c) {
	   lib.getshoes().checkInShoes(lib.getshoes().getShoes().get(userNumber)); 
	   try {
	   if(lib.getshoes().getShoes().get(userNumber).getCheckOut()==false)
		   c.removeShoe(lib.getshoes().getShoes().get(userNumber));
	   }//try
	   catch (Exception e) {System.err.println("Not a valid Shoe number");}
	   
   }//checkInShoe
   
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to LASS!!, where the good times last.\n");	
		boolean start = true;
		
		Library lib = new Library();
		Customer c = new Customer();
			
		do {
			selection();
			user = new Scanner(System.in);
			int userchoice;

			if(!user.hasNextInt())
				userchoice=0;
			else
				userchoice=user.nextInt();
			
			switch (userchoice) {
			default:
				System.err.println("Select # between 1-6");
				break;
			case 1:
				System.out.println("Goodbye!");
				start=false;
				break;
			case 2:
				bookOrShoe();
				if(bookOrShoe==1) {
					chooseBookNumber();						
					checkOutBook(lib,c);
				}
				else if (bookOrShoe==2) {
					chooseShoeNumber();
					checkOutShoe(lib,c);
				}
				else
					System.err.println("1 or 2 not chosen");	
				break;
			case 3:
				bookOrShoe();
				if(bookOrShoe==1) {
					chooseBookNumber();						
					checkInBook(lib,c);
				}
				else if (bookOrShoe==2) {
					chooseShoeNumber();
					checkInShoe(lib,c);
				}
				else
					System.err.println("1 or 2 not chosen");	
				break;
			case 4:
				lib.getshoes().print();
				lib.getbooks().print();
				break;
			case 5:
				System.out.println("Current Items: \n");
				c.printItems();		
				break;
			case 6:
				bookOrShoe();
				if(bookOrShoe==1) {
					System.out.println("When adding a book type like so,"
							+ "Name,Author,Price");
					user = new Scanner(System.in);
					newItem = user.nextLine();
					lib.getbooks().createBooks(newItem);
				}
				else if(bookOrShoe==2) {
					System.out.println("When adding a shoe type like so,"
							+ "Name,Size,Price");
					user = new Scanner(System.in);
					newItem = user.nextLine();
					lib.getshoes().createShoes(newItem);
				}
				else
					System.err.println("1 or 2 not chosen");	
				break;		
			}//switch
			
		}  while (start);//while
			
	}//main

}//Main
