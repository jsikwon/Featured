package machine.problem1;

import java.util.Scanner;

public class Customer {
	
	private String name;
	private Address address;
	public static Scanner kbInput = new Scanner(System.in);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Customer() {
		System.out.println("Please enter your information");
		System.out.println("Please enter your name: ");
		setName(kbInput.nextLine());
		System.out.println("Please enter your address");
		setAddress(new Address());
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", address= " + address + "]";
	}
}
