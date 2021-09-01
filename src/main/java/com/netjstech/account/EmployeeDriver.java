package com.netjstech.account;

import java.util.List;

import com.netjstech.account.dao.EmployeeDao;
import com.netjstech.account.dao.EmployeeDaoImpl;
import com.netjstech.account.dto.Employee;
import com.netjstech.account.service.EmployeeService;
import com.netjstech.account.service.EmployeeServiceImpl;

public class EmployeeDriver {

	public static void main(String argss[])
	{
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		EmployeeService employeeService=new EmployeeServiceImpl(employeeDao);
		
		
		List<Employee>empList=employeeService.getEmployees();
		System.out.println("Back with Employee List- "+empList.size());
		for(Employee employee:empList) {
			System.out.println(employee);
		}
		
}
}