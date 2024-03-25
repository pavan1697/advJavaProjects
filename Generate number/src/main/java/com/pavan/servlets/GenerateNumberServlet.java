package com.pavan.servlets;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateNumberServlet")

public class GenerateNumberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step-1 get the data
		int StartNum=Integer.parseInt(request.getParameter("StartNum"));
		int EndNum=Integer.parseInt(request.getParameter("EndNum"));
		String operation=request.getParameter("operation");
		
		//step-2:Process the data
		Operations o=new Operations();
		StringBuffer result = null;
		
		switch(operation)
		{
		case "Even":result=o.even(StartNum, EndNum);
						break;
					
		case "Odd":result=o.Odd(StartNum, EndNum);
						break;
		
		case "Prime":result=o.prime(StartNum, EndNum);
						break;
		
		case "Perfect":result=o.perfect(StartNum, EndNum);
						break;
		
		case "Strong":result=o.strong(StartNum, EndNum);
						break;
		case "Armstrong":result=o.armstrong(StartNum, EndNum);	
						break;
		
		}
		//step-3:render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<center><h1>Your results are here </h1>");
		writer.println("<center><h4>First Number:</h4>"+StartNum);
		writer.println("<center><h4>Second Number:</h4>"+EndNum);
		writer.println("<center><h4>Operation selected is:</h4>"+operation);
		writer.println("<center><h4>Result:</h4>"+result);
		writer.println("</html>");
	}

}
