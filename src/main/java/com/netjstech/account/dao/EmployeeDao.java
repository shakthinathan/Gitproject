package com.netjstech.account.dao;

import java.util.List;

import com.netjstech.account.dto.Employee;

public interface EmployeeDao {

	public Employee findEmployeeById(int empId);
	public List<Employee>getEmployees();
	public List<Employee>findEmployeesByDept();
	public void deleteEmployee(Employee emp);
	public void insertEmployeeWithValues();
	public void insertEmployee(Employee e);
	Employee findEmployeeId(int empId);
}
