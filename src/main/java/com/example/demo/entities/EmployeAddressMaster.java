package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//mapped to database table
@Table(name="EMPLOYEADDRESSMASTER")
public class EmployeAddressMaster {

	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="ID",unique = true,nullable = false) //name is optional is variable name matches table field name
	private Integer id;

	@Column(name="PLACE",nullable = false) // nullable checks whether null accepted, before db throws error
	private String Place;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TYPEID",nullable = false)
	private AddressType Type;

	//@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one employe
	//@JoinColumn(name="EMPID",nullable = false)//used to join the entity
	//private Employe empid;

	public EmployeAddressMaster(Integer id, String state,AddressType type,Employe empid) {
		super();
		this.id = id;
		this.Place = Place;
		this.Type = type;
		//this.empid = empid;
	}

	public EmployeAddressMaster(String state, AddressType type) {
		super();
		Place = state;
		Type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return Place;
	}

	public void setState(String state) {
		Place = state;
	}

	public AddressType getType() {
		return Type;
	}

	public void setType(AddressType type) {
		Type = type;
	}

	//public Employe getEmpid() {
	//	return empid;
	//}

	//public void setEmpid(Employe empid) {
	//	this.empid = empid;
	//}

	public EmployeAddressMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeAddressMaster [id=" + id + ", place=" + Place +"]";
	}


	public EmployeAddressMaster(Integer id, String place,String type) {
		super();
		this.id = id;
		this.Place = place;
		
	}


	public EmployeAddressMaster(String place, String type) {
		super();
		this.Place = place;
	
	}


	



	
/*	 @ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one employe
	 @JoinColumn(name="EMPID",nullable = false)//used to join the entity
	private Employe empid;*/

	
}