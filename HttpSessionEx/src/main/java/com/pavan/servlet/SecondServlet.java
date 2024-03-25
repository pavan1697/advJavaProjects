package com.pavan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		
		String Qualification=request.getParameter("Qualification");
		String Designation=request.getParameter("Designation");
		
		//create the httpsession object
		
		HttpSession session=request.getSession(false);
		
		//set the data into session object
		
		session.setAttribute("Qualification", Qualification);
		session.setAttribute("Designation", Designation);
		
		//to give the next form to client
		RequestDispatcher dispatch=request.getRequestDispatcher("Form3.html");
		dispatch.forward(request,response);
	}

}
