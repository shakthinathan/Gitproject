package com.netjstech.mypack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.netjstech.account.dao.EmployeeDao;
import com.netjstech.account.dto.Employee;
import com.netjstech.account.service.EmployeeService;
import com.netjstech.account.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeSer {

	static EmployeeService employeeService=null;
	static EmployeeDao mockemployeeDao=null;
	private static Employee emp1;
	private static Employee emp2;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		mockemployeeDao = Mockito.mock(EmployeeDao.class);
		employeeService=new EmployeeServiceImpl(mockemployeeDao);
		emp1=new Employee();
		emp1.setEmpNo(1);
		emp1.setEmpName("Hemant");
		emp1.setHireDate(LocalDate.of(2018, 11, 22));
		emp1.setSalary(8000);
		emp1.setJob("Developer");
		emp2=new Employee();
		emp2.setEmpNo(2);
		emp2.setEmpName("Varsha");
		emp2.setHireDate(LocalDate.of(2018, 10, 21));
		emp2.setSalary(10000);
		emp2.setJob("Manager");
		Mockito.when(mockemployeeDao.getEmployees()).thenReturn(Arrays.asList(emp1,emp2));
		
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception
	{
		
	}
	@BeforeAll
	void setUp() throws Exception{
		
	}
	@Test
	void getAllEmployeestest() {
		List<Employee>allEmployees=employeeService.getEmployees();
		
		assertNotNull(allEmployees);
		assertEquals(2,allEmployees.size());
	}
	
	
}
