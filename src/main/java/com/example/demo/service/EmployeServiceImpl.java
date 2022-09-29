package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressMaster;
//import com.example.demo.entities.AddressList;
import com.example.demo.entities.AddressType;
//import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeAddressMaster;
import com.example.demo.repository.EmployeRepository;

@Transactional
@Service("employeeService")
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employeeRepository;

	/*	@Override
	public Employe insertEmploye(Employe employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		return this.employeeRepository.save(employe);
	}
	 */
	@Override
	public Optional<Employe> findEmploye(Integer id) {

		return this.employeeRepository.findById(id);
	}

	@Override
	public Iterable<Employe> findAllEmploye() {
		return this.employeeRepository.findAll();
	}

	/*	@Override
	public boolean deleteEmploye(Employe employe) {
		this.employeeRepository.delete(employe);
		return true;
	}*/


	/*	public List<Employe> getAllEmployees(){
		List<Employe> emps = (List<Employe>)employeeRepository.findAll(); 
		return emps;
	}
	 */

	@Override
	public Employe addEmploye(Employe emp) {
		/*		Employe master = new Employe();
		Department department = new Department();
		Designation designation = new Designation();


		//AddressList list = new AddressList();
	//	AddressMaster address = new AddressMaster();
		department.setId(emp.getDepartment().getId());
		designation.setId(emp.getDesignation().getId());

	//	list.setId(emp.getAddressList().);
	 //    address.setId(emp.getAddress().getId());
		//master.setId(emp.getId());
		master.setjoiningdate(emp.getjoiningdate());
		master.setDepartment(department);
		master.setDesignation(designation);
		//master.setAddressMaster(address);
		master.setName(emp.getName());
		employeeRepository.save(master);
		return "employe created succesfully";*/

		Employe master = new Employe();
		EmployeAddressMaster add = new EmployeAddressMaster();

		//master.setAddress(emp.getAddress());
		master.setjoiningdate(emp.getJoiningDate());
		master.setName(emp.getName());
		master.setDepartment(emp.getDepartment());
		master.setDesignation(emp.getDesignation());
		master.setAddressMaster(emp.getAddressMaster());
		return employeeRepository.save(master);

	}

	@Override
	public Employe updateEmploye(Employe emp) {
		//Employe master = new Employe();
		//Department department = new Department();
		//Designation designation = new Designation();

		//	AddressMaster address = new AddressMaster();
		//department.setId(emp.getDepartment().getId());
		//designation.setId(emp.getDesignation().getId());

		//	address.setId(emp.getAddress().getId());
		Employe master = new Employe();
		EmployeAddressMaster empadd = new EmployeAddressMaster();
		master.setjoiningdate(emp.getJoiningDate());
		master.setId(emp.getId());
		//empadd.setId(emp.getAddressMaster().get);
		master.setName(emp.getName());
		master.setDepartment(emp.getDepartment());
		master.setDesignation(emp.getDesignation());
		master.setAddressMaster(emp.getAddressMaster());
		return employeeRepository.save(master);

	}
	public String deleteEmploye(int id)
	{
		employeeRepository.deleteById(id);
		return "Entity deleted "+id;
	}

	public  Employe  getEmploye(int id)
	{
		return employeeRepository.findById(id).get();
	}

	

}