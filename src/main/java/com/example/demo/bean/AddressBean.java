package com.example.demo.bean;

import com.example.demo.entities.Employe;
public class AddressBean {
	
	private int id;
	private String currentAddress;
	private String permanentAddress;
	private String officeAddress;
	
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public AddressBean(int id, String currentAddress, String permanentAddress, String officeAddress) {
		super();
		this.id = id;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.officeAddress = officeAddress;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public AddressBean(int id, String currentAddress, String permanentAddress) {
		super();
		this.id = id;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
	}
	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressBean(String currentAddress, String permanentAddress) {
		super();
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
	}
	
	
	
	

}
