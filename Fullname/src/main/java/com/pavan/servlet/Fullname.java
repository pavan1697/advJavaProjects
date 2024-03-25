package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Fullname")
public class Fullname extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Firstname=request.getParameter("Firstname");
		String Middlename=request.getParameter("Middlename");
		String Lastname=request.getParameter("Lastname");
		String fullname=Firstname+" "+Middlename+" "+Lastname;
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1> Your Full name is :</h1>"+fullname);
		writer.println("</html>");
		}

	
}
