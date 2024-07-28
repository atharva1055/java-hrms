package atharva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class EmployeeService {
	
	HashSet<Employee> empset=new HashSet<Employee>();
	
	Employee emp1=new Employee(101, "Shital", 24, "Developer", "IT", 25000);
	Employee emp2=new Employee(102, "Meena", 26, "Tester","CO", 57000);
	Employee emp3=new Employee(103, "Bob", 20, "DevOps Eng","Admin", 5000);
	Employee emp4=new Employee(104, "Max", 27, "System Eng","CO",  70000);
	
	Scanner sc=new Scanner(System.in);
	boolean found=false;
	int id;
	String name;
	int age;
	String department;
	String desiganation;
	String status;
	double sal;
	
	public EmployeeService() {
		
		empset.add(emp1);
		empset.add(emp2);
		empset.add(emp3);
		empset.add(emp4);
		
	}
	
	//view all employees
	public void viewAllEmps() {
		for(Employee emp:empset) {
			System.out.println(emp);
		}
	}
	//view emp based on there id
	public void viewEmp(){
		
		System.out.println("Enter id: ");
		id=sc.nextInt();
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println(emp);
				found=true;
			}
			
		}
		if(!found) {
			System.out.println("Employee with this id is not present");
		}
	}
	//update the employee
	public void updateEmployee() {
		System.out.println("Enter id: ");
		id=sc.nextInt();
		boolean found=false;
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println("Enter name: ");
				name=sc.next();
				System.out.println("Enter new Salary");
				sal=sc.nextDouble();
				emp.setName(name);
				emp.setSalary(sal);
				System.out.println("Updated Details of employee are: ");
				System.out.println(emp);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Employee is not present");
		}
		else {
			System.out.println("Employee details updated successfully !!");
		}
	}
	//delete emp
	public void deleteEmp() {
		System.out.println("Enter id");
		id=sc.nextInt();
		boolean found=false;
		Employee empdelete=null;
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				empdelete=emp;
				found=true;
			}
		}
		if(!found) {
			System.out.println("Employee is not present");
		}
		else {
			empset.remove(empdelete);
			System.out.println("Employee deleted successfully!!");
		}
	}
	//add emp
	public void addEmp() {
		System.out.println("Enter id:");
		id=sc.nextInt();
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter age");
		age=sc.nextInt();
		System.out.println("enter Desiganation");
		desiganation=sc.next();
		System.out.println("Enter Department");
		department=sc.next();
		System.out.println("Enter sal");
		sc.nextDouble();
		
		Employee emp=new Employee(id, name, age, desiganation, department, sal);
		
		empset.add(emp);
		System.out.println(emp);
		System.out.println("Employtee addeed successsfully");
		Statement stmt = null;
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/astik", "root","Diya@1808");
			stmt = conn.createStatement();
			String sql = "INSERT INTO Employees values("+id+",'"+name+"',"+age+",'"+department+"','"+desiganation+"',"+sal+");";
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					conn.close();
				} 
			}catch(SQLException se) {
				
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
	public void attendance() {
		System.out.println("Enter id:");
		id=sc.nextInt();
		System.out.println("Enter emp_dept: ");
		String dept = sc.next();
		System.out.println("Enter Attendance date: ");
		String date = sc.next();
		System.out.println("Enter emp_Attendance");
		status = sc.next();
		Statement stmt = null;
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/astik", "root","Diya@1808");
			stmt = conn.createStatement();
			String sql = "INSERT INTO Attendence values("+id+",'"+dept+"','"+date+"','"+status+"');";
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					conn.close();
				} 
			}catch(SQLException se) {
				
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}}
