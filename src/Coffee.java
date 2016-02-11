
public class Coffee {
	String flavor, size;
	double price;
	
	public Coffee(String flavor, String size, double price) {
		this.flavor = flavor;
		this.size = size;
		this.price = price;
	}
	
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coffee flavor: " + flavor + ", size: " + size + ", price: $" + price + "\n";
	}
	
	
	

}
