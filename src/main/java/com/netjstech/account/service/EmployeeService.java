package com.netjstech.account.service;

import java.util.List;
import com.netjstech.account.dto.Employee;


public interface EmployeeService {

	public Employee getEmployeeById(int empId);
	public List<Employee>getEmployees();
	public List<Employee>getEmployeesByDept();
	public void deleteEmployee(int empId);
	public void insertEmployeeWithValues();
	public void insertEmployee(Employee e);
}
