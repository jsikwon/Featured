package machine.problem1;

import java.util.Scanner;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipcode;
	public static Scanner kbInput = new Scanner(System.in);
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public static Scanner getKbInput() {
		return kbInput;
	}
	public static void setKbInput(Scanner kbInput) {
		Address.kbInput = kbInput;
	}
	public Address() {
		System.out.println("Please enter your street:");
		setStreet(kbInput.nextLine());
		
		System.out.println("Please enter your city:");
		setCity(kbInput.nextLine());
		
		System.out.println("Please enter your state:");
		setState(kbInput.nextLine());
		
		System.out.println("Please enter your zipcode:");
		setZipcode(kbInput.nextLine());
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
