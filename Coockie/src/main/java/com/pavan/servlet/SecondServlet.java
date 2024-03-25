package com.pavan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		
				String Qualification=request.getParameter("Qualification");
				String Designation=request.getParameter("Designation");
				//create the httpsession object
				
				Cookie cookie3=new Cookie("Qualification", Qualification);
				Cookie cookie4=new Cookie("Designation", Designation);
				
				//set the data into session object
				
				response.addCookie(cookie3);
				response.addCookie(cookie4);
				
				//to give the next form to client
				RequestDispatcher dispatch=request.getRequestDispatcher("Form3.html");
				dispatch.forward(request,response);
	}
}
