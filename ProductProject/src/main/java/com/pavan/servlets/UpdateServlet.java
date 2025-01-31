package com.pavan.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateServlet")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		String updatedproName=request.getParameter("proName");
		double updatedproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedproBrand=request.getParameter("proBrand");
		String updatedproMadeIn=request.getParameter("proMadeIn");
		Date updatedproMnfgDate=Date.valueOf(request.getParameter("proMnfgDate"));
		Date updatedproExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(updatedproName);
		product.setProPrice(updatedproPrice);
		product.setProBrand(updatedproBrand);
		product.setProMadeIn(updatedproMadeIn);
		product.setProMnfgDate(updatedproMnfgDate);
		product.setProExpDate(updatedproExpDate);
		
		//"newProImage" is the name of file input field
		Part filepart=request.getPart("newProImage");
		
		if(filepart !=null && filepart.getSize()>0)
		{
			InputStream inputStream=filepart.getInputStream();
			byte[] newImageData=IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);			
		}
	/*	else
		{
			Part file=request.getPart("existingImage");
			InputStream inputStream=file.getInputStream();
			byte[] existingImage=IOUtils.toByteArray(inputStream);
			product.setProImage(existingImage);
		}
		*/
		else
		{
			String s=request.getParameter("existingImage");
			byte[] existingImage=Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
		}
		
		ProductDao dao=new ProductDao();
		int result=dao.updateById(product);
		
		if(result==1)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Updation Failed try again");
			RequestDispatcher dispatcher=request.getRequestDispatcher("product.html");
			dispatcher.include(request, response);
		}
	}

}
