package com.pavan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		ProductDao pd=new ProductDao();
		int deletecount=pd.deleteById(proId);
		
		
		RequestDispatcher dispatcher=null;
		if(deletecount==1)
		{
			//to send the data to JSP file add the data into request object
			request.setAttribute("deleteresult", deletecount);
			dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("deleteresult", deletecount);
			dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
	}
}
