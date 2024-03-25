package com.pavan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		
				String username=request.getParameter("username");
				String age=request.getParameter("age");
				
				//create the httpsession object
				
				Cookie cookie1=new Cookie("username", username);
				Cookie cookie2=new Cookie("age", age);
				
				//set the data into session object
				
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				
				//to give the next form to client
				RequestDispatcher dispatch=request.getRequestDispatcher("Form2.html");
				dispatch.forward(request,response);
	}
}
