package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
        Cookie cookies[]=request.getCookies();
		printWriter.println("<html>");
		printWriter.println("<body >");
		printWriter.println("<pre >");
		printWriter.println("username:"+cookies[0].getValue());
		printWriter.println("password:"+cookies[1].getValue());
		printWriter.println("qualification:"+cookies[2].getValue());
		printWriter.println("designation:"+cookies[3].getValue());
		printWriter.println("email:"+request.getParameter("email"));
		printWriter.println("Mobile:"+request.getParameter("mobile"));
		printWriter.println("</pre >");
		printWriter.println("</body>");
		printWriter.println("<html>");

	}

}
