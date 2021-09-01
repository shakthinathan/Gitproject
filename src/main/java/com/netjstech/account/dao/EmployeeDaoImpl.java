package com.netjstech.account.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.netjstech.account.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee>empList=new ArrayList<Employee>();
	@Override
	public Employee findEmployeeId(int empId) {
	Connection conn;
	try
	{
		conn=DButil.getDBConnection();
		PreparedStatement pstmt=conn.prepareStatement("select Empno,Ename,job,Hiredate,Sal,dept_name"
									+ "from emp e, department_master d where empno=? and e.deptno=d.dept_code");
		pstmt.setInt(1, empId);
		ResultSet rs=pstmt.executeQuery();
		Employee employee=new Employee();
		while(rs.next())
		{
			employee.setEmpNo(rs.getInt("Empno"));
			employee.setEmpName(rs.getString("Ename"));
			employee.setJob(rs.getString("job"));
			employee.setHireDate(rs.getDate("Hiredate").toLocalDate());
			employee.setSalary(rs.getDouble("Sal"));
			employee.setDeptName(rs.getString("dept_name"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return empList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//getting list of employees
	@Override
	public List<Employee>getEmployees(){
		Connection conn;
		List<Employee>empList=new ArrayList<Employee>();
		try {
			conn=DButil.getDBConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select Empid,Ename from Emp");
			while(rs.next())
			{
				Employee employee=new Employee();
				employee.setEmpNo(rs.getInt("Empid"));
				employee.setEmpName(rs.getString("Ename"));
//				employee.setJob(rs.getString("job"));
//				employee.setHireDate(rs.getDate("Hiredate").toLocalDate());
//				employee.setSalary(rs.getDouble("Sal"));
//				empList.add(employee);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Employee>findEmployeeByDept(){
		return null;
	}
	

	public void deleteEmployee(Employee emp)
	{
		empList.remove(emp);
	}
	public void insertEmployeeWithValues()
	{
		Connection conn=null;
		try {
			conn=DButil.getDBConnection();
			Statement stmt=conn.createStatement();
			
			int count=stmt.executeUpdate("insert into department_master values(8,'Information')");
			System.out.println("Record is inserted successfully!"+count);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			if(conn!=null)
			{
				try {
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void insertEmployee(Employee e)
	{
		Connection conn=null;
		try {
			conn=DButil.getDBConnection();
			String sql="insert into Emp values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, 0);
			pstmt.setDate(5, Date.valueOf(e.getHireDate()));
			pstmt.setDouble(6, e.getSalary());
			pstmt.setDouble(7, 0.0);
			pstmt.setString(8, e.getEmpName());
			
			int count1=pstmt.executeUpdate();
			
			System.out.println("Record is inserted successfully!!"+count1);
			
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}finally {
			if(conn!=null)
			{
				try {
					conn.close();
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}

//	public List<Employee>getEmployees(){
//		System.out.println("DAO-In getEmployee");
//		Employee employee=new Employee();
//		employee.setEmpNo(1);
//		employee.setEmpName("Hemant");
//		employee.setHireDate(LocalDate.of(2018, 11, 22));
//		employee.setSalary(8000);
//		employee.setJob("Software Developer");
//		empList.add(employee);
//		employee=new Employee();
//		employee.setEmpNo(2);
//		employee.setEmpName("Varsha");
//		employee.setHireDate(LocalDate.of(2018, 10, 21));
//		employee.setSalary(10000);
//		employee.setJob("Manager");
//		empList.add(employee);
//		return empList;
//	}


	@Override
	public Employee findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> findEmployeesByDept() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
