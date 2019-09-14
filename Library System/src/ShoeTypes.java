
public class ShoeTypes extends Shoe {

	public ShoeTypes() {
		super();
		shoeType = "Cheap Sneaker";
	}
	
	public ShoeTypes(String string) {
		super(string);
	}

	@Override
	public String getShoeType() {
		return shoeType;
	}

	@Override
	public void setShoeType(String type) {
		shoeType = type;		
	}
	
	public void print() {
		super.print();
  		System.out.println("Type: "+shoeType+"\n");
	}

}
