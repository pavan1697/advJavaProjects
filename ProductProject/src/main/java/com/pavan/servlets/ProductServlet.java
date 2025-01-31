package com.pavan.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import java.sql.*;

@WebServlet("/ProductServlet")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data
				String proId=request.getParameter("proId");
				String proName=request.getParameter("proName");
				double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				String proBrand=request.getParameter("proBrand");
				String proMadeIn=request.getParameter("proMadeIn");
				Date proMnfgDate=Date.valueOf(request.getParameter("proMnfgDate"));
				Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
				
				//image
				Part part=request.getPart("proImage");
				InputStream inputstream=part.getInputStream();
				byte proImage[]=IOUtils.toByteArray(inputstream);	//conversion of input stream to byte[]
				
				//audio
				Part audiopart=request.getPart("proAudio");
				InputStream inputstream1=audiopart.getInputStream();
				byte proAudio[]=IOUtils.toByteArray(inputstream1);	
				
				//video
				Part videopart=request.getPart("proVideo");
				InputStream inputstream2=videopart.getInputStream();
				byte proVideo[]=IOUtils.toByteArray(inputstream2);	
				
				//using the above details create the product object
				Product product=new Product();
				product.setProId(proId);
				product.setProName(proName);
				product.setProPrice(proPrice);
				product.setProBrand(proBrand);
				product.setProMadeIn(proMadeIn);
				product.setProMnfgDate(proMnfgDate);
				product.setProExpDate(proExpDate);
				product.setProImage(proImage);
				product.setProAudio(proAudio);
				product.setProVideo(proVideo);
				
				//giving the product object into Dao layer
				ProductDao productDao=new ProductDao();
				int result=productDao.save(product);
				
				
				
				if(result==1)
				{
					//to send the data to JSP file add the data into request object
					request.setAttribute("SaveResult", result);
			       RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("Data insertion failed check it once..."+result);
					RequestDispatcher dispatcher=request.getRequestDispatcher("product.html");
					dispatcher.include(request, response);
				}
	}

}
