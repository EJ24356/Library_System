public abstract class Shoe extends Item {
     protected String shoeName;
     protected String size;
     protected double price;
     protected String shoeType;
     private boolean checkout=false;
     private int ID;
     
     Shoe(String shoeName, String size, double price){
         this.shoeName = shoeName;
         this.size = size;
         this.price = price;
     }
     Shoe(){
    	 shoeName="Sketchers";
    	 size="Men's 10.5";
    	 price=5.73;
     }
     Shoe(String string){
    	 for(int i =0;i<3;++i) {
    		 if(i==0) {
    			 shoeName=string.substring(0,string.indexOf(','));
    			 string=string.substring(string.indexOf(',')+1);
    		 }
    		 else if(i==1) {
    			 size=string.substring(0,string.indexOf(','));
    			 string=string.substring(string.indexOf(',')+1);
    		 }//else if
    		 else if(i==2) {
    			 price=Double.parseDouble(string);
    		 }	//else if		 
    	 } //for		
     }//Shoe

     public String getShoeName(){
         return shoeName;
     }//getShoeName
     
     public String getSize(){
         return size;
     }//getSize
     
     public double getPrice(){
         return price;
     }//getPrice
     

     public void setShoeName(String shoeName) {
    	 this.shoeName = shoeName;
     }//setShoeName
     
     public void setSize(String size) {
    	 this.size = size;
     }//setSize
     
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
    	System.out.println("Shoe Number: " + ID);
  		System.out.println("Shoe Name: " + shoeName);
  		System.out.println("Size: " + size);
  		System.out.println("Price: $" + price);
      }//print
     
     public abstract String getShoeType();
     public abstract void setShoeType(String genre);
   
	
}//Books