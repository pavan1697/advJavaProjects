package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step-1 get the data
				int FirstNum=Integer.parseInt(request.getParameter("FirstNum"));
				int SecondNum=Integer.parseInt(request.getParameter("SecondNum"));
				String operation=request.getParameter("operation");
		//step-2:Process the data
				int result=0;
				switch(operation)
				{
				case "+":result=FirstNum+SecondNum;
							break;
				case "-":result=FirstNum-SecondNum;
						break;
				
				case "*":result=FirstNum*SecondNum;
						break;
				
				case "/":result=FirstNum/SecondNum;
						break;
				
				case "%":result=FirstNum%SecondNum;
						break;
				
				}
		//step-3:render the response
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html>");
				writer.println("<center><h1>Your results are here </h1>");
				writer.println("<center><h4>First Number:</h4>"+FirstNum);
				writer.println("<center><h4>Second Number:</h4>"+SecondNum);
				writer.println("<center><h4>Operation selected is:</h4>"+operation);
				writer.println("<center><h4>Result:</h4>"+result);
				writer.println("</html>");
	}

}
