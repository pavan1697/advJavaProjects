package com.pavan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int ProdId=Integer.parseInt(request.getParameter("ProId"));
		String ProdName=request.getParameter("ProName");
		float ProdPrice=Float.parseFloat(request.getParameter("ProPrice"));
		int ProdQuantity=Integer.parseInt(request.getParameter("ProQuantity"));
		
		//step-2:process the data
		/*total bill:
					<1000 :no discount
					>1000 && <5000:5% discount
					>5000 && <10000:10%discount
					>10000:15%discount*/
		float total_bill=ProdPrice*ProdQuantity;
		float net_bill,discount;
		if(total_bill<1000)
			discount=0;
		else if(total_bill>1000 && total_bill<5000)
			discount=ProdPrice*0.05f;
		else if(total_bill>5000 && total_bill<10000)
			discount=ProdPrice*0.10f;
		else
			discount=ProdPrice*0.15f;
		net_bill=total_bill-discount;
		//step-3:render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<h4>Product Id is:</h4>"+ProdId);
		writer.println("<h4>Product name is:</h4>"+ProdName);
		writer.println("<h4>Product Price is:</h4>"+ProdPrice);
		writer.println("<h4>Product Quantity is:</h4>"+ProdQuantity);
		writer.println("<h2>Total bill is:</h4>"+total_bill);
		writer.println("<h4>Discount</h4>"+discount);
		writer.println("<h1>Net Bill with applied discount is:</h1>"+net_bill);
		writer.println("</html>");
	}

}
