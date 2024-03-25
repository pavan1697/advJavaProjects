package com.pavan.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		ProductDao dao=new ProductDao();
		Product existingproduct= dao.findById(proId);
		
		request.setAttribute("existingproduct", existingproduct);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("editform.jsp");
		dispatcher.forward(request, response);
		
	}

}
