import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String another = "y";

		Purchase purchase = new Purchase();

		System.out.println("Welcome to the coffee shop!");
		System.out.println("Please enter Customer Name: ");
		String name;
		name =scan.nextLine();
		Customer customer = new Customer(name, 0);
				
		while (!another.equalsIgnoreCase("n")) {
			System.out.println("Pick a flavor: light/medium/bold");
			String flavor = scan.nextLine();
			System.out.println("Pick a size: malenky/ceredny/velicky");
			String size = scan.nextLine();

			double price;
			if (size.equalsIgnoreCase("malenky")) {
				price = 1;
			} else if (size.equalsIgnoreCase("ceredny")) {
				price = 2;
			} else {
				price = 3;
			}

			purchase.addCoffee(new Coffee(flavor, size, price));
			
			customer.setNumCoffees(customer.getNumCoffees()+1);
			
			System.out.println("Your purchase is currently: " + purchase);
			System.out.println("Would you like to buy another cup? (y/n)");
			another = scan.nextLine();
		}
		
		Order order = new Order(customer, purchase);
		
		System.out.println("Your order is: " + order );
		System.out.println("Exiting the coffee shop.");
		
		scan.close();
	}
	

}
