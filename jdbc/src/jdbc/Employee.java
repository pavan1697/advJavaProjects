
package jdbc;

public class Employee 
{
	private int EmpId;
	private String EmpName;
	private double Salary;
	public Employee(int empId, String empName, double salary) 
	{
		EmpId = empId;
		EmpName = empName;
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", Salary=" + Salary + "]";
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public Employee()
	{
		
	}
	
}