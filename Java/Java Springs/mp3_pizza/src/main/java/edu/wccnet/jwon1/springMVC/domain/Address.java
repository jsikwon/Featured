package edu.wccnet.jwon1.springMVC.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Address {
	@NotBlank
	private String street;
	@NotBlank
	@Pattern(regexp="^[0-9]{5}", message="zipcode must be 5 digits")
	private String zip;
	@NotBlank
	private String city;
	private String state;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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

	
}
