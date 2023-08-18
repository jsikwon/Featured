package machine.problem1;

import java.util.Scanner;

public class Pizza {
	private enum Size {L, M, S};
	private Size size;
	private enum Toppings {
		MUSHROOM,
		PINEAPPLE,
		BACON,
		PEPPERONI,
		CHICKEN,
		PEPPERS,
		TOMATO,
		SPINACH,
		ARTICHOKE		
	};
	private Toppings[] toppings;
	private int numb_of_toppings;
	public static Scanner kbInput = new Scanner(System.in);
	public Pizza () {

			System.out.print("Please enter the size: ");
			for (Size size : Size.values()) {
				System.out.print(size + " ");
			}
			size = Size.valueOf(kbInput.nextLine());
			System.out.println("Please enter the number of toppings: ");
			numb_of_toppings = kbInput.nextInt();
			kbInput.nextLine();
			toppings = new Toppings[numb_of_toppings];
			System.out.println("choices are:");
			for (Toppings toppings : Toppings.values()) {
				System.out.println(toppings);
			}
			for(int i=0; i<numb_of_toppings; i++) {
				System.out.println("enter a topping");
				toppings[i] = Toppings.valueOf(kbInput.nextLine());
			}
		
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Toppings[] getToppings() {
		return toppings;
	}

	public void setToppings(Toppings[] toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		String toppingStr = "";
		for (Toppings toppings : toppings) {
			toppingStr = toppingStr + toppings + " ";
		}
		return size + " " + toppingStr;
	}
	public static void main(String[] args) {
		Pizza myPizza = new Pizza();
		System.out.println(myPizza);
	}
	public Pizza(Size size, Toppings[] toppings) {
		super();
		this.size = size;
		this.toppings = toppings;
	}

	
}
