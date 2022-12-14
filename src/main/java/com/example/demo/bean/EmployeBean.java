package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entities.AddressMaster;
//import com.example.demo.entities.AddressList;
import com.example.demo.entities.AddressType;
import com.example.demo.entities.EmployeAddressMaster;

public class EmployeBean {

	
	private Integer id;
	private String name;
	private Date joiningdate;
	private DesignationBean designation;
	private DepartmentBean department;
	private List<EmployeAddressMaster> addressMaster;
//	private List<AddressMaster> address;
//	private List<AddressList> addressList;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public EmployeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getjoiningdate() {
		return joiningdate;
	}
	public void setjoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	
	
/*	public List<AddressList> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressList> addressList) {
		this.addressList = addressList;
	}*/
	
	public DesignationBean getDesignation() {
		return designation;
	}
	
	
//	public List<AddressMaster> getAddress() {
//		return address;
//	}
//	public void setAddress(List<AddressMaster> address) {
//		this.address = address;
//	}
	
	public void setDesignation(DesignationBean designation) {
		this.designation = designation;
	}
	
	public DepartmentBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
	public EmployeBean(Integer id, String name, Date joiningdate, DesignationBean designation,
			DepartmentBean department, List<EmployeAddressMaster> addressMaster) {
		super();
		this.id = id;
		this.name = name;
		this.joiningdate = joiningdate;
		this.designation = designation;
		this.department = department;
		this.addressMaster = addressMaster;
	}
	@Override
	public String toString() {
		return "EmployeBean [id=" + id + ", name=" + name + ", joiningdate=" + joiningdate + ", designation="
				+ designation + ", department=" + department + ", addressMaster=" + addressMaster + "]";
	}
	public List<EmployeAddressMaster> getAddressMaster() {
		return addressMaster;
	}
	public void setAddressMaster(List<EmployeAddressMaster> addressMaster) {
		this.addressMaster = addressMaster;
	}
	
	
	
}