package com.jnit.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

import com.jnit.app.model.Employee;
import com.jnit.app.repositories.Employeerepository;


public class EmployeePersistenceTest extends ParentTest{

	@Autowired
	private Employeerepository employeerepository;
	
	@Test
	public void testEmployeeCreation(){
		Employee employee = new Employee("hkoka@gmail.com", "hasini", "h", "R", "hasini0924", LocalDate.of(1989, 9, 2), null);
		Employee createdEmployee = employeerepository.save(employee);
		assertNotNull("Employee id not present",createdEmployee.getUserId());
	}

	@Test
	public void testFindEmployeeById(){
		Employee Employee = employeerepository.findOne(1L);
		assertNotNull("Employee name not present",Employee.getUserName());
	}
	
	@Test
	public void testFindAll(){
		List<Employee>Employees = employeerepository.findAll();
		assertTrue( "Employees list is empty",Employees.size() > 0);
	}
	
	@Test
	public void testUpdateEmployee(){
		Employee Employee = employeerepository.findOne(1L);
		Employee.setmName("Rao");
		Employee updatedEmployee = employeerepository.save(Employee);
		assertEquals("Rao", updatedEmployee.getmName());
	}
	
	//@Test
	public void testDeleteEmployee(){
		Employee Employee = employeerepository.findOne(1L);
		employeerepository.delete(Employee);
		Employee EmployeeObj = employeerepository.findOne(1L);
		assertNull("Employee seems to be not deleted",EmployeeObj);
	}
	
	@Test
	public void testFindEmployeeByUserName(){
		Optional<Employee> EmployeeOptional = employeerepository.findByUserName("hkoka@gmail.com");
		assertTrue("Employee not found with the Employee name",EmployeeOptional.isPresent());
	}
	
	@Test
	public void testFindByLastName(){
		List<Employee>Employees = employeerepository.findByLName("h");
		assertTrue( "Employees list is empty",Employees.size() > 0);
	}

	@Test
	public void testCountByLastName(){
		Long count = employeerepository.countByLName("h");
		assertTrue( "Employees list is empty",count > 0);
	}
	
	@Test
	public void testFindByFNameAndLName(){
		Optional<Employee> EmployeeOptional = employeerepository.findByFNameAndLName("hasini","h");
		assertTrue("Employee not found with the provided first and lname",EmployeeOptional.isPresent());
	}

	@Test
	public void testFindByFNameOrLName(){
		List<Employee> Employees = employeerepository.findByFNameOrLName("hasini","h");
		assertTrue( "Employees list is empty",Employees.size() > 0);
	}
	
	@Test
	public void testFindDistinctByMName(){
		List<Employee> Employees = employeerepository.findDistinctByMName("Rao");
		assertTrue( "Employees list is empty",Employees.size() > 0);	
	}
	
	@Test
	public void testFindFirst3ByLNameOrderByUserNameAsc(){
		List<Employee> Employees = employeerepository.findFirst3ByLNameOrderByUserNameAsc("h");
		assertTrue( "Employees list is empty",Employees.size() > 0);		
	}
	
	

}
