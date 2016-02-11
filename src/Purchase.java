import java.util.ArrayList;

public class Purchase {
	ArrayList<Coffee> purchase;
	double totalPurchase;

	public Purchase() {
		this.purchase = new ArrayList<Coffee>();
		this.totalPurchase = 0;
	}

	public ArrayList<Coffee> getPurchase() {
		return purchase;
	}

	public void setPurchase(ArrayList<Coffee> purchase) {
		this.purchase = purchase;
	}

	public void addCoffee(Coffee java) {
		this.purchase.add(java);
		this.totalPurchase += java.getPrice();
	}

	@Override
	public String toString() {
		return "" + purchase + "\n" + "Total purchase: $" + this.totalPurchase;
	}

}
