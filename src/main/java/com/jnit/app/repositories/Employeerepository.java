package com.jnit.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnit.app.model.Employee;
//Relly -

//findBy, readBy, queryBy, countBy, and getBy.
public interface Employeerepository extends JpaRepository<Employee, Long>{

	public Optional<Employee> findByUserName(String userName);
	
	public List<Employee>findByLName(String lastName);

	public Long countByLName(String lastName);

	public Optional<Employee>findByFNameAndLName(String firstName, String lastName);

	public List<Employee>findByFNameOrLName(String firstName, String lastName);
	
	public List<Employee>findDistinctByMName(String middleName);

	public List<Employee> findFirst3ByLNameOrderByUserNameAsc(String lastName);

}
