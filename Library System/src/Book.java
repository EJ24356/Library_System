public abstract class Book extends Item{
     protected String title;
     protected String author;
     protected double price;
     protected String genre;
     private boolean checkout=false;
     private int ID;
     
     Book(String title, String author, double price){
         this.title = title;
         this.author = author;
         this.price = price;
     }
     Book(){
    	 title="Life of a Savage";
    	 author="Jesse Eldell";
    	 price=20.00;
     }
     Book(String string){
    	 for(int i =0;i<3;++i) {
    		 if(i==0) {
    			 title=string.substring(0,string.indexOf(','));
    			 string=string.substring(string.indexOf(',')+1);
    		 }
    		 else if(i==1) {
    			 author=string.substring(0,string.indexOf(','));
    			 string=string.substring(string.indexOf(',')+1);
    		 }
    		 else if(i==2) {
    			 price=Double.parseDouble(string);
    		 }   			 
    	 }//for	
     }//Book

     /*
      * ACCESSORS AND MUTATORS
      */
     
     public String getTitle(){
         return title;
     }//getTitle
     
     public String getAuthor(){
         return author;
     }//getAuthor
     
     public double getPrice(){
         return price;
     }//getPrice
     
     
     public void setTitle(String title) {
    	 this.title = title;
     }//setTitle
     
     public void setAuthor(String writer) {
    	 author = writer;
     }//setAuthor
     
     public void setPrice(double cost) {
    	 price = cost;
     }//setPrice
     
     @Override
     public void setCheckOut(boolean checkOut) {
    	 this.checkout = checkOut;
     }
     @Override
     public boolean getCheckOut() {
    	 return checkout;
     }//getCheckOut
     @Override
     public void setID (int ID) {
    	 this.ID = ID;
     }//setID
     @Override
     public int getID() {
    	 return ID;
     }//getID
     
     public void print() {
    	System.out.println("Book Number: " + ID);
  		System.out.println("Book Title: " + title);
  		System.out.println("Author: " + author);
  		System.out.println("Price: $" + price);	
      }//print
     
     public abstract String getGenre();
     public abstract void setGenre(String genre);
   
	
}//Books