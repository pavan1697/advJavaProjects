package jdbc;
import java.util.*;
public class DataBaseClient {

	public static void main(String[] args) 
	{
		EmployeeDao employeeDao = new EmployeeDao();
		
//		int rowcount1 = employeeDao.save(new Employee(101, "pavan", 15000));
//		
//		System.out.println("Data inserted sucessfully...."+" "+rowcount1);
//		
//		
//		int rowcount2 = employeeDao.save(new Employee(102, "malli", 10000 ));
//
//		
//		System.out.println("Data inserted sucessfully...."+" "+rowcount2);
//
//		
//		int rowcount3 = employeeDao.save(new Employee(103, "rajesh", 10000 ));
//
//		
//		System.out.println("Data inserted sucessfully...."+" "+rowcount3);
//
//
//		int rowcount4 = employeeDao.save(new Employee(104, "kalyan", 15000 ));
//
//		
//		System.out.println("Data inserted sucessfully...."+" "+rowcount4);
//
//		
//		Employee emp = employeeDao.findById(104);
//		System.out.println(emp);
//		
//		int result1 = employeeDao.deleteById(104);
//		if(result1!=0) {
//			System.out.println("deletion sucessfully....");
//		}
//		else {
//			System.out.println("deletion Failed....");
//		}
//		
//		int result2 = employeeDao.deleteBySalary(50000);
//		if(result2!=0) {
//			System.out.println("deletion sucessfully....");
//		}
//		else {
//			System.out.println("deletion Failed....");
//		}	
		
//		//display all employee data
//		List<Employee>emps=employeeDao.findAll();
//		for(Employee emp:emps)
//		{
//			System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getSalary());
//		}
		
//		int updatecount=employeeDao.updateSalary(10000, 2000);
//		System.out.println("salary updated successfully"+updatecount);
//		List<Employee>emps=employeeDao.findAll();
		
	}

}
