
public class Customer {
	String name;
	int numCoffees;
	
	public Customer(String name, int numCoffees) {
		this.name = name;
		this.numCoffees = numCoffees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumCoffees() {
		return numCoffees;
	}
	public void setNumCoffees(int numCoffees) {
		this.numCoffees = numCoffees;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", numCoffees=" + numCoffees + "]";
	}
	
	
}
