package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//step-1: read the data from request object
				String username=request.getParameter("username");
				String Password=request.getParameter("Password");
				Long Mobile=Long.parseLong(request.getParameter("Mobile"));
				String Email=request.getParameter("Email");
				String Gender=request.getParameter("Gender");
				String DOB=request.getParameter("DOB");
				String Qualification[]=request.getParameterValues("Qualification");
				String Languages[]=request.getParameterValues("Languages");
				String Country=request.getParameter("Country");
				String Address=request.getParameter("Address");
				
				//step-2:process the data
				
				String qual=String.join(",", Qualification);
				String lang=String.join(",", Languages);
				
				//step-3:render the response
				
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				
				writer.println("<html>");
				writer.println("<body bgcolor='grey'>");
				writer.println("<h1> Your Registration Details are...");
				writer.println("<h4> Your UserName is:</h4>"+username);
				writer.println("<h4> Your Mobile number is:</h4>"+Mobile);
				writer.println("<h4> Your Email is:</h4>"+Email);
				writer.println("<h4> Your Gender is:</h4>"+Gender);
				writer.println("<h4> Country:</h4>"+Country);
				writer.println("<h4> Your Selected Languages are:</h4>"+lang);
				writer.println("<h4> Your Address is:</h4>"+Address);
				writer.println("</body>");
				writer.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String username=request.getParameter("username");
		String password=request.getParameter("Password");
		String gender=request.getParameter("Gender");
		long mblno=Long.parseLong(request.getParameter("Mobile"));
		String email=request.getParameter("Email");
		String dob=request.getParameter("DOB");
		String country=request.getParameter("Country");
		String comments=request.getParameter("Address");
		String quals[]=request.getParameterValues("Qualification");
		String langs[]=request.getParameterValues("Languages");
		
		
		String q=String.join(",",quals);
		String l=String.join(",", langs);
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgclor='pink'>");
		writer.println("<h1>Registration form....</h1><br>");
		writer.println("Username:"+username+"<br>");
		writer.println("Password :"+password+"<br>");
		writer.println("Gender:"+gender+"<br>");
		writer.println("Mobile no:"+mblno+"<br>");
		writer.println("Email id:"+email+"<br>");
		writer.println("Date of birth:"+dob+"<br>");
		writer.println("Country:"+country+"<br>");
		writer.println("Comments:"+comments+"<br>");
		writer.println("Qualification:"+q+"<br>");
		writer.println("Languages known:"+l+"<br>");
		writer.println("</body>");
		writer.println("</html>");*/

	}
}
