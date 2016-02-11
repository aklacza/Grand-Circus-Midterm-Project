
public class Order {
	Customer customer;
	Purchase purchase;
	
	double orderTotal; 
	
	public Order(Customer customer, Purchase purchase) {
		this.customer = customer;
		this.purchase = purchase;
		this.orderTotal= 0;
		
	}
	
	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return purchase +"\n" + customer.getName() + "'s total number of coffees purchased = " + customer.getNumCoffees();
	}


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	public void orderTotal(){
		
	}
	
}
