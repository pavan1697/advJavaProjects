package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//step-1 get the data
		int EmpId=Integer.parseInt(request.getParameter("EmpId"));
		String EmpName=request.getParameter("EmpName");
		float EmployeeBasicSalary=Float.parseFloat(request.getParameter("EmployeeBasicSalary"));
		
		basic salary:
							>=50000:hra=30%ofbs,da=10%of bs & pf=6% of bs
							<50000 & >25000:hra=20%ofbs,da=5%of bs & pf=3% of bs	
							<25000:hra=10%ofbs,da=3%of bs & pf=2% of bs
			Gross salary=bs+hra+da-pf 
		//step-2 process the response
		float hra,da,pf,GrossSalary;
		if(EmployeeBasicSalary<25000)
		{
			hra=EmployeeBasicSalary*0.10f;
			da=EmployeeBasicSalary*0.03f;
			pf=EmployeeBasicSalary*0.02f;
		}
		else if(EmployeeBasicSalary>25000 && EmployeeBasicSalary<50000)
		{
			hra=EmployeeBasicSalary*0.20f;
			da=EmployeeBasicSalary*0.05f;
			pf=EmployeeBasicSalary*0.03f;
		}
		else
		{
			hra=EmployeeBasicSalary*0.30f;
			da=EmployeeBasicSalary*0.10f;
			pf=EmployeeBasicSalary*0.06f;
		}
			GrossSalary=EmployeeBasicSalary+hra+da-pf;
			
		//step-3 render the response
		
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<center><h1>Salary Calculation of Employee </h1>");
			writer.println("<center><h3>Employee Id:</h3>"+EmpId);
			writer.println("<center><h3>Employee Name:</h3>"+EmpName);
			writer.println("<center><h3>Employee Basic Salary:</h3>"+EmployeeBasicSalary);
			writer.println("<center><h3>HRA Amount:</h3>"+hra);
			writer.println("<center><h3>DA Amount:</h3>"+da);
			writer.println("<center><h3>PF Amount</h3>"+pf);
			writer.println("<center><h2>Gross-Salary:</h2>"+GrossSalary);
			writer.println("</html>"); */
		
		
		
		
		
		
		
		
		//read the data
		int employeeId=Integer.parseInt(request.getParameter("EmpId"));
		String employeeName=request.getParameter("EmpName");
		double employeesalary=Double.parseDouble(request.getParameter("EmployeeBasicSalary"));
		double hra,da,pf,grosssal,bs=employeesalary;
		//process the data
	
		
		
		if(bs>=50000)
		{
			 hra=(30*bs)/100;
			 da=(10*bs)/100;
			 pf=(6*bs)/100;
		}
		else if(bs<50000 && bs>25000 )
		{
		 hra=(20*bs)/100;
		 da=(5*bs)/100;
		 pf=(3*bs)/100;
		}
		else
		{
			 hra=(10*bs)/100;
			 da=(3*bs)/100;
			 pf=(2*bs)/100;
		}	
		 grosssal=bs+hra+da-pf;
		//Render the response
		response.setContentType("text/html");
				
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h1>Employee Salaryinfo</h1>");
		writer.println("Employee id is:"+employeeId);
		writer.println("<br><br>");
	    writer.println("Employee name is:"+employeeName);
	    writer.println("<br><br>");
	    writer.println("Employee salary is:"+employeesalary);
	    writer.println("<br><br>");
	    writer.println("Employee hra is:"+hra);
	    writer.println("<br><br>");
	    writer.println("Employee da is:"+da);
	    writer.println("<br><br>");
	    writer.println("Employee pf is:"+pf);
	    writer.println("<br><br>");
	    writer.println("Employee totalsal is:" +grosssal);
	    writer.println("<br><br>");
	    writer.println("</body>");
	    writer.println("</html>");
	}
}
