import java.io.IOException;

public class Library {
	private ShoeStorage ss;
	private BookStorage bs;
	
	public Library() throws IOException {
		bs = new BookStorage(Shelf.novelfile);
		ss = new ShoeStorage(Shelf.shoefile);
	}
	public ShoeStorage getshoes() {
		return ss;	
	}
	public BookStorage getbooks() {
		return bs;
	}
}
