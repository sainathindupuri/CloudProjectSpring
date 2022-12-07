package com.cloud.googlepubsubmaven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InputDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String year;
	private String kms;
	private String owner;
	private String fuel_type;
	private String present_price;
	private String seller_type;
	private String transmission_type;
	

	public String getPresent_price() {
		return present_price;
	}

	public void setPresent_price(String present_price) {
		this.present_price = present_price;
	}

	public String getSeller_type() {
		return seller_type;
	}

	public void setSeller_type(String seller_type) {
		this.seller_type = seller_type;
	}

	public String getTransmission_type() {
		return transmission_type;
	}

	public void setTransmission_type(String transmission_type) {
		this.transmission_type = transmission_type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKms() {
		return kms;
	}

	public void setKms(String kms) {
		this.kms = kms;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "InputDetails [id=" + id + ", year=" + year + ", kms=" + kms + ", owner=" + owner + ", fuel_type="
				+ fuel_type + ", present_price=" + present_price + ", seller_type=" + seller_type
				+ ", transmission_type=" + transmission_type + "]";
	}

	

}
