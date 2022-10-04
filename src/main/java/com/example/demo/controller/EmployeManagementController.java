package com.example.demo.controller;


import java.util.Date;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Employe;
import com.example.demo.entities.PagedResponse;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DesignationService;
import com.example.demo.service.EmployeService;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;






@RestController
public class EmployeManagementController {
	
	@Autowired //tells the spring that, injection need to occur here, then spring searches for that EmployeService component and injects it here
	EmployeService employeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	EmployeRepository employeRepo;
	
	static final Logger logger  = LogManager.getLogger(EmployeManagementController.class.getName());
	
/*	@RequestMapping(value="/employe/insert")//inserts new student record into the table
    //@RequestMapping(method = RequestMethod.POST, value = "/insert",
    //    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> insertEmploye(
            @RequestParam("name") String name,
            @RequestParam("age") Double age,
            @RequestParam("deptid") Integer deptid,
            @RequestParam("desid") Integer desid){
        //RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
        Map<String,String> message = new LinkedHashMap<>();
        Employe newEmploye;
        if(this.departmentService.find(deptid).isPresent()) {
            newEmploye = new Employe();
            newEmploye.setName(name);
            newEmploye.setAge(age);
            newEmploye.setDepartment(this.departmentService.find(deptid).get());
            newEmploye.setDesignation(this.designationService.find(desid).get());
            System.out.println(newEmploye);
            if(this.employeService.insertEmploye(newEmploye)!=null) {
                message.put("Success", "New employe successfully added!");
                message.put("ID",newEmploye.getId().toString());
                message.put("Name", name);
                message.put("Age", age+"");
                message.put("Department", this.departmentService.find(deptid).get().getName());
                message.put("Designation", this.designationService.find(desid).get().getName());
            }
            else
                message.put("Error", "Error cannot add new employe");
        }
        else {
            message.put("Error", "Department id "+deptid+" is not found");
        }
        return message;
    }
	
	
	
	
	/*@RequestMapping(value="/Employe/update") //Updates student table
	public Map<String,String> updateEmploye(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Double age,@RequestParam("deptid") Integer deptid ,@RequestParam("desid") Integer desid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Employe newEmploye;
		if(this.employeService.findEmploye(id).isPresent()) {
			if(this.departmentService.find(deptid).isPresent()) {
				newEmploye = this.employeService.findEmploye(id).get();
				newEmploye.setName(name);
				newEmploye.setAge(age);
				newEmploye.setDepartment(this.departmentService.find(deptid).get());
				newEmploye.setDesignation(this.designationService.find(desid).get());
				
				if(this.employeService.updateEmploye(newEmploye)!=null) {
					message.put("Success", "Employe details successfully updated");
					message.put("ID",newEmploye.getId().toString());
					message.put("Name", name);
					message.put("Age", age+"");
					message.put("Department", this.departmentService.find(deptid).get().getName());
				}
				else
					message.put("Error", "Error cannot update employe");
			}
			else 
				message.put("Error", "Department id "+deptid+" is not found");
		}
		else
			message.put("Error", "Employe id "+id+" is not found");
		
		return message;
	}
	*/
	
/*@GetMapping(value="/employe/findall")// Lists all the student record in the student table
	public List<Map<String,String>> findAllEmploye(){
		Map<String,String> message ;
		List<Map<String,String>> listOfMessages = new LinkedList<>();
		Employe foundEmploye;
		Iterator<Employe> iterator = this.employeService.findAllEmploye().iterator(); //this.studentService.findAll() return Iterator<>
		if(iterator.hasNext()) { // if table is not empty
			while(iterator.hasNext()) {
				foundEmploye = iterator.next(); // fetch record one by one
				message = new LinkedHashMap<>(); // to store invidual's info
				message.put("ID", foundEmploye.getId().toString());
				message.put("Name", foundEmploye.getName());
				message.put("Age", foundEmploye.getJoiningDate().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
				message.put("Designation", foundEmploye.getDesignation().getName());
				message.put("PermanentAddress", foundEmploye.getAddress().getPermanentAddress());
				message.put("CurrentAddress", foundEmploye.getAddress().getCurrentAddress());
				listOfMessages.add(message); // list of individual's info
			}
		}
		else { 
			message = new LinkedHashMap<>();
			message.put("Error","No Employe found!");
			listOfMessages.add(message);
		}
		return listOfMessages;
	}*/
	

/*	//Finds Student details for the given id 
		@GetMapping(value="/employe/{id}")
		public Map<String,String> findEmploye(@PathVariable Integer id){
			//@PathVariable takes the part of url as value her {id} taken as id value
			Map<String,String> message = new LinkedHashMap<>(); // to store student details
			Employe foundEmploye;
			//this.studentService.find(id) returns Optional<> whose methods are isPresent and get()
			if(this.employeService.findEmploye(id).isPresent()) { // if the given student id is present
				foundEmploye = this.employeService.findEmploye(id).get(); //fetches the student record from the database
				//Getting student detail with help of getter methods
				message.put("ID", foundEmploye.getId().toString());
				message.put("Name", foundEmploye.getName());
				message.put("Age", foundEmploye.getJoiningDate().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
				message.put("Designation", foundEmploye.getDesignation().getName());
				message.put("PermanentAddress", foundEmploye.getAddress().getPermanentAddress());
				message.put("CurrentAddress", foundEmploye.getAddress().getCurrentAddress());
			}
			else { 
				message.put("Error","Cannot find employe with id "+id);
			}
			return message;
		}
		*/
		
/*		@DeleteMapping(value="/employe/delete/{id}")//deletes record from student table for the given id
		public Map<String,String> deleteEmploye(@PathVariable("id") Integer id){
			System.out.println("\nrunning delete");
			Map<String,String> message = new LinkedHashMap<>();
			Employe oldEmploye;
			if(this.employeService.findEmploye(id).isPresent()) {	
				oldEmploye = this.employeService.findEmploye(id).get();
				
				message.put("ID", oldEmploye.getId().toString());
				message.put("Name", oldEmploye.getName());
				message.put("Age", oldEmploye.getJoiningDate().toString());
				message.put("Department", oldEmploye.getDepartment().getName());
				message.put("Designation", oldEmploye.getDesignation().getName());
				message.put("CurrentAddress", oldEmploye.getAddress().getCurrentAddress());
				message.put("PermanentAddress", oldEmploye.getAddress().getPermanentAddress());
				
				
				if(this.employeService.deleteEmploye(oldEmploye)) 
					message.put("Success", "Employe successfully removed");
				else {
					message.clear();
					message.put("Error", "Error cannot delete employe");
				}
			}
			else
				message.put("Error", "Employe id "+id+" is not found");
			return message;
		}
	*/
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/employe/add")
	public Employe insertEmploye(@RequestBody Employe emp)
	{
		return employeService.addEmploye(emp);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/employe/update")
	public Employe updateEmploye(@RequestBody Employe emp)
	{
		return employeService.updateEmploye(emp);
	}
	
	@DeleteMapping(path ="/employe/delete/{id}")
	public String deleteAddress(@PathVariable int id)
	{
		return employeService.deleteEmploye(id);
	}
   
	@GetMapping(value="/employe/find")
	public Iterable<Employe> findAllEmployeAddressMaster(){
		//@PathVariable takes the part of url as value her {id} taken as id value
	/*	Map<String,String> message = new LinkedHashMap<>(); // to store student details
	Employe Master;
	Master = this.employeService.getEmploye(id); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", Master.getId().toString());
			message.put("Name", Master.getName());
			message.put("JoiningDate", Master.getJoiningDate().toString());
			message.put("Designation", Master.getDesignation().getName());
			message.put("Department", Master.getDepartment().getName());
		//	message.put("PermanentAddress", Master.getAddressMaster().getPermanentAddress());
			//message.put("CurrentAddress", Master.getAddressMaster().getCurrentAddress());
			//message.put("OfficeAddress", Master.getAddressMaster().getOfficeAddress());
			
		return message;*/
		
		return employeRepo.findAll();
	}
	
	@GetMapping(value="/employe/find/{id}")
	public Employe findEmployeAddressMaster(@PathVariable int id){
/*		//@PathVariable takes the part of url as value her {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store student details
	Employe Master;
	Master = this.employeService.getEmploye(id); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", Master.getId().toString());
			message.put("Name", Master.getName());
			message.put("JoiningDate", Master.getJoiningDate().toString());
			message.put("Designation", Master.getDesignation().getName());
			message.put("Department", Master.getDepartment().getName());
		//	message.put("PermanentAddress", Master.getAddressMaster().getPermanentAddress());
			//message.put("CurrentAddress", Master.getAddressMaster().getCurrentAddress());
			//message.put("OfficeAddress", Master.getAddressMaster().getOfficeAddress());
			
		return message;
		*/
		if(employeRepo.findById(id).isPresent())
		{
			return employeRepo.findById(id).get();
		}
		else
			return null;
		
	}
	
	 
	 @GetMapping("/employe/{pageNo}/{pageSize}")
	 public List<Employe> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize)
	 {
		 return employeService.findPaginated(pageNo, pageSize);
	 }
	 
	 @GetMapping("/employe/asc/{name}")
	public List<Employe> getByNameSortAsc(@PathVariable String name)
	{
		List<Employe> emp = employeService.employeSortAsc(name);
		return emp;
	}
	
	 
	 @GetMapping("/employe/des/{name}")
		public List<Employe> getByNameSortDes(@PathVariable String name)
		{
			List<Employe> emp = employeService.employeSortDes(name);
			return emp;
		}
		
	 
	 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/employe/page")
	    public PagedResponse<Employe> getEmploye(
	            @RequestParam(value = "id", required =false) Integer id ,
	            @RequestParam(value = "name", required = false) String name,
	            @RequestParam(value = "joiningdate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date joiningdate,
	            @RequestParam(value = "keyword", required = false) String keyword,
	            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
	            @RequestParam(value = "size", defaultValue = "0", required = false) int size,
	            @RequestParam(value = "sort", defaultValue = "createdDate", required = false) String sort,
	            @RequestParam(value = "order", defaultValue = "desc", required = false) String order, 
	            @And({  @Spec(path = "id", params = "id", spec = Equal.class),
	                @Spec(path = "name", params = "name", spec = Equal.class),
	                @Spec(path = "joiningdate", params = "joiningdate", spec = Equal.class)}) 
	            Specification<Employe> spec) {

	        Pageable pageable = (size != 0
	                ? PageRequest.of(page - 1, size,order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,sort)
	                : Pageable.unpaged());
	        return employeService.findAllEmploye(pageable, spec);
	    }
}