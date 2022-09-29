package com.example.demo.bean;

import com.example.demo.entities.Employe;
import com.example.demo.entities.AddressType;

public class EmployeAddressMasterBean {
	private int id;
	private String place;
	private AddressType type;
	//private Employe empid;
	
	
	
	
	public EmployeAddressMasterBean(int id, String place, AddressType type, Employe empid) {
		super();
		this.id = id;
		this.place = place;
		this.type = type;
		//this.empid = empid;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	//public Employe getEmpid() {
	//	return empid;
	//}
	//public void setEmpid(Employe empid) {
		//this.empid = empid;
	//}
	public EmployeAddressMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	