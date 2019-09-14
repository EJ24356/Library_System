
public class Genres extends Book {
	
	Genres(){
		super();
		genre="Anthology";
	}
	Genres(String string){
		super(string);
	}

	Genres(String title, String author, double price) {
		super(title, author, price);
	}

	public String getGenre() {
		return genre;		
	}

	@Override
	public void setGenre(String genre) {
			this.genre=genre;
	}
	
	@Override
	public void print() {
     super.print();
  		System.out.println("Genre: "+genre+"\n"); 
	}//print
	
	
}//Library
