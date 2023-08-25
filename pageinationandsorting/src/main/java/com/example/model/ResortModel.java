package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="resortportal")
public class ResortModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resortid;
	private String resortname;
	private String address;
	private int contact_number;
	private String location;
	private String website;
	private int roomno;
	private int number_of_review;
	private String pricerange;
	public int getResortid() {
		return resortid;
	}
	public void setResortid(int resortid) {
		this.resortid = resortid;
	}
	public String getResortname() {
		return resortname;
	}
	public void setResortname(String resortname) {
		this.resortname = resortname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_number() {
		return contact_number;
	}
	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public int getNumber_of_review() {
		return number_of_review;
	}
	public void setNumber_of_review(int number_of_review) {
		this.number_of_review = number_of_review;
	}
	public String getPricerange() {
		return pricerange;
	}
	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}
	
	
	
	

}
