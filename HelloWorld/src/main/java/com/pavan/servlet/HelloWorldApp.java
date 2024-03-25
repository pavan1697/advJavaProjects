package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pavan")
public class HelloWorldApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Hello pavan here </h1>");
		writer.println("<h2>welcome to Advance java Classes</h2>");
		writer.println("<h3>By Ratan sir....</h3>");
		writer.println("<h4>Output success ewwwww....</h4>");
		writer.println("</html>");
	}

	
}
