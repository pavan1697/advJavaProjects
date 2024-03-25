package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step-1:get the data from login form
		PrintWriter writer=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//step-2:process the data
		String status;
		if(username.equals("pavan")&&password.equals("Pavan@123"))
			status="Login successfull enjoy the day..";
		else
			status="sorry login fail try again with proper detials";
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1> Login status is :</h1>"+status);
		writer.println("</html>");
		
	}

	

}
