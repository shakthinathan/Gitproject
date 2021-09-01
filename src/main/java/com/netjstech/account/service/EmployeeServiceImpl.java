package com.netjstech.account.service;

import java.util.List;

import com.netjstech.account.dao.EmployeeDao;
import com.netjstech.account.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao empDao;
	public EmployeeServiceImpl(EmployeeDao empDao)
	{
		this.empDao=empDao;
	}
	public Employee getEmployeeById(int empId) 
	{
		Employee emp=empDao.findEmployeeById(empId);
		return emp;
	}
	public List<Employee>getEmployees()
	{
		System.out.println("Service-In getEmployees");
		List<Employee>empList=empDao.getEmployees();
		return empList;
	}
	public List<Employee>getEmployeesByDept()
	{
		return null;
	}
	public void deleteEmployee(int empId) {
		Employee emp=empDao.findEmployeeById(empId);
		if (emp!=null) {
			empDao.deleteEmployee(emp);
		}else
		{
			throw new IllegalArgumentException("Employee Id not found");
		}
	}
	@Override
	public void insertEmployeeWithValues() {
		empDao.insertEmployeeWithValues();
	}
	public void insertEmployee(Employee e) {
		empDao.insertEmployee(e);
	}
}
