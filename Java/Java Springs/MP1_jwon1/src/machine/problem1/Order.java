package machine.problem1;


import java.util.Scanner;

public class Order {
	
	private Customer customer;
	private int numb_of_pizza;
	private Pizza[] pizzas;
	public static Scanner kbInput = new Scanner(System.in);
	
	public void enterCustomer() {
		setCustomer(new Customer());
	}
	public Order() {
		enterCustomer();
		orderPizza();
	}
	public Order (Customer customer) {
		this.customer = customer;
		orderPizza();
	}
	public void orderPizza() {
		System.out.println("How many pizzas do you want to order?");
		setNumb_of_pizza(kbInput.nextInt());
		kbInput.nextLine();
		pizzas= new Pizza[numb_of_pizza];
		for(int i=0; i<numb_of_pizza; i++) {
			System.out.println("Info for pizza-" + (i+1));
			pizzas[i] = new Pizza();
		}
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getNumb_of_pizza() {
		return numb_of_pizza;
	}


	public void setNumb_of_pizza(int numb_of_pizza) {
		this.numb_of_pizza = numb_of_pizza;
	}


	@Override
	public String toString() {
		String pizzaStr="";
		for (Pizza eachPizza : pizzas) {
			pizzaStr = pizzaStr + eachPizza + "\n";
		}
		return "Order confirmation: \n [Customer " + customer.toString() + "\n" + getNumb_of_pizza() + " pizza(s)= \n" + pizzaStr;
	}
	
}

