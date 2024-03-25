package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		
//				String email=request.getParameter("email");
//				Long mobile=Long.parseLong(request.getParameter("mobile"));
				
				//create the httpsession object
				
				HttpSession session=request.getSession(false);
				
				
				//to give the next form to client
				RequestDispatcher dispatch=request.getRequestDispatcher("Form3.html");
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html>");
				writer.println("<body>");
				writer.println("<pre style='bgcolor:grey'>");
				writer.println("Username:"+session.getAttribute("username"));
				writer.println("<br><br>");
				writer.println("Age:"+session.getAttribute("age"));
				writer.println("<br><br>");
				writer.println("Qualification:"+session.getAttribute("Qualification"));
				writer.println("<br><br>");
				writer.println("Designation:"+session.getAttribute("Designation"));
				writer.println("<br><br>");
				writer.println("Email:"+request.getParameter("email"));
				writer.println("<br><br>");
				writer.println("Mobile:"+request.getParameter("mobile"));
				writer.println("<br><br>");
				writer.println("</pre>");
				writer.println("<body>");
				writer.println("</html>");
	}

}
